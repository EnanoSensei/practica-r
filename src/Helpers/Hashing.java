package Helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
	
	public static String hashPW(String pw) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pw.getBytes());
			byte[] b =  md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<b.length;i++) {
				sb.append(Integer.toString((b[i] & 0xff)+0x100, 16).substring(1));
			}
			
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
