package com.yedam.condition;

import java.util.Iterator;

public class ForLoopExe1 {

	public static void main(String[] args) {
		//
		for(int i = 1; i<=10; i+=2) {
			System.out.println(i);
			if(i > 5) {
				break;
			}
		}
			// 1 ~ 10까지 합을 계산.
		int sum = 0; 
		for(int n = 1; n <= 10; n++) {
			if(n % 2 == 0)
			sum += n;
		}
		System.out.printf("누적값은 %d\n", sum);
		
		//1 ~ 31 출력
		System.out.println("  일 월  화  수 목  금 토");
		System.out.printf("%3s", "");
		for(int d = 1; d <= 31; d++) {
			System.out.printf("%3d", d);
		   if(d % 7 == 6) {
			   System.out.println();
		   }
		}
	}

}
