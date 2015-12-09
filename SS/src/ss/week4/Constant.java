package ss.week4;

public class Constant implements Function {

	public double val;
	
	public Constant(double val) {
		this.val = val;
	}

	public double apply(double d) {
		return val;
	}

	public Function derivative() {
		return new Constant(0);
	}
	
	public String toString() {
		return "" + val;
	}
}
