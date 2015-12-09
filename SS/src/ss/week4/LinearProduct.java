package ss.week4;

public class LinearProduct extends Product {

	public LinearProduct(Constant func1, Function func2) {
		super(func1, func2);
	}

	public Function derivative() {
		return new Product(func1, func2.derivative());
	}

	public String toString() {
		return "f(x) = n * g(x)";
	}

}
