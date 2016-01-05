package ss.week1;

public class ThreewayLamp {
	
	int setting;
	
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	
	public ThreewayLamp() {
		setting = 0;
	}
	
	public int getSetting() {
		return setting;
	}
	
	public void switchSetting() {
		setting++;
		setting %= 4;
	}
	
}
