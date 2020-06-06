package aesproject;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;


public class AESAlgorithm {
	public static String algo = "AES";
	public byte[] keyValue;
	
	public AESAlgorithm(byte key[]) {
		keyValue = key;
	}
	
	public Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, algo);
		return key;
	}
	
	public String encrypt(String msg) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(algo);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(msg.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}
	
	public String decrypt(String msg) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(algo);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(msg);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}
}
