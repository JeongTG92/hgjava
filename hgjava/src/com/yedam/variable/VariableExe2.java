package com.yedam.variable;

import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class VariableExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//이름입력 (=name), 연락처(=phone) :scn.nextLine()
		System.out.println("이름 : ");
		String name = scn.nextLine();
		System.out.println("연락처 : ");
		int phone = scn.nextInt();
		
		//영어 (=eng), 수학(=mat) => 합계 (=sum) : scn.nextInt()
		System.out.println("영어 : ");
		int eng = scn.nextInt();
		System.out.println("수학 : ");
		int mat = scn.nextInt();
//		System.out.println("합계 : "+ sum);
		int sum = eng + mat;
		
		
		System.out.println("이름 : "+ name +"연락처 : "+ phone); 
		System.out.println("영어 : "+ eng +"수학 : "+ mat + "합계 : " + sum); 
		
	}

}
