package ss.week7.recipeserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;


public class ClientHandler extends Thread {
    private BufferedReader in;
    private BufferedWriter out;
    private Socket sock;
    
    public ClientHandler(Socket sock) throws IOException {
        in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        this.sock = sock;
    }
    
    public void run() {
        String msg;
        try {
            msg = in.readLine();
            while (msg != null) {
            	handleCommand(msg, out);
                out.newLine();
                out.flush();
                msg = in.readLine();                
            }
            shutdown();
        } catch (IOException e) {
            // For now, ignore and let thread stop.
        }

    }
    
    final static String LIST_COMMAND = "LIST";
    final static String GET_COMMAND = "GET";
    /**
     * Handle server commands
     * @param msg command from client
     * @param out Writer to to write the result to.
     * @throws IOException 
     */
    private void handleCommand(String msg, Writer out) throws IOException {
    	if (msg.equals(LIST_COMMAND)) {
    		System.out.println("Listing recipes.");
    		listRecipes(out);
    	} else if (msg.startsWith(GET_COMMAND + " ")){
    		System.out.println("Showing recipe.");
    		String recipeName = msg.substring(GET_COMMAND.length() + 1);
    		showRecipe(recipeName, out);
    	} else {
    		out.write("ERROR: unknown command.");
    	}
    }

    /**
     * List available recipes.
     * @param out
     * @throws IOException
     */
    private void listRecipes(Writer out) throws IOException {
    	File[] files = new File("recipes").listFiles();
    	for (File file : files) {
			out.write(file.getName() + System.lineSeparator());
		}
    }
    
    /**
     * Retrieve a recipe and output to client.
     * @param recipeName
     * @param out
     * @throws IOException 
     */
    private void showRecipe(String recipeName, Writer out) throws IOException {
    	String recipeFilename = "recipes" + File.separator + recipeName;
    	System.out.println("Sending " + recipeFilename);
    	BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(recipeFilename));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}

    	try {
    		String line = br.readLine();

    		while (line != null) {
				out.write(line + System.lineSeparator());
    			line = br.readLine();
    		}
    	} finally {
    		br.close();
    	}
    	// This silly server uses a special string to signal it is done
    	// sending lines.
    	out.write("--EOT--");
    }
    
    private void shutdown() {
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
