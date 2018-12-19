package ss.week6.dictionaryattack;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;
	private static final String PATH = "/Users/sarah.roediger/SSHome/eclipse-workspace/softwaresystems/src/ss/week6/dictionaryattack/";

	
	public DictionaryAttack() {
		passwordMap = new HashMap<String, String>();
		hashDictionary = new HashMap<String, String>();
	}
	
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
		
		File file = new File(filename);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String temp;
		String[] split = new String[2];
		while (sc.hasNextLine()) {
			temp = sc.nextLine();
			split = temp.split(": ");
			passwordMap.put(split[0], split[1]);
		}
		sc.close();
		
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public String getPasswordHash(String password) throws NoSuchAlgorithmException {
    	MessageDigest MD5 = MessageDigest.getInstance("MD5");
    	byte[] passHash = MD5.digest(password.getBytes());
    	String result = Hex.encodeHexString(passHash);
    	return result;
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        Set<String> users = passwordMap.keySet();
        
        for (String u:users) {
        	if (u.equals(user)) {
        		try {
					if (passwordMap.get(user).equals(getPasswordHash(password))) {
						return true;
					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
        	}
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
    	Scanner sc = null;
    	
		try {
			sc = new Scanner(new FileReader(filename));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
    	String temp;
    	while (sc.hasNextLine()) {
    		temp = sc.nextLine();
    		try {
				hashDictionary.put(temp, getPasswordHash(temp));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
    	}
    	sc.close();
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		Set<String> users = passwordMap.keySet();
		Set<String> pass = hashDictionary.keySet();
		
		for (String u:users) {
			for (String p:pass) {
				if (passwordMap.get(u).equals(hashDictionary.get(p))) {
					System.out.println(u + ": " + p);
				}
			}
			
		}
	}
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		da.readPasswords(PATH + "LeakedPasswords.txt");
		System.out.println("The leaked passwords are read");
		da.addToHashDictionary(PATH + "dictionary.txt");
		System.out.println("The hash dictionary is ready");
		da.doDictionaryAttack();
		System.out.println("The attack is completed!");
	}

}
