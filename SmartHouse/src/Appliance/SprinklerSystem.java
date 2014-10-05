package Appliance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import Interfaces.CheckState;
import Interfaces.WaterConsumer;

public class SprinklerSystem implements CheckState
{
	double rate;
	Map<String, SprinklerZone> zones;
	public SprinklerSystem() 
	{
		rate = 4;
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
		
		for(String i:zones.keySet())
		{
			SprinklerZone zone = zones.get(i);
			Map<Calendar,Calendar> temp = zone.getZoneTimes();
			for(Calendar start:temp.keySet())
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
	public void addSprinkler(String zone, String name)
	{
		zones.get(zone).addSprinkler(name);
	}
	public void addZoneTime(String zone, Calendar strat, Calendar end)
	{
		
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
		//Should check zoneTimes and see if there are any conflicting times with the start and end time
		//only check hour and minutes everything else dosent matter maybe Day: MTWRFSS
		public boolean addZoneSetting(Calendar start, Calendar end)
		{
			if(start.getTimeInMillis() > end.getTimeInMillis())
				return false;
			else
			{
				zoneTimes.put((Calendar)start.clone(), (Calendar)end.clone());
				return true;
			}
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
