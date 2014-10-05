package Appliance;

import java.util.Calendar;
import java.util.HashMap;

import Interfaces.CheckState;
import Interfaces.ElectricityConsumer;

public class SecurityAlarm implements ElectricityConsumer, CheckState
{
	double rate=0.0;
	boolean activated;
	boolean alarm;
	boolean contactedPolice;
	boolean contactedHomeowners;
	Calendar alertTime;
	HashMap<String,String> userDirectory;
	
	public SecurityAlarm()
	{
		rate = .2;
		activated = false;
		contactedHomeowners = false;
		contactedPolice = false;
		userDirectory = new HashMap<String, String>();
		userDirectory.put("User","Email:user@email.com");
	}
	public void checkState(Calendar time)
	{
		if(activated)
		{
			if(alarm)
			{
				if(time.getTimeInMillis() - alertTime.getTimeInMillis() > 90000)
					contactPolice();
				else
					contactHomeowners();
			}
		}
	}
	public void intruderAlert(Calendar time)
	{
		System.out.println("Intruder Alarm");
		alarm = true;
		alertTime = time;
	}
	public void activate()
	{
		System.out.println("Alarm is Activated");
		activated = true;
	}
	public void deactivate()
	{
		System.out.println("Alarm is Deactivated");
		activated = false;
		alarm = false;
		contactedHomeowners = false;
		contactedPolice = false;
	}
	public void falseAlarm()
	{
		alarm = false;
		contactedHomeowners = false;
		contactedPolice = false;
	}
	public void contactPolice()
	{
		if(!contactedPolice)
		{	
			System.out.println("Calling 911");
			contactedPolice = true;
		}	
	}
	public void contactHomeowners()
	{
		if(!contactedHomeowners)
		{	
			System.out.println("Contacting Users:");
			for(String user: userDirectory.keySet())
			{
				System.out.println("Contacting User "+ user+" by method "+userDirectory.get(user));
			}
			contactedHomeowners=true;
		}	
	}
	@Override
	public String getConsumerType() {
		return type;
	}
	@Override
	public String getConsumerRate() {
		return rateUnit;
	}
	@Override
	public boolean isConsumerType(String type) {
		if(type.equals(ElectricityConsumer.type))
			return true;
		else
			return false;
	}
	@Override
	public double getAmmountConsumed(int hours, int minutes) 
	{
		return rate*hours + rate*(minutes/60);
	}
	@Override
	public void setConsumeRate(double rate) 
	{
		this.rate = rate;	
	}
	@Override
	public boolean isCheckState() 
	{
		return true;
	}
	@Override
	public String getName() 
	{
		return "Alarm";
	}
	
}
