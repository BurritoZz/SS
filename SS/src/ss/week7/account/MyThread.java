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

}
