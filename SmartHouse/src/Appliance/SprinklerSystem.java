package Appliance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Interfaces.CheckState;
import Interfaces.WaterConsumer;

public class SprinklerSystem implements CheckState
{
	double rate;
	Map<String, SprinklerZone> zones = new HashMap<String, SprinklerZone>();
	public SprinklerSystem() 
	{
		rate = 4;
		zones = new HashMap<String, SprinklerSystem.SprinklerZone>();
	}
	public boolean addZone(String name)
	{
		if(zones.put(name, new SprinklerZone())!=null)
				return true;
		else
			return false;
	}
	public boolean removeZone(String name)
	{
		if(zones.remove(name)!=null)
			return true;
		else
			return false;
	}
	@Override
	public void checkState(Calendar time) 
	{
		int hour = time.get(Calendar.HOUR);
		int minute = time.get(Calendar.MINUTE);
		
		for(String i:zones.keySet()) //get each zone
		{
			SprinklerZone zone = zones.get(i);
			Map<Calendar,Calendar> temp = zone.getZoneTimes();
			for(Calendar start:temp.keySet()) //get each time interval 
			{
				if(start.get(Calendar.DAY_OF_WEEK) == time.get(Calendar.DAY_OF_WEEK)) //check for day of week 
				{	
					int starthour = start.get(Calendar.HOUR);
					int startminute = start.get(Calendar.MINUTE);
					if(hour>=starthour && minute>=startminute)
					{
						Calendar end = temp.get(start);
						int endhour = end.get(Calendar.HOUR);
						int endminute = end.get(Calendar.MINUTE);
						if(!zone.isActive() && hour<endhour && minute<endminute)
						{
							System.out.println("Sprinklers in zone "+i+" are on");
							zone.setActive(true);
							for(Sprinkler s:zone.getSrpinklers())
							{
								System.out.println("\tSprinkler "+s.getName()+" is on");
							}
						}	
					}
					else if(zone.isActive())
					{
						System.out.println("Sprinklers in zone "+i+" are off");
						zone.setActive(false);
					}
				}
			}
		}
	}
	public boolean addSprinkler(String zone, String name)
	{
		return zones.get(zone).addSprinkler(name);
	}
	public void addZoneTime(String zone, Calendar start, Calendar end)
	{
		SprinklerZone zone1 = zones.get(zone);
		zone1.addZoneSetting(start, end);
	}
	public void removeZoneTime(String zone, Calendar start, Calendar end)
	{
		SprinklerZone zone1 = zones.get(zone);
		zone1.removeZoneSetting(start, end);
	}
	@Override
	public boolean isCheckState() 
	{
		return true;
	}

	@Override
	public String getName() 
	{
		return "Sprinkler";
	}

