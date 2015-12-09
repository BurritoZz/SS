package ss.week4.math;

public class Sum implements Function, Integrandable {
	private Function f1;
	private Function f2;
	public Sum(Function f1, Function f2)	{
		this.f1 = f1;
		this.f2 = f2;
	}
	@Override
	public double apply(double x) {
		return f1.apply(x) + f2.apply(x);
	}

	public Function integrand() {
		if (f1 instanceof Integrandable && f2 instanceof Integrandable)	{
			return new Sum(f1.integrand(), f2.integrand());
		}
	}
	
	@Override
	public Function derivative() {
		return new Sum(f1.derivative(), f2.derivative());
	}
	public String toString()	{
		return f1.toString() + " + " + f2.toString();
	}
}
