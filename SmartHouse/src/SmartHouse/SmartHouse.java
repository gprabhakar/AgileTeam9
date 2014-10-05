package SmartHouse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Interfaces.CheckState;
import Interfaces.Consumer;

public class SmartHouse 
{
	Calendar time = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	Enviroment houseEnviroment;
	
	ArrayList<Consumer> consumers;
	ArrayList<CheckState> stateAppliances;
	
	public SmartHouse()
	{
		time = Calendar.getInstance();
		consumers = new ArrayList<Consumer>();
		houseEnviroment = new Enviroment();
		stateAppliances = new ArrayList<CheckState>();
	}
	public void checkState(Calendar time)
	{
		for(CheckState state:stateAppliances)
		{
			state.checkState(time);
		}
	}
	public SmartHouse(Calendar simulatedTime)
	{
		time = simulatedTime;
		consumers = new ArrayList<Consumer>();
		houseEnviroment = new Enviroment();
		stateAppliances = new ArrayList<CheckState>();
	}
	public boolean addStateAppliance(CheckState state)
	{
		return stateAppliances.add(state);
	}
	public boolean removeStateAppliance(CheckState state)
	{
		return stateAppliances.remove(state);
	}
	public boolean addConsumer(Consumer c)
	{
		return consumers.add(c);
	}
	public boolean removeConsumer(Consumer c)
	{
		return consumers.remove(c);
	}
	public double calculateConsumption(String type, int hours, int minutes)
	{
		double consumed=0;
		for(Consumer c:consumers)
		{
			if(c.isConsumerType(type))
			{
				consumed+=c.getAmmountConsumed(hours, minutes);
			}
		}
		return consumed;
	}
	public void sendNotification(String message)
	{
		System.out.println(sdf.format(time.getTime())+":"+message);
	}
	public Enviroment getEnviroment()
	{
		return houseEnviroment;
	}
}
