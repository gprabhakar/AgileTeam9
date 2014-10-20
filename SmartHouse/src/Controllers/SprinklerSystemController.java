package Controllers;

import java.util.Calendar;

import Appliance.SprinklerSystem;

public class SprinklerSystemController 
{
	SprinklerSystem sprinklers;
	
	public boolean initiateSprinklerSystem()
	{
		if(sprinklers==null)
		{	
			sprinklers = new SprinklerSystem();
			return true;
		}
		else
			return false;
	}
	public void checkState(Calendar time)
	{
		sprinklers.checkState(time);
	}
	public boolean addSprinklerZone(String name)
	{
		return sprinklers.addZone(name);
	}
	public boolean removeSprinklerZone(String name)
	{
		return sprinklers.removeZone(name);
	}
	public boolean addSprinkler(String zoneName, String name)
	{
		return sprinklers.addSprinkler(zoneName, name);
	}
	public boolean removeSprinkler(String zoneName, String name)
	{
		return sprinklers.removeSprinkler(zoneName, name);
	}
	//Zone times must be in the same day of week
	//weekdays goes in the order SMTWRFS
	public void addZoneTime(String zone, Calendar start, Calendar end, boolean[] weekdays)
	{
		for(int x = 0;x<weekdays.length;x++)
		{
			if(weekdays[x])
			{
				start.set(Calendar.DAY_OF_WEEK, x);
				end.set(Calendar.DAY_OF_WEEK, x);
				sprinklers.addZoneTime(zone, start, end);
			}
		}
	}
	public void removeZoneTime(String zone, Calendar start, Calendar end, boolean[] weekdays)
	{
		for(int x = 0;x<weekdays.length;x++)
		{
			if(weekdays[x])
			{
				start.set(Calendar.DAY_OF_WEEK, x);
				end.set(Calendar.DAY_OF_WEEK, x);
				sprinklers.removeZoneTime(zone, start, end);
			}
		}
	}
}
