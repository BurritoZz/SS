package ss.week2;


public class ThreewayLampEnum {

	public enum Setting { OFF, LOW, MEDIUM, HIGH }
	
	private Setting setting;
	
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	
	public ThreewayLampEnum() {
		setting = Setting.OFF;
	}
	
	//@ ensures \result == Setting.OFF || \result == Setting.LOW || \result == Setting.MEDIUM || \result == Setting.HIGH;
	/*@pure */ public Setting getSetting() {
		return setting;
	}
	
	//@ ensures getSetting() == Setting.OFF || getSetting() == Setting.LOW;
	//@ ensures getSetting() == Setting.MEDIUM || getSetting() == Setting.HIGH;
	public void switchSetting() {
		assert setting == Setting.OFF || setting == Setting.LOW;
		assert setting == Setting.MEDIUM || setting == Setting.HIGH;
		switch (setting) {
			case OFF:
				setting = Setting.LOW;
				break;
			case LOW:
				setting = Setting.MEDIUM;
				break;
			case MEDIUM:
				setting = Setting.HIGH;
				break;
			case HIGH:
				setting = Setting.OFF;
				break;
			default:
				assert false;
		}
	}
	
}
