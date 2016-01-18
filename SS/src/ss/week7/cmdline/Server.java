
package ss.week7.cmdline;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";
    private static ServerSocket socket;
    public static boolean running = true;

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	if (args.length != 2) {
    		System.out.println(USAGE);
    		System.exit(0);
    	}
    	
    	String name = args[0];
    	int port = 0;
    	socket = null;
    	
    	//parse arg[2] - the port
    	try {
    		port = Integer.parseInt(args[1]);
    	} catch (NumberFormatException e) {
    		System.out.println(USAGE);
    		System.out.println("ERROR: port " + args[1] + " is not an integer");
    		System.exit(0);
    	}
    	
    	//try to open the serversocket
    	try {
    		socket = new ServerSocket(port);
    	} catch (IOException e) {
    		System.out.println("ERROR: could not create a socket on port " + port);
    	}
	
    	//create Peer object
    	try {
    		Peer peer = new Peer(name, socket.accept());
    		Thread streamInputHandler = new Thread(peer);
    		streamInputHandler.start();
    		while (peer.running) {
    			peer.handleTerminalInput();
    		}
    		peer.shutDown();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

} // end of class Server