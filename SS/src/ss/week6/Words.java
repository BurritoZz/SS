package ss.week6;

import java.util.Scanner;

public class Words {
    
    public static void main(String[] args) {
        String answer;
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("Line (or \"end\"): ");
            if (!scanner.hasNextLine()) {
                break;
            }
            answer = scanner.hasNextLine() ? scanner.nextLine() : null;
            if (answer.equals("end")) {
                break;
            }
            Scanner scanner2 = new Scanner(answer);
            int i = 1;
            while (scanner2.hasNext()) {
                System.out.println("Word " + i + ": " + scanner2.next());
                i++;
            }
        } 
        
        scanner.close();
    }

}
