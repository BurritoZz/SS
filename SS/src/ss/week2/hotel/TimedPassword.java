package ss.week2.hotel;

public class TimedPassword extends Password {
	private long validTime;
	private long defaultTime = 25200000;
	private long begin;
	
	public TimedPassword()	{
		validTime = defaultTime;
		begin = System.currentTimeMillis();
	}
	
	public TimedPassword(long exptime)	{
		validTime = exptime;
		begin = System.currentTimeMillis();
	}
	
	public boolean isExpired()	{
		return System.currentTimeMillis() - begin < validTime;
	}
}
