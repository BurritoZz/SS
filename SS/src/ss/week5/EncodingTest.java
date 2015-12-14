package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello Big World";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        

        System.out.println(new String(Hex.decodeHex("4d6f64756c652032".toCharArray())));
        
        
        System.out.println(Base64.encodeBase64String("Hello World".getBytes()));
        

        System.out.println(Base64.encodeBase64String(Hex.decodeHex("010203040506".toCharArray())));
        

        System.out.println(new String(Base64.decodeBase64("U29mdHdhcmUgU31zdGVtcw==")));
        
        String as = "a";
        while (as.length() < 11)	{
        	System.out.println(new String(Base64.encodeBase64(as.getBytes())));
        	as += "a";
        }
    }
}
