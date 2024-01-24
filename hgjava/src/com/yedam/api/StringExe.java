package com.yedam.api;

import java.io.UnsupportedEncodingException;

import javax.security.auth.callback.ConfirmationCallback;

public class StringExe {
	public static void main(String[] args) {
//		String str = "Hello";
//		str = new String("Hello");
//		byte[] bytes = str.getBytes();
//		for (byte b : bytes) {
////			System.out.println(b);
//		}
//		str = new String(new byte[] { 72, 101, 108, 108, 111 });
////			System.out.println(str);
//		int pos = str.indexOf("g");
//		System.out.println("l은 " + pos + "위치에 있음"); //-1은 없는값
//		
//		char chr = str.charAt(0);
//		System.out.println(chr);

		String str = "안녕하세요";
		
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length :"+ bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1 => String :" + str1);
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes2.length :" + bytes2.length);
			String str2 = new String(bytes2, "EUC-KR");
			System.out.println("bytes2 => String :" + str2);

			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length :" + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3 => String :" + str3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
