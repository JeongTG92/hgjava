package com.yedam.io;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.util.Scanner;

public class CharStreamExe {
	Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// 문자기반 입출력.
		try {
			FileReader fr = new FileReader("c:/Temp/text.dat");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String read = br.readLine(); // 한라인씩 읽기
				if(read == null) { // 읽은 값이 없으면 null 반환 
					break;
				}
				System.out.println(read);
			}
			br.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("end of prog");
	}

	static void read() {

		Class cls = CharStreamExe.class;
		String path = cls.getResource("ByteStreamExe.class").getPath();
		System.out.println(path);

		try {
			FileReader fir = new FileReader("/D:/git/hgjava/hgjava/src/com/yedam/io/ByteStreamExe.java");
			while (true) {
				int read = fir.read();
				if (read == -1) {
					break;
				}
				System.out.print((char) read);
			}
			fir.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static void write() {

//		try {
//			FileWriter fw = new FileWriter("c:/Temp/text.dat");
//			while (true) {
//				System.out.println("입력>> ");
//				String str = scn.nextLine();
//				if (str.equals("stop")) {
//					break;
//				}
//				fw.write(str + "\n");
//			}
//			fw.flush();
//			fw.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}
}
