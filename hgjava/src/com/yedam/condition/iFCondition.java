package com.yedam.condition;

public class iFCondition {
	public static void name(String[] args) {
		boolean isTrue = true;
		isTrue = isTrue != true;
		
		if(!!isTrue){
			//실행구문.
			System.out.println("참값입니다.");
		}else {
			System.out.println("거짓값입니다.");
		}
		
		int score = 95;
		if(score >= 90) {
			System.out.println("A학점");
		} 
		if(score >= 80) {
			System.out.println("B학점");
		} 
		if(score >= 70){
			System.out.println("C학점");
		}
		System.out.println("end of prog.");
	}
}
