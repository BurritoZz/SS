package ss.week4;

public class Sum implements Function {

	public Function func1, func2;

	public Sum(Function f1, Function f2) {
		func1 = f1;
		func2 = f2;
	}

	public double apply(double d) {
		if (func1 == null) {
			return func2.apply(d);
		}
		if (func2 == null) {
			return func1.apply(d);
		}
		return func1.apply(d) + func2.apply(d);
	}

	public Function derivative() {
		return new Sum(func1.derivative(), func2.derivative());
	}

	public String toString(){
		return "f(x) = g(x) + f(x)";
	}
}
