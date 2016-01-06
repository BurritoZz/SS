/**
 * 
 */
package ss.week7.threads;

/**
 * @author ®ik
 *
 */
public class TestConsole extends Thread {
	public TestConsole(String naam)	{
		setName(naam);
	}
	public static void main(String[] args)	{
		new TestConsole("1").start();
		new TestConsole("2").start();
	}
	public void run()	{
		sum();
	}
	private void sum()	{
		int een = Console.readInt("Thread " + getName() + ": get number 1? ");
		int twee = Console.readInt("Thread " + getName() + ": get number 2? ");
		Console.println("Thread " + getName() + ": " + een + " + " + twee + " = " + (een + twee));
	}
}