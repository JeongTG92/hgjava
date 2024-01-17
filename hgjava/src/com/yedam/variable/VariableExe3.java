package com.yedam.variable;

import java.util.Scanner;
import java.util.function.BiConsumer;

public class VariableExe3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//키입력...(=height) double
		//평균(합계=sum/3)
		double sum = 0;
		for(int i=1; i<=3; i++) {
			System.out.println("키를 입력>>>");
		    double height = scn.nextDouble();
		    sum += height;
		}
		System.out.println("평균키 : "+ (sum / 3));
		
	
//	char c1 = 'a';
//	for (int i=0; i<10; i++)
//	    System.out.println(c1++);
//	
//	int n1 = 0b1111;
//	System.out.println(n1);
	
	
	
	
	}
	
	
}
