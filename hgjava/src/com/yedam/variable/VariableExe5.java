package com.yedam.variable;

public class VariableExe5 {

	public static void main(String[] args) {
		
		double d1 = 10.0;
		double result = d1 + 20.0;
		
		
		int sum = 60;
		result = sum / 7;
		System.out.println(result);
		
		sum = Integer.parseInt("1") + 3 + 5; //parseInt 문자열을 정수로 변환
		
		result = Double.parseDouble("1.234") + 2.3;
		System.out.println(result);
	}

}
