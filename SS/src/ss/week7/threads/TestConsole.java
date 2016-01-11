package ss.week7.threads;

public class TestConsole extends Thread{
    
    public static void main(String[] args) {
	new TestConsole().start();
	new TestConsole().start();
    }

    public void run() {
	sum();
    }
    
    public void sum() {
	int a = Console.readInt("Thread " + getName() + " Get number 1? ");
	int b = Console.readInt("Thread " + getName() + " Get number 2? ");
	Console.println(a + " + " + b + " = " + (a + b));
    }

}
