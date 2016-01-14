package ss.week7.cmdchat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * ClientHandler.
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class ClientHandler extends Thread {
    private Server server;
    private BufferedReader in;
    private BufferedWriter out;
    private String clientName;
    private Socket socket;
    private boolean running = true;

    /**
     * Constructs a ClientHandler object
     * Initialises both Data streams.
     */
    //@ requires serverArg != null && sockArg != null;
    public ClientHandler(Server serverArg, Socket sockArg) throws IOException {
	server = serverArg;
	socket = sockArg;
	in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	announce();
    }

    /**
     * Reads the name of a Client from the input stream and sends 
     * a broadcast message to the Server to signal that the Client
     * is participating in the chat. Notice that this method should 
     * be called immediately after the ClientHandler has been constructed.
     */
    public void announce() throws IOException {
	clientName = in.readLine();
        server.broadcast("[" + clientName + " has entered]");
    }

    /**
     * This method takes care of sending messages from the Client.
     * Every message that is received, is preprended with the name
     * of the Client, and the new message is offered to the Server
     * for broadcasting. If an IOException is thrown while reading
     * the message, the method concludes that the socket connection is
     * broken and shutdown() will be called. 
     */
    public void run() {
	while (running) {
	    try {
		if (in.ready()) {
		    String message = in.readLine();
		    server.broadcast(clientName + ": " + message);
		}
	    } catch (IOException e) {
		server.print("Er gaat iets heel erg mis in de run");
		shutdown();
	    }
	}
    }

    /**
     * This method can be used to send a message over the socket
     * connection to the Client. If the writing of a message fails,
     * the method concludes that the socket connection has been lost
     * and shutdown() is called.
     */
    public void sendMessage(String msg) {
	try {
	    out.write(msg);
	    out.newLine();
	    out.flush();
	} catch (IOException e) {
	    shutdown();
	}
    }

    /**
     * This ClientHandler signs off from the Server and subsequently
     * sends a last broadcast to the Server to inform that the Client
     * is no longer participating in the chat. 
     */
    private void shutdown() {
	running = false;
	try {
	    in.close();
	    out.close();
	    socket.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	server.removeHandler(this);
        server.broadcast("[" + clientName + " has left]");
    }
}
