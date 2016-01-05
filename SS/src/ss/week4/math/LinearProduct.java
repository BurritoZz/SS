package ss.week4.math;

public class LinearProduct extends Product implements Integrandable	{
	public LinearProduct(Constant c, Function f2) {
		super(c, f2);
	}
	public LinearProduct(Function f2, Constant c)	{
		super(c, f2);
	}

	@Override
	public Function derivative() {
		return new LinearProduct((Constant) f1, f2.derivative());
	}
	@Override
	public Function integrand() {
		if (f2 instanceof Integrandable)	{
			return new LinearProduct((Constant) f1, ((Integrandable) f2).integrand());
		}
		return null;
	}
}
