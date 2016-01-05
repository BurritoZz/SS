package ss.week6.cards;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 * Testclass for input and output of Card.
 */
public class CardReader {
	private static BufferedReader reader;
	private static PrintWriter writer;
	private static DataInputStream dataIn;
	private static DataOutputStream dataOut;
	private static ObjectInputStream objectIn;
	private static ObjectOutputStream objectOut;

	private static Card read() throws EOFException {
		if (reader != null) {
			return Card.read(reader);
		} else if (dataIn != null) {
			return Card.read(dataIn);
		} else {
			return Card.read(objectIn);
		}
	}

	private static void write(Card k) throws IOException {
		if (writer != null) {
			k.write(writer);
		} else if (dataOut != null) {
			k.write(dataOut);
		} else {
			k.write(objectOut);
		}
	}

	private static void close() {
		try {
			if (reader != null) {
				reader.close();
			} else if (dataIn != null) {
				dataIn.close();
			} else {
				objectIn.close();
			}
		} catch (IOException exc) {
		}
		try {
			if (writer != null) {
				writer.close();
			} else if (dataOut != null) {
				dataOut.close();
			} else {
				objectOut.close();
			}
		} catch (IOException exc) {
		}
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: java CardReader "
					+ "[<filename>|-] [<filename>|-]");
			return;
		}

		try {
			if (args[0].equals("-")) {
				reader = new BufferedReader(new InputStreamReader(System.in));
			} else if (args[0].endsWith(".txt")) {
				reader = new BufferedReader(new FileReader(args[0]));
			} else if (args[0].endsWith(".dat")) {
				dataIn = new DataInputStream(new FileInputStream(args[0]));
			} else if (args[0].endsWith(".obj")) {
				objectIn = new ObjectInputStream(new FileInputStream(args[0]));
			} else {
				System.err.println("Format " + args[0] + " not recognised");
				return;
			}
		} catch (IOException exc) {
			System.err.println("Couldn't open " + args[0]);
		}

		try {
			if (args[1].equals("-")) {
				writer = new PrintWriter(System.out);
			} else if (args[1].endsWith(".txt")) {
				writer = new PrintWriter(new FileWriter(args[1]));
		    } else if (args[1].endsWith(".dat")) {
				dataOut = new DataOutputStream(new FileOutputStream(args[1]));
		    } else if (args[1].endsWith(".obj")) {
				objectOut = new ObjectOutputStream(
						new FileOutputStream(args[1]));
		    } else {
				System.err.println("Format " + args[0] + " not recognised");
				return;
			}
		} catch (IOException exc) {
			System.err.println("Couldn't open " + args[0]);
		}

		boolean doorgaan = true;
		while (doorgaan) {
			try {
				Card k = read();
				if (k == null) {
					System.err.println("Exception in input");
				} else {
					write(k);
				}
			} catch (EOFException exc) {
				doorgaan = false;
			} catch (IOException exc) {
				System.err.println(exc.getMessage());
			}
		}
		close();
	}
}
