package ss.week7;

public class ConcatThread extends Thread {
    private static String text = ""; // global variable
    private String toe;

    public ConcatThread(String toeArg) {
        this.toe = toeArg;
    }

    public void run() {
    	if (toe.equals("one;"))	{
    		text = text.concat(toe);
   		} else if (toe.equals("two;"))	{
   			while (text.equals(""))	{
   				
   			}
    		text = text.concat(toe);
    	}
    }

    public static void main(String[] args) {
    	Thread t1 = new ConcatThread("one;");
    	Thread t2 = new ConcatThread("two;");
    	t1.start();
    	t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(text);
    }
}
