package ss.week6;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		String answer;
		Scanner scanner = new Scanner(System.in);
    
		while (true) {
		    System.out.println("Wat is je naam? ");
		    if (!scanner.hasNextLine()) {
		        break;
		    }
		    answer = scanner.hasNextLine() ? scanner.nextLine() : null;
		    if (answer.equals("")) {
		        break;
		    }
		    System.out.println("Hello " + answer);
		} 
		
		scanner.close();
	}
    
}
