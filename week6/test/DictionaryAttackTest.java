package ss.week6.test;

import org.junit.Before;
import org.junit.Test;
import ss.week6.dictionaryattack.DictionaryAttack;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testprogram for DictionaryAttack.
 * Lab Exercise SoftwareSystems
 * @author Jip Spel
 * @version $Revision: 1.0 $
 */
public class DictionaryAttackTest {

    /** Testvariabele for a <tt>DictionaryAttack</tt> object. */
    private DictionaryAttack dictionaryAttack;

    /** Path to the text file */
    private static final String PATH = "/Users/sarah.roediger/SSHome/eclipse-workspace/softwaresystems/src/ss/week6/test/"; //Your path to the test folder

    @Before
    public void setUp() throws IOException {
        dictionaryAttack = new DictionaryAttack();
        dictionaryAttack.readPasswords(PATH + "LeakedPasswords.txt");
    }

    /**
     * Test for <tt>getPasswordHash</tt>
     */
    @Test
    public void testGetPasswordHash() {
        try {
			assertEquals("5f4dcc3b5aa765d61d8327deb882cf99", dictionaryAttack.getPasswordHash("password"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    }

    /**
     * Test for <tt>checkPassword</tt>
     */
    @Test
    public void testCheckPassword() {
        assertTrue(dictionaryAttack.checkPassword("katrine", "spongebob"));
    }

}
