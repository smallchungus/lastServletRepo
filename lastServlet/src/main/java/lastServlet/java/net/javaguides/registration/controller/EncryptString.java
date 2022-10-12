package lastServlet.java.net.javaguides.registration.controller;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptString {

	public static String Encrypt(String toBeEncrypted) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NullPointerException

	{
//		String text = "Hello World";
		if (toBeEncrypted == null || toBeEncrypted.isEmpty())
			return "";
		String key = "Bar12345Bar12345"; // 128 bit key

		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.ENCRYPT_MODE, aesKey);
		byte[] encrypted = cipher.doFinal(toBeEncrypted.getBytes());
//		System.out.println(new String(encrypted));
		cipher.init(Cipher.DECRYPT_MODE, aesKey);
//		String decrypted = new String(cipher.doFinal(encrypted));
//		System.err.println(decrypted);

		return new String(encrypted);
	}

	public static void main(String[] args) {

	}
}
