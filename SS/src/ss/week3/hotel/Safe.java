package ss.week3.hotel;
/**
 * @author max
 * @version v1.0
 */
public class Safe {

	boolean active;
	boolean open;
	private Password pass;
	
	/**
	 * constructs a safe with the password pass.
	 */
	public Safe(String password) {
		pass = new Password();
		pass.setWord(pass.INITIAL, password);
		assert pass.testWord(password);
		active = false;
		open = false;
		assert active == false;
		assert open == false;
	}
	
	/**
	 * Sets safe to active if the provided string is the password.
	 * @param s - String to test as the password.
	 */
	//@ ensures (getPassword().testWord(password)) ? isOpen() == true : isOpen() == false;
	public void activate(String password) {
		if (pass.testWord(password)) {
			active = true;
			assert active == true;
		}
	}
	
	/**
	 * Sets safe to inactive.
	 */
	//@ ensures isActive() == false;
	public void deactivate() {
		active = false;
		assert active == false;
	}
	
	/**
	 * Sets safe to open if the provided string is the password.
	 * @param s - String to test as the password.
	 */
	//@ ensures (getPassword().testWord(password)) ? isOpen() : !isOpen();
	public void open(String password) {
		if (pass.testWord(password)) {
			open = true;
			assert open == true;
		}
	}
	
	/**
	 * Sets safe to closed.
	 */
	//@ ensures isOpen() == false  ;
	public void close() {
		open = false;
		assert open == false;
	}
	
	/**
	 * @return returns if the safe is active.
	 */
	/*@pure */ public boolean isActive() {
		return active;
	}
	
	/**
	 * @return returns if the safe is open.`
	 */
	/*@pure */ public boolean isOpen() {
		return open;
	}
	
	/**
	 * @return returns the password object.
	 */
	/*@pure */ public Password getPassword() {
		return pass;
	}

	
}
