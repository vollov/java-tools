package org.demo.crypt;

import static org.junit.Assert.assertEquals;

import org.demo.crypt.CryptHelper;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test driver for CryptUtils
 * @author m34729
 */
public class TestCryptHelper {

	private static CryptHelper crypter;
	
    @BeforeClass
    public static void setUp() {
        // one-time initialization code   
    	// System.out.println("@BeforeClass - oneTimeSetUp");
    	// Initial with NRS default password nrs_ming
    	crypter = new CryptHelper("nrs_ming");
    }
    
	/**
	 * Test decrypt
	 */
	@Test
	public void decrypt(){
		String encryptedText = "gyNu3D7VT7DCaK6DXYqZcA==";
		String actual = crypter.decrypt(encryptedText);
		String expected = "James";
		//System.out.println(actual);
		assertEquals("decrypted result shoule be " + expected, actual, expected);
	}
	
	/**
	 * encrypt will never be same
	 */
	@Test
	public void encrypt(){
		String plainText = "James";
		String actual = crypter.encrypt(plainText);
		System.out.println(actual);
		
	}
}
