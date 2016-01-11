package ss.week7.challenge.chatbox;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Vector;

/**
 * P2 prac wk5. <br>
 * Server. A Thread class that listens to a socket connection on a 
 * specified port. For every socket connection with a Client, a new 
 * ClientHandler thread is started. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server extends Thread {
    private int port;
    private MessageUI mui;
    private Collection<ClientHandler> threads;

    /** Constructs a new Server object */
    public Server(int portArg, MessageUI muiArg) {
        // TODO Add implementation
    }

    /**
     * Listens to a port of this Server if there are any Clients that 
     * would like to connect. For every new socket connection a new
     * ClientHandler thread is started that takes care of the further
     * communication with the Client.
     */
    public void run() {
        // TODO Add implementation
    }

    /**
     * Sends a message using the collection of connected ClientHandlers
     * to all connected Clients.
     * @param msg message that is send
     */
    public void broadcast(String msg) {
        // TODO Add implementation
    }

    /**
     * Add a ClientHandler to the collection of ClientHandlers.
     * @param handler ClientHandler that will be added
     */
    public void addHandler(ClientHandler handler) {
        // TODO Add implementation
    }

    /**
     * Remove a ClientHandler from the collection of ClientHanlders. 
     * @param handler ClientHandler that will be removed
     */
    public void removeHandler(ClientHandler handler) {
        // BODY TO BE ADDED
    }

}

