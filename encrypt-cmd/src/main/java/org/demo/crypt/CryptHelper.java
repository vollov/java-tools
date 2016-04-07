package org.demo.crypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * helper class to encrypt/decrypt strings
 * @author m34729
 *
 */
/**
 * @author m34729
 *
 */
public class CryptHelper {

	private String password;
	private String algorithm = "PBEWithMD5AndDES";
	
	/**
	 * Constructor
	 * @param password
	 * @param algorithm -- default is PBEWithMD5AndDES
	 */
	public CryptHelper(String password){
		this.password = password;
	}
	
    public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * Decrypt a text
	 * @param encryptedText encrypted text
	 * @return empty string if encrypted text is empty 
	 */
	public String decrypt(String encryptedText) {
        try {
            if (encryptedText != null && !encryptedText.isEmpty()) {
 
                StandardPBEStringEncryptor nrsEncryptor = new StandardPBEStringEncryptor();
                nrsEncryptor.setPassword(password); 
                nrsEncryptor.setAlgorithm(algorithm);
                return nrsEncryptor.decrypt(encryptedText);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
 
	/**
	 * Encrypt a text
	 * @param plainText plain text
	 * @return empty string if encrypted text is empty 
	 */
    public String encrypt(String plainText) {
        try {
            if (plainText != null && !plainText.isEmpty()) {
 
                StandardPBEStringEncryptor nrsEncryptor = new StandardPBEStringEncryptor();
                nrsEncryptor.setPassword(password);
                nrsEncryptor.setAlgorithm(algorithm);
                return nrsEncryptor.encrypt(plainText);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
}
