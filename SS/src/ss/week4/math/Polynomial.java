package ss.week4.math;

public class Polynomial implements Function {
	private LinearProduct[] formule;
	private double sum;
	private double[] afgeleide;
	private String tekst;
	private double[] array;
	public Polynomial(double[] n)	{
		formule = new LinearProduct[n.length / 2];
		for (int i = 0; 2 * i + 1 < n.length; i++)	{
			formule[i] = new LinearProduct(n[i * 2], new Exponent((int) n[i * 2 + 1]));
		}
		array = new double[n.length];
		array = n;
	}

	@Override
	public double apply(double x) {
		sum = 0;
		for (int i = 0; i < formule.length; i++)	{
			sum = sum + formule[i].apply(x);
		}
		return sum;
	}

	@Override
	public Function derivative() {
		afgeleide = new double[formule.length * 2];
		for (int i = 0; i < array.length/2; i++)	{
			int j = i * 2;
			afgeleide[j] = array[j] * array[j + 1];
			afgeleide[j + 1] = array[j + 1] - 1;
		}
		return new Polynomial(afgeleide);
	}
	public String toString()	{
		tekst = "";
		for (int i = 0; i < formule.length; i++)	{
			tekst = tekst + formule[i].toString();
		}
		return tekst;
	}
}
