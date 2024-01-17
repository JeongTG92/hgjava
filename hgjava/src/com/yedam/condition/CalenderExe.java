package com.yedam.condition;

import javax.xml.stream.events.EndDocument;

public class CalenderExe {
	public static void main(String[] args) {
		
		int month = 2;
		//변수: 월의 1이 오는 위치.
		int pos = 1;
		int pos2 = 31;
	
		//변수: 월릐 마지막 날짜
		switch(month) {
		case 1: pos = 1; break;
		case 2: pos = 4; break;
		case 3: pos = 5; break;
		case 4: pos = 1; break;
		}
		switch(month) {
		case 1: pos2 = 31; break;
		case 2: pos2 = 29; break;
		case 3: pos2 = 31; break;
		case 4: pos2 = 30; break;
		}
	
		
		//수정. 월 변경 될때마다 마지막날 계산
		
		//1 ~ 31 출력
		String[] days = {"일", "월", "화", "수", "목", "금", "토"};
		for(int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println("");
		for(int i = 0; i < pos; i++ ) {
			System.out.printf("%4s","");
		}
		
		
		for(int d = 1; d <= pos2; d++) {
			System.out.printf("%4d", d);
			if((pos+d) % 7 == 0) {//수정
				System.out.println();
			}
		}
		System.out.println("\n=========end of prog==========");
	}
}
		
		
