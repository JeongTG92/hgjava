package com.yedam.oper;

import java.util.Scanner;

public class OperatExe {

	public static void main(String[] args) {
		int result = 0;
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("정수입력>>>");
			String input = scn.nextLine();
			if(input.equals("quit")) {
				break;
			}
			//사용자값 입력: 정수입력.
			//정수값이 아닌 문자열 입력시 에러를 밑의식으로 해결
//			try {
//				result += Integer.parseInt(input);
//			}catch (Exception e){
//				System.out.println("잘못된 값을 입력.");
//			}
			result += Integer.parseInt/*문자열의 숫자를 int타입으로 변환*/(input);
		}
		System.out.printf("누적값 : %d", result);
		System.out.println("\n end of prog.");
		//누적값은 15입니다.
		
	}	
}
			
			
	


//public static void method1() {
//	int sum = (1 + 2) * 3; 
//	sum = sum + 5;
//	sum += 5;
//	
//	String str = "";		
//	Scanner scn = new Scanner(System.in);
//	while(true) {
//		System.out.println("문자열을 입력하세요.");
//		String input = scn.nextLine();
//		if(input.equals("quit")) {
//			break;
//		}
//		str += input + " ";
//	}
//System.out.printf("누적내용:%s", str);	
//}
