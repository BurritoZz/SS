package ss.week7.account;

public class MyThread extends Thread{

    private double amount;
    private int frequency;
    private Account account;

    public MyThread(double amount, int frequency, Account account) {
	this.amount = amount;
	this.frequency = frequency;
	this.account = account;
    }
    
    public void run() {
	for (int i = 0; i < frequency; i++) {
	    try {
		account.transaction(amount);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

}
