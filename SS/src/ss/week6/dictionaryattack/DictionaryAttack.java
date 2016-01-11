package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Hex;


public class DictionaryAttack {
	private Map<String, String> passwordMap = new HashMap<String, String>();
	private Map<String, String> hashDictionary = new HashMap<String, String>();
	private static BufferedReader reader;
	private static DataInputStream datain;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) {
	    try {
		reader = new BufferedReader(new FileReader(filename));
	    } catch (IOException e) {
		System.out.println("Couldn't open " + filename);
	    }
	    boolean cont = true;
	    try {
		while (cont) {
		    String line = reader.readLine();
		    if (line != null) {
			String[] split = line.split(": ");
			passwordMap.put(split[0], split[1]);
		    } else {
			cont = false;
		    }
	    	}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public String getPasswordHash(String password) {
	    byte[] buffer = password.getBytes();
	    try { 
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(buffer);
		byte[] digest = md.digest();
		return Hex.encodeHexString(digest);
	    } catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	    }
	   return null; 
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
	    String pw = getPasswordHash(password);
	    if (passwordMap.containsKey(user)) {
		return passwordMap.get(user).equals(pw);
	    }
	    return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
	 * the original password.
	 * @param filename filename of the dictionary.
	 */
    	public void addToHashDictionary(String filename) {
    	    try {
		reader = new BufferedReader(new FileReader(filename));
	    } catch (IOException e) {
		System.out.println("Couldn't open " + filename);
	    }
	    boolean cont = true;
	    try {
		while (cont) {
		    String line = reader.readLine();
		    if (line != null) {
			String hash = getPasswordHash(line);
			hashDictionary.put(hash, line);
		    } else {
			cont = false;
		    }
	    	}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
    	}
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
	    for (String user : passwordMap.keySet()) {
		if (hashDictionary.containsKey(passwordMap.get(user))) {
		    System.out.println(user + ": " + hashDictionary.get(passwordMap.get(user)));
		}
	    }
	}
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		da.readPasswords("LeakedPasswords.txt");
		da.addToHashDictionary("CommonPasswords.txt");
		da.doDictionaryAttack();
	}

}
