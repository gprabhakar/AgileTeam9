package Interfaces;

public interface Consumer 
{	
	public String getConsumerType();
	public String getConsumerRate();
	public boolean isConsumerType(String type);
	public double getAmmountConsumed(int hours, int minutes);
	public void setConsumeRate(double rate);
}
