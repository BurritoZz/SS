package ss.week3.pw;
import ss.week2.hotel.Password;

public class TimedPassword extends Password {
	private long validTime;
	private long begin;
	
	public TimedPassword()	{
		this(25200000);
	}
	
	public TimedPassword(long exptime)	{
		validTime = exptime;
		begin = System.currentTimeMillis();
	}
	
	public boolean isExpired()	{
		return System.currentTimeMillis() - begin > validTime;
	}
	
	public boolean setWord(String oud, String probeersel)	{
		if (super.setWord(oud, probeersel))	{
			begin = System.currentTimeMillis();
			return true;
		}
		return false;
	}
}
