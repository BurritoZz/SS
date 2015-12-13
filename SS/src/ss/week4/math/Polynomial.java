package ss.week4.math;

public class Polynomial implements Function, Integrandable {
	public double[] formule;
	private double sum;
	private double[] afgeleide;
	private String tekst;
	public Polynomial(double[] n)	{
		formule = n;
	}

	@Override
	public double apply(double x) {
		sum = 0;
		for (int i = 0; i < formule.length; i++)	{
			sum += formule[i] * new Exponent(formule.length - i - 1).apply(x);
		}
		return sum;
	}

	@Override
	public Function derivative() {
		afgeleide = new double[formule.length - 1];
		for (int i = 0; i < afgeleide.length; i++)	{
			afgeleide[i] = formule[i] * (formule.length - i - 1);
		}
		return new Polynomial(afgeleide);
	}
	
	public String toString()	{
		//@requires formule.length > 0;
		tekst = formule[0] + " * x^" + (formule.length - 1);
		for (int i = 1; i < formule.length; i++)	{
			tekst = tekst + " + " + formule[i] + " * x^" + (formule.length - i - 1);
		}
		return tekst;
	}

	@Override
	public Function integrand() {
		afgeleide = new double[formule.length + 1];
		for (int i = 0; i < formule.length; i++)	{
			afgeleide[i] = formule[i] / (formule.length - i);
		}
		afgeleide[formule.length] = 0;
		return new Polynomial(afgeleide);
	}
}