	public class SprinklerZone
	{
		ArrayList<Sprinkler> sprinklers;
		boolean on;
		Map<Calendar,Calendar> zoneTimes;
		String description;
		public SprinklerZone()
		{
			on=false;
			zoneTimes = new HashMap<Calendar, Calendar>();
			sprinklers = new ArrayList<Sprinkler>();
		}
		public boolean isActive()
		{
			return on;
		}
		public void setActive(boolean active)
		{
			on = active;
		}
		public void setDescription(String des)
		{
			description = des;
		}
		public String getDescription()
		{
			return description;
		}
		public ArrayList<Sprinkler> getSrpinklers()
		{
			return sprinklers;
		}
		public Map<Calendar,Calendar> getZoneTimes()
		{
			return zoneTimes;
		}
		public boolean addSprinkler(String name)
		{
			return sprinklers.add(new Sprinkler(name));
		}
		public boolean removeSprinkler(String name)
		{
			for(int x =0;x<sprinklers.size();x++)
			{
				if(sprinklers.get(x).getName().equals(name))
				{
					if(sprinklers.remove(x)!=null)
						return true;
				}
			}
			return false;
		}
		//Start and End date must be in the same day
		public boolean addZoneSetting(Calendar start, Calendar end)
		{
			if(start.getTimeInMillis() > end.getTimeInMillis())
				return false;
			
			List<Calendar> keys = (List)zoneTimes.keySet();
			for(int x =0; x<keys.size();x++)
			{
				
				int newStartHour = start.get(Calendar.HOUR);
				int newStartMinute = start.get(Calendar.MINUTE);
				int newStartDay = start.get(Calendar.DAY_OF_WEEK);
				
				int newEndHour = end.get(Calendar.HOUR);
				int newEndMinute = end.get(Calendar.MINUTE);
				int newEndDay = end.get(Calendar.DAY_OF_WEEK);
				
				if(newStartDay != newEndDay) 
					return false;
				else
				{
					Calendar zoneTimeStart = keys.get(x);
					Calendar zoneTimeEnd = zoneTimes.get(zoneTimeStart);
					
					int startHour = zoneTimeStart.get(Calendar.HOUR);
					int startMinute = zoneTimeStart.get(Calendar.MINUTE);
					int startDay = zoneTimeStart.get(Calendar.DAY_OF_WEEK);
					
					int endHour = zoneTimeEnd.get(Calendar.HOUR);
					int endMinute = zoneTimeEnd.get(Calendar.MINUTE);
					
					int startMinutes = (startHour*60)+startMinute;
					int endMinutes = (endHour*60)+endMinute;
					
					int newStartMinutes = (newStartHour*60)+newStartMinute;
					int newEndMinutes = (newEndHour*60)+newEndMinute;
					
					if(startDay != newStartDay)
						return false;
					if(startMinutes < newStartMinutes && newStartMinutes > endMinutes)
						return false;
					if(startMinutes < newEndMinutes && newEndMinutes > endMinutes)
						return false;
					if(newStartMinutes < startMinutes && startMinutes > newEndMinutes)
						return false;
					if(newStartMinutes < endMinutes && endMinutes > newEndMinutes)
						return false;
				}
			}
			zoneTimes.put(start, end);
			return true;
		}
		public boolean removeZoneSetting(Calendar start, Calendar end)
		{
			List<Calendar> keys = (List)zoneTimes.keySet();
			for(int x =0; x<keys.size();x++)
			{
				Calendar time = keys.get(x);
				int hour = time.get(Calendar.HOUR);
				int minute = time.get(Calendar.MINUTE);
				int day = time.get(Calendar.DAY_OF_WEEK);
				
				int startHour = start.get(Calendar.HOUR);
				int startMinute = start.get(Calendar.MINUTE);
				int startDay = start.get(Calendar.DAY_OF_WEEK);
				
				if(startDay == day && startHour == hour && startMinute == minute)
				{
					Calendar time1 = keys.get(x);
					hour = time1.get(Calendar.HOUR);
					minute = time1.get(Calendar.MINUTE);
					day = time1.get(Calendar.DAY_OF_WEEK);
					
					int endHour = end.get(Calendar.HOUR);
					int endMinute = end.get(Calendar.MINUTE);
					int endDay = end.get(Calendar.DAY_OF_WEEK);
					
					if(endDay == day && endHour == hour && endMinute == minute)
					{	
						zoneTimes.remove(time);
						return true;
					}	
				}
			}
			return false;
		}
		
	}
	public class Sprinkler implements WaterConsumer
	{
		String name;
		double rate;
		
		public Sprinkler(String name)
		{
			this.name = name;
			rate = 4;
		}

		public String getName()
		{
			return name;
		}

		@Override
		public String getConsumerType() 
		{
			return "Water";
		}

		@Override
		public String getConsumerRate() 
		{	
			return rate+"";
		}

		@Override
		public boolean isConsumerType(String type) {
			if(type.equals(WaterConsumer.type))
				return true;
			else
				return false;
		}

		@Override
		public double getAmmountConsumed(int hours, int minutes) {
			return rate*hours + rate*(minutes/60);
		}

		@Override
		public void setConsumeRate(double rate) {
			this.rate = rate;
			
		}
	}
}
