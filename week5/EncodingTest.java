package ss.week5;

import java.util.ArrayList;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
	
	// Exercise 5.11 
	
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World Blah";
        System.out.println("Hex: " + Hex.encodeHexString(input.getBytes()));
        
       
 // ------------------------------------------------------------- //       
        
     // Exercise 5.12
        byte[] a = new byte[1000]; 
        String ab = "4d6f64756c652032";
        a = Hex.decodeHex(ab);
        String result = new String(a);
        
        System.out.println("Hex decoded: " + result); //waarom zou je hier .toCharArray() gebruiken?
        
        
        
  // ------------------------------------------------------------ //
     // Exercise 5.13
        
        String b64 = "Hello World";
        System.out.println("Base64: " + Base64.encodeBase64String(b64.getBytes()));
        
        // ----
        
        String hex = "010203040506";
        byte[] bArray = new byte[100];
        bArray = Base64.decodeBase64(hex);
        String sb = new String(bArray);
        System.out.println("B64 decode: " + sb);
        
        System.out.println("Base64 encoded: " + Base64.encodeBase64String(bArray));
        
        // -----
        
        String dec = "U29mdHdhcmUgU3lzdGVtcw==";
        byte[] arr = new byte[1000];
        arr = Base64.decodeBase64(dec);
        String s = new String(arr);
        System.out.println(s);
        
        // ----
        
        String first = "a";
        String second = "aa";
        String third = "aaa";
        String fourth = "aaaa";
        String fifth = "aaaaa";
        String last = "aaaaaaaaaaaaaa";
        
        System.out.println(Base64.encodeBase64(first.getBytes()));
        System.out.println(Base64.encodeBase64(second.getBytes()));
        System.out.println(Base64.encodeBase64(third.getBytes())); // ze hebben allemaal dezelfde length
        
    }
}
