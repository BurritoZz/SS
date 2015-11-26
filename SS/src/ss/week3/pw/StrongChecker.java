package ss.week3.pw;

public class StrongChecker extends BasicChecker {

	public static final String INITPASS = "qwerty7";
	
	
	public boolean acceptable(String test) {
		return super.acceptable(test) && Character.isAlphabetic(test.charAt(0)) && Character.isDigit(test.charAt(test.length() - 1));
	}
	
	public String generatePassword() {
		return INITPASS;
	}
}
