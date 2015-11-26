package ss.week1;

/**
 * 
 * @author max
 * @version v1.0
 */
public class Password {

	public static final String INITIAL = "admin123";
	private String password;
	
	/**
	 * constructs a <code>Password</code> with the initial word provided in INITIAL.
	 */
	public Password() {
		password = INITIAL;
	}
	/**
	 * Tests if password is acceptable.
	 * @param suggestion for the password
	 * @return returns true if the password is longer than six characters 
	 * 		   and if it does not contain a space.
	 */
	public boolean acceptable(String suggestion) {
		if (suggestion.length() < 6 || suggestion.contains(" ")) {
			return false;
		}
		return true;
	}
	
	/**
	 * Tests if a given word is equal to the password.
	 * @param word - The word that is to be tested.
	 * @return returns true if the word is equal to the password.
	 */
	public boolean testWord(String word) {
		if (password.equals(word)) {
			return true;
		}
		return false;
	}
	/**
	 * sets the password to a new word.
	 * @param oldpass - the old password
	 * @param newpass - the new password
	 * @return returns true if the oldpass is equal to the old password
	 * 		   and if newpass is acceptable.
	 */
	public boolean setWord(String oldpass, String newpass) {
		if (testWord(oldpass) && acceptable(newpass)) {
			password = newpass;
			return true;
		}
		return false;
	}
	
	
}
