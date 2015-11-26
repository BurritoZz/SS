package ss.week1.test;

public class DollarsAndCentsCounter {

	int dollarCount;
	int centCount;
	
	public DollarsAndCentsCounter(){
		dollarCount = 0;
		centCount = 0;
	}
	
	public int dollars() {
		return dollarCount;
	}
	
	public int cents() {
		return centCount;
	}
	
	public void add (int dollars, int cents) {
		dollarCount += dollars;
		
		if (dollarCount < 0)
			dollarCount = 0;
		
		centCount += cents;
		
		if (centCount < 0) {
			dollarCount += (centCount / 100);
			centCount += (100 + centCount % 100);
		}
		if (centCount > 99){
			dollarCount += (centCount / 100);
			centCount = centCount % 100;
		}
	}
	
	public void reset() {
		dollarCount = 0;
		centCount = 0;
	}
	
}
