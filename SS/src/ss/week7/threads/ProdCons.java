package ss.week7.threads;

/**
 * Main class for Producer/Consumer program illustrating
 * multiple threads modifying a shared object. 
 * Illustrates the need for synchronisation and the use of wait and notify
 * This program is based on code provided by Deitel and Deitel <br>
 * ("Java How to program", 3rd ed., chapter 15, Prentice hall, 2001)
 * @author Revised by Rieks op den Akker
 * @version january 2002
 */
public class ProdCons {
	public static void main(String[] args) {
		IntCell cell = new UnsynchronizedIntCell();
		Thread prod1 = new IntProducer(1, cell);
		Thread prod2 = new IntProducer(2, cell);
		Thread cons1 = new IntConsumer(1, cell);
		Thread cons2 = new IntConsumer(2, cell);

		prod1.start();
		prod2.start();
		cons1.start();
		cons2.start();
	}
}

/**************************************************************************
 * (C) Copyright 1999 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
