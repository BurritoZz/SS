package ss.week7.challenge.chatbox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * P2 prac wk4. <br>
 * Client. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Client extends Thread {

	private String clientName;
	private MessageUI mui;
	private Socket sock;
	private BufferedReader in;
	private BufferedWriter out;

	/**
	 * Constructs a Client-object and tries to make a socket connection
	 */
	public Client(String name, InetAddress host, int port, MessageUI muiArg)
			throws IOException {
		// TODO Add implementation
	}

	/**
	 * Reads the messages in the socket connection. 
	 * Each message will be forwarded to the MessageUI
	 */
	public void run() {
		// TODO Add implementation
	}

	/** send a message to a ClientHandler. */
	public void sendMessage(String msg) {
		// TODO Add implementation
	}

	/** close the socket connection. */
	public void shutdown() {
		mui.addMessage("Closing socket connection...");
		// TODO Add implementation
	}

	/** returns the client name */
	public String getClientName() {
		return clientName;
	}

}
