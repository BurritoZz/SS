package ss.week1;

public class TestLamp {
	
    public static void main(String[] args) {
    	
    	ThreewayLamp lamp = new ThreewayLamp();
    	
    	for (int i = 0; i < 10; i++) {
    		System.out.println(lamp.getSetting());
    		lamp.switchSetting();
    	}
    	
    	
    }
}
