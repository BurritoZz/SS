package ss.week2;

public class TestLamp {
	
    public static void main(String[] args) {
    	
    	ThreewayLampEnum lamp = new ThreewayLampEnum();
    	
    	for (int i = 0; i < 10; i++) {
    		System.out.println(lamp.getSetting());
    		lamp.switchSetting();
    	}
    	
    	
    }
}
