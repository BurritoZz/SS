package ss.week4;

public class Product implements Function {

	public Function func1, func2;

	public Product(Function func1, Function func2) {
		this.func1 = func1;
		this.func2 = func2;
	}

	public double apply(double d) {
		return func1.apply(d) * func2.apply(d);
	}

	public Function derivative() {
		return new Sum(new Product(func1.derivative(), func2), new Product(func1, func2.derivative()));
	}

	public String toString(){
		return "f(x) = g(x) * h(x)";
	}

}
