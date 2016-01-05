package ss.week7.recipeserver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A sloppily programmed recipe server. 
 *
 */
public class RecipeServer extends Thread {
    private int port;
    
    public RecipeServer(int port) {
        this.port = port;
    }
    
    public void run() {
        try {
        	ServerSocket ssock = new ServerSocket(port,0,InetAddress.getByName("127.0.0.1"));
        	// If you want external hosts (i.e., not this computer) to connect to 
        	// this server you can use the following line instead. However, be careful 
        	// with that as this recipe server has some security issues!
        	// ServerSocket ssock = new ServerSocket(port);
            while (true) {
                 Socket sock = ssock.accept();
                 System.out.println("Client connected!");
                 ClientHandler handler = new ClientHandler(sock);
                 handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private static final String USAGE = "Expected parameter: <port>";
     
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(USAGE);
            System.exit(0);
        }
        
        String portString = args[0];
        int port = 0;
        
        // parse portnumber
        try {
            port = Integer.parseInt(portString);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + portString + " is not an integer");
            System.exit(0);
        }
        
        // And start the server
        RecipeServer s = new RecipeServer(port);
        System.out.println("Server starting.");
        s.start();
    }
}
