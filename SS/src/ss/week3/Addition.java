package ss.week3;

public class Addition implements OperatorWithIdentity {

	public int operate(int left, int right) {
		return left + right;
	}

	public int identity() {
		return 0;
	} 

}
