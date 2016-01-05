package ss.week6.dictionaryattack;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class DictionaryAttack {
	private Map<String, String> passwordMap = new HashMap<String, String>();
	private Map<String, String> hashDictionary = new HashMap<String, String>();

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws FileNotFoundException 
	 */
	public void readPasswords(String filename) throws FileNotFoundException {
		Scanner file = new Scanner(new DataInputStream(new BufferedInputStream(new FileInputStream(filename))));
		while (file.hasNextLine())	{
			String[] regel = file.nextLine().split(": ");
			passwordMap.put(regel[0], regel[1]);
		}
		file.close();
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public String getPasswordHash(String password) {
		String res = "";
		try {
			res = Hex.encodeHexString(MessageDigest.getInstance("MD5").digest(password.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 * @throws NoSuchAlgorithmException 
	 */
	public boolean checkPassword(String user, String password) {
        String hash = getPasswordHash(password);
        if (passwordMap.containsKey(user))	{
        	return hash.equals(passwordMap.get(user));
        }
        return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 * @throws FileNotFoundException 
	 */
    public void addToHashDictionary(String filename) throws FileNotFoundException {
		Scanner file = new Scanner(new DataInputStream(new BufferedInputStream(new FileInputStream(filename))));
		while (file.hasNextLine())	{
			String wachtwoord = file.nextLine();
			hashDictionary.put(getPasswordHash(wachtwoord), wachtwoord);
		}
		file.close();
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		for (String user : passwordMap.keySet())	{
			if (hashDictionary.containsKey(passwordMap.get(user)))	{
				System.out.println(user + ": " + hashDictionary.get(passwordMap.get(user)));
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		DictionaryAttack da = new DictionaryAttack();
		da.readPasswords("LeakedPasswords.txt");
		da.addToHashDictionary("Passwords.txt");
		da.doDictionaryAttack();
	}

}
