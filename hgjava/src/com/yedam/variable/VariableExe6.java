package com.yedam.variable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class VariableExe6 {

	public static void main(String[] args) 
			throws FileNotFoundException {
//		// 표준입출력: 키보드 (System.in) 모니터 (System.out)
//		InputStream is = new FileInputStream("test.txt");
//		Scanner scn = new Scanner(is);
//		
//		String name = scn.nextLine();
//		//나이 (int:age), 키(double:height)
//		System.out.println(": " + name);
//
//		scn.close();
//		//이름은 홍길동, 나이는 20세 키는 178.9입니다.
		String name1 = "홍길동";
		int age = 20;
		double height = 178.9;
		System.out.printf("이름은 %s, 나이는 %d, 키는%-10.2f입니다 ", name1, age, height);
		
		
		
		
		
		
	}

}
