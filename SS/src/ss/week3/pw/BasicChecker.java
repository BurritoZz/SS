package ss.week3.pw;

public class BasicChecker implements Checker {

	public static final String INITIAL = "qwerty7";
	
	public boolean acceptable(String test) {
		return !test.contains(" ") || test.length() > 5;
	}
	
	public String generatePassword() {
		return INITIAL;
	}

}
