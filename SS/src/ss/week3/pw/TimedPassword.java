package ss.week3.pw;

import ss.week3.hotel.Password;

/**
 * @author max
 * @version V1.0
 */
public class TimedPassword extends Password {

	private long validTime;
	private static final long DEFAULTTIME = 1000000;
	private long exptime = DEFAULTTIME;
	
	/**
	 * Constructs TimedPassword with the parameter as the valid time.
	 * @param exptime - The time after which the password expires.
	 */
	public TimedPassword(long exptime) {
		this.exptime = exptime * 1000;
		validTime = System.currentTimeMillis() + exptime * 1000;
	}
	
	/**
	 * Constructs TimedPassword with a valid time of 1000000 milliseconds.
	 */
	public TimedPassword() {
		validTime = System.currentTimeMillis() + DEFAULTTIME;
	}
	
	private void resetTimer() {
		validTime = System.currentTimeMillis() + exptime;
	}
	
	/**
	 * Checks if the password is expired.
	 * @return Returns true if the password is expired
	 */
	/*@pure */ public boolean isExpired() {
		return System.currentTimeMillis() > validTime;
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (super.setWord(oldpass, newpass)) {
			resetTimer();
			return true;
		}
		return false;
	}
	
}
