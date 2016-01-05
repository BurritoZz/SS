package ss.week4.math;

public class Polynomial implements Function, Integrandable {
	private double[] formule;
	public Polynomial(double[] n)	{
		formule = n;
	}

	@Override
	public double apply(double x) {
		double sum = 0;
		for (int i = 0; i < formule.length; i++)	{
			sum += formule[i] * new Exponent(formule.length - i - 1).apply(x);
		}
		return sum;
	}

	@Override
	public Function derivative() {
		double[] afgeleide = new double[formule.length - 1];
		for (int i = 0; i < afgeleide.length; i++)	{
			afgeleide[i] = formule[i] * (formule.length - i - 1);
		}
		return new Polynomial(afgeleide);
	}
	
	public String toString()	{
		String tekst = formule[0] + " * x^" + (formule.length - 1);
		for (int i = 1; i < formule.length; i++)	{
			tekst = tekst + " + " + formule[i] + " * x^" + (formule.length - i - 1);
		}
		return tekst;
	}

	@Override
	public Function integrand() {
		double[] primitieve = new double[formule.length + 1];
		for (int i = 0; i < formule.length; i++)	{
			primitieve[i] = formule[i] / (formule.length - i);
		}
		primitieve[formule.length] = 0;
		return new Polynomial(primitieve);
	}
}
