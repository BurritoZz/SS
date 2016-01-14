package ss.week7.cmdchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
            = "usage: " + Server.class.getName() + " <port>";

    /** Start een Server-applicatie op. */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(USAGE);
            System.exit(0);
        }
        
        Server server = new Server(Integer.parseInt(args[0]));
        server.run();
        
    }


    private int port;
    private List<ClientHandler> threads;
    ServerSocket socket;
    private boolean running = true;
    /** Constructs a new Server object */
    public Server(int portArg) {
	threads = new ArrayList<ClientHandler>();
	this.port = portArg;
	try {
	    socket = new ServerSocket(port);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * Listens to a port of this Server if there are any Clients that 
     * would like to connect. For every new socket connection a new
     * ClientHandler thread is started that takes care of the further
     * communication with the Client.
     */
    public void run() {
	while (running) {
	   try {
	       ClientHandler temp = new ClientHandler(this, socket.accept());
	       addHandler(temp);
	       print("er is een client verbonden");
	   } catch (IOException e) {
	       e.printStackTrace();
	   }
	}
    }
    
    public void print(String message){
        System.out.println(message);
    }
    
    /**
     * Sends a message using the collection of connected ClientHandlers
     * to all connected Clients.
     * @param msg message that is send
     */
    public void broadcast(String msg) {
	print(msg);
	if (!threads.isEmpty()) {
	    for (ClientHandler handler : threads) {
	    	handler.sendMessage(msg);
	    }
	}
    }
    
    /**
     * Add a ClientHandler to the collection of ClientHandlers.
     * @param handler ClientHandler that will be added
     */
    public void addHandler(ClientHandler handler) {
	if (threads.equals(null)) {
	    print("threads is null");
	}
	if (handler.equals(null)) {
	    print("handler is null");
	}
        threads.add(handler);
        handler.start();
    }
    
    /**
     * Remove a ClientHandler from the collection of ClientHanlders. 
     * @param handler ClientHandler that will be removed
     */
    public void removeHandler(ClientHandler handler) {
	threads.remove(handler);
	print("Er is een client weggegaan");
    }
}
