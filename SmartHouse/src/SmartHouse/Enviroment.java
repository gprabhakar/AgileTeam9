package SmartHouse;

public class Enviroment 
{
	double temperature; //F
	
	double humidity; 
	
	boolean raining;
	double precipitationPerHour;
	
	double sunIntensity; 
	
	public Enviroment()
	{
		temperature = 80;
		humidity = 50;
		
		raining = false;
		precipitationPerHour = 0;
		
		//no idea what's a good default value for this I know
		//it should probably be measured in lumens 
		sunIntensity = 90;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public boolean isRaining() {
		return raining;
	}

	public void setRaining(boolean raining, double rate) 
	{
		if(raining)
		{	
			this.raining = raining;
			precipitationPerHour = rate;
		}
		else
		{
			this.raining = false;
			precipitationPerHour = 0;
		}
	}

	public double getPrecipitationPerHour() {
		return precipitationPerHour;
	}

	public void setPrecipitationPerHour(double precipitationPerHour) {
		this.precipitationPerHour = precipitationPerHour;
	}

	public double getSunIntensity() {
		return sunIntensity;
	}

	public void setSunIntensity(double sunIntensity) {
		this.sunIntensity = sunIntensity;
	}
	
	
}
