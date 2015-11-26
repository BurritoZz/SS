package ss.week2.hotel;

/**
 * @author max
 * @version V1.0
 */
public class TimedPassword extends Password {

	private long validTime;
	private static final long DEFAULTTIME = 1000000;
	
	/**
	 * Constructs TimedPassword with the parameter as the valid time.
	 * @param exptime - The time after which the password expires.
	 */
	public TimedPassword(long exptime) {
		validTime = System.currentTimeMillis() + exptime;
	}
	
	/**
	 * Constructs TimedPassword with a valid time of 1000000 milliseconds.
	 */
	public TimedPassword() {
		validTime = System.currentTimeMillis() + DEFAULTTIME;
	}
	
	/**
	 * Checks if the password is expired.
	 * @return Returns true if the password is expired
	 */
	public boolean isExpired() {
		return System.currentTimeMillis() > validTime;
	}
	
}
