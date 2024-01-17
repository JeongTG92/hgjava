package com.yedam.todo;

import java.util.Scanner;

public class Todo0116 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("값을 입력>>> ");
			String input = scn.nextLine();
			if(input.equals("quit")) {
				// input.equals("quit")
			break;
			}
			//입력값은 홍길동 입니다.
			System.out.printf("입력한 값은 %s 입니다.",input);
			System.out.println();
		}
		System.out.println("<<end of prog>>");
		//"quit" 값이 들어오면 <<end of prog>>
	}
}
		
		
		
		
		
		
