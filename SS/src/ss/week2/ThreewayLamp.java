package ss.week2;

public class ThreewayLamp {
	
	//@ invariant getSetting() >=0 && getSetting() <= 3;
	//@ invariant getSetting() == 0 || getSetting() == 1 || getSetting() == 2 || getSetting() == 3;
	private int setting;
	
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	
	//@ ensures getSetting() == 0;
	public ThreewayLamp() {
		setting = OFF;
	}
	
	//@ ensures \result == OFF || \result == LOW || \result == MEDIUM || \result == HIGH;
	/*@pure */ public int getSetting() {
		return setting;
	}
	
	//@ ensures getSetting() == (\old(getSetting()) + 1) % 4;
	//@ ensures getSetting() >= 0 && getSetting() <= 3;
	public void switchSetting() {
		assert setting >= 0 && setting <= 3;
		setting++;
		setting %= 4;
	}
	
}
