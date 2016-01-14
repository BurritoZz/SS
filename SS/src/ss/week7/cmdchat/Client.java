package ss.week7.cmdchat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * Client class for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Client extends Thread	{
	private static final String USAGE = "usage: java week7.cmdchat.Client <name> <address> <port>";

	/** Start een Client-applicatie op. */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println(USAGE);
			System.exit(0);
		}
		
		InetAddress host = null;
		int port = 0;

		try {
			host = InetAddress.getByName(args[1]);
		} catch (UnknownHostException e) {
			print("ERROR: no valid hostname!");
			System.exit(0);
		}

		try {
			port = Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			print("ERROR: no valid portnummer!");
			System.exit(0);
		}

		try {
			Client client = new Client(args[0], host, port);
			client.sendMessage(args[0]);
			client.start();
			
			do	{
				String input = readString("");
				client.sendMessage(input);
			} while (running);
			
		} catch (IOException e) {
			print("ERROR: couldn't construct a client object!");
			System.exit(0);
		}

	}
	
	private String clientName;
	private Socket sock;
	private BufferedReader in;
	private PrintWriter out;
	private static boolean running = true;

	/**
	 * Constructs a Client-object and tries to make a socket connection
	 */
	public Client(String name, InetAddress host, int port) throws IOException {
	    clientName = name;
	    sock = new Socket(host, port);
	    in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	    out = new PrintWriter(sock.getOutputStream(), true);
	}

	/**
	 * Reads the messages in the socket connection. Each message will
	 * be forwarded to the MessageUI
	 */
	public void run() {
	    try {
	    	while (running) {
	    		if (in.ready()) {
	    			String msg = in.readLine();
	    			System.out.println(msg);
	    		}
	    	}
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}

	/** send a message to a ClientHandler. */
	public void sendMessage(String msg) {
	    if (msg.equals("exit")) {
	    	shutdown();
	    } else {
	    	out.println(msg);
	    }
	}

	/** close the socket connection. */
	public void shutdown() {
		running = false;
		try {
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		print("Socket connection closed");
	}

	/** returns the client name */
	public String getClientName() {
		return clientName;
	}
	
	private static void print(String message){
		System.out.println(message);
	}
	
	public static String readString(String tekst) {
		System.out.print(tekst);
		String antw = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			antw = in.readLine();
		} catch (IOException e) {
		}

		return (antw == null) ? "" : antw;
	}
}