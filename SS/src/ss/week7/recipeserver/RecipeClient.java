package ss.week7.recipeserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A client for a sloppily programmed recipe server.
 *
 */
public class RecipeClient {
    private static final String USAGE = "usage: <address> <port>";
  

    
    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(0);
        }
        
        InetAddress addr = null;
        int port = 0;
        Socket sock = null;

        // check args[1] - the IP-adress
        try {
            addr = InetAddress.getByName(args[0]);
        } catch (UnknownHostException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: host " + args[0] + " unknown");
            System.exit(0);
        }

        // parse args[2] - the port
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[1] + " is not an integer");
            System.exit(0);
        }
        
        
        String command = "LIST";


        // try to open a Socket to the server
        try {
            sock = new Socket(addr, port);
        } catch (IOException e) {
            System.out.println("ERROR: could not create a socket on " + addr
                    + " and port " + port);
        }
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    sock.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    sock.getOutputStream()));
            
            int rNum = -1;
            Scanner userIn = new Scanner(System.in);
            
            out.write(command);
            out.newLine();
            out.flush();
            List<String> recipeNames = new ArrayList<String>();
            String line = in.readLine();
            while (line != null && !line.equals("")) {
            	recipeNames.add(line);
            	line = in.readLine();
            }
            do {
                System.out.println("Available recipes on server:");
            	for (int i = 0; i < recipeNames.size(); i++) {
            		System.out.printf("%3d: %s" + System.lineSeparator(),i+1, recipeNames.get(i));
				}
	            System.out.print("Enter recipe number (or 0 to exit): ");
	            System.out.flush();
	            if (userIn.hasNextInt()) {
	            	rNum = userIn.nextInt();
	            } else {
	            	System.out.println("Invalid input, try again.");
	            	userIn.next();
	            }
	            if (rNum > 0 && rNum < recipeNames.size()+1) {
		            out.write("GET " + recipeNames.get(rNum-1));
		            out.newLine();
		            out.flush();
		            System.out.println("Recipe text:");
		            System.out.println("------");
		            line = in.readLine();
		            while (line != null && !line.equals("--EOT--")) {
		            	// The server uses a special string ("--EOT--") to mark the end of a recipe.
		            	System.out.println(line);
		            	line = in.readLine();
		            }
		            System.out.println("------");
	            } else {
	            	System.out.println("Invalid recipe number, try again.");
	            }
            } while (rNum != 0);
            System.out.println("Exiting.");
            userIn.close();
        } catch (IOException e) {
            System.out.println("ERROR: unable to communicate to server");
            e.printStackTrace();
        }   
    }
}
