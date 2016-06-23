package org.demo.crypt;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test driver for CryptUtils
 * @author m34729
 */
public class TestCryptHelper {

	private static CryptHelper crypter;
	
    @Before
    public void setUp() {
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
		crypter = new CryptHelper("mcap2Lo90p");//
		//HU63YUX4b7F+HRRpIRIhQg==
		System.out.println("result is " + crypter.decrypt("THle31R2Nhh1AcHjQhqe6E4DRvv1LiWK"));
	}
	
	/**
	 * encrypt will never be same
	 */
	@Test
	public void encrypt(){
		//String plainText = "";
		String plainText = "James";
		String actual = crypter.encrypt(plainText);
		System.out.println(actual);
		
	}
	
	@Test
	public void remove(){
		List<String> toppings = new ArrayList<String>();
		toppings.add("Cheese");
		toppings.add("Pepperoni");
		toppings.add("Black Olives");
		
	    Iterator<String> itr = toppings.iterator();
		while(itr.hasNext()){
			String aBorrower = itr.next();
			if (aBorrower.equals("Pepperoni")) {
				itr.remove();
			}
		}
	}
}
