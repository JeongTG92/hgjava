package com.yedam.condition;

public class ArrayExe {

	public static void main(String[] args) {
		//
		int[] intAry = {10, 20, 30};
		intAry[2] = 40; //2번위치에 40으로 변환
		
		intAry = new int[] {10,20,30,40,50};//기존 배열 변경은 배열 새로 선언
		intAry = new int[10];//배열 크기 설정
		
		System.out.println(intAry[0]+", 크기:" + intAry.length);
		intAry[0] = 100;
		
		for(int i = 0; i < 10; i++) {
			intAry[i] = (int) (Math.random() * 10); 
		}
		
		//2,3의 배수의 값을 각각 int sum2 sum3에 저장.
		int sum2, sum3;
		sum2 = sum3 = 0;
		
		//배열에 값을 저장
		for(int i = 0; i < 10; i++) {
			System.out.println(intAry[i]);
			//코드작성
			if(intAry[i]%2 == 0) {
				sum2 += intAry[i];
			}else if(intAry[i]%3 == 0){
				sum3 += intAry[i];
			}
		}
		//각각 출력....6은 둘다 할당
		System.out.printf("2의배수 합: %d, 3의배수 합: %d", sum2, sum3);
		
		String[] strAry ={"\nhong", "park", "kim"};
		for(int i = 0; i < strAry.length; i++) {
			System.out.println(strAry[i]);
		}
	}
}
