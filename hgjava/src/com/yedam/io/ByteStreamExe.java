package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExe {
	public static void main(String[] args) {
		// 바이트 출력 스트림
		copy();
	}

	static void copy() {
		//입력출력 => 복사
		try {
			FileInputStream fis = new FileInputStream("c:/temp/sample.png");
			FileOutputStream fos = new FileOutputStream("c:/temp/copy2.png");

			//기본 스트림
			//byte[] byteAry = new byte[100];
			
			//보조 스트림 Buffered
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			while(true)
			{
				int buf = bis.read(); //fis.read(byteAry);
				if (buf == -1) {break;}
				bos.write(buf); //fos.write(byteAry);				
			}
			bos.flush();
			bos.close();
			fos.flush(); 
			fos.close();
			bis.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of copy");
	}
	static void read() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/sample.dat");
			while (true) {
				int bytes = fis.read(); //eof => -1 반환
				if (bytes == -1)
				{
					break;
				}
				System.out.println(bytes);
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of read");
	}
	static void write() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/sample.dat");
			fos.write(10);
			fos.write(20);
			fos.write(30);
			fos.flush(); // 다 쓰고 난 뒤엔 정보를 다 비우겠다
			fos.close(); // 자원 환원
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of write");
	}
}
