package TestBed;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import Appliance.SecurityAlarm;
import Appliance.SprinklerSystem;
import SmartHouse.SmartHouse;

public class TestBed 
{
	
	SmartHouse house;
	Calendar time;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private Calendar startDate;
	private Calendar endDate;
	
	long delay; //delay in milliseconds
	int interval; //time interval in minutes 
	
	public void StartTest()
	{
		/*TestBed test = new TestBed();
		test.init();
		Calendar time = Calendar.getInstance();
		test.setStartDate(time);
		time.add(Calendar.HOUR, 2);
		test.setEndDate(time);
		test.run();*/
		
	}
	public TestBed()
	{
		time = Calendar.getInstance();
		delay = 100;
		interval = 30;
	}
	public void setStartDate(Calendar start)
	{
		startDate = (Calendar)start.clone();
	}
	public boolean setEndDate(Calendar end)
	{
		if(end.getTimeInMillis() - startDate.getTimeInMillis() > 0)
		{
			endDate = (Calendar)end.clone();
			return true;
		}	
		return false;
	}
	public void init()
	{
		house = new SmartHouse();
		SecurityAlarm alarm = new SecurityAlarm();
		house.addConsumer(alarm);
		house.addStateAppliance(alarm);
		SprinklerSystem sprinkler= new SprinklerSystem();
		sprinkler.addZone("Zone 1");
		sprinkler.addZone("Zone 2");
		
	}
	public void run()
	{
		Calendar current = startDate;
		
		while(endDate.getTimeInMillis() > current.getTimeInMillis())
		{	
			house.checkState(current);
			current.add(Calendar.MINUTE, interval);
			try 
			{
				Thread.sleep(delay);
			} 
			catch (InterruptedException e) 
			{

				e.printStackTrace();
			}
		}
	}
}
