package com.yedam.classes;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		//final int num = 10;
//		//num = 20;
//		Calendar cal = Calendar.getInstance();
//		System.out.println(Calendar.YEAR); //상수값
//		cal.set(2024, 1, 1);
//		System.out.println("year:" + cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println("last Date:" + cal.getActualMaximum(Calendar.DATE));
		
		
		drawCalendar(2024, 6);
		Date date = new Date(0); 
		
		
		drawCalender(date);
	}
	
	static void drawCalender(Date date) {
		
		
		
	}
	
	static void drawCalendar(int year, int month) {
		// (2024, 1)
		Calendar cal = Calendar.getInstance();
		
		cal.set(year, month -1, 1);
		
		int pos = cal.get(Calendar.DAY_OF_WEEK) - 1 ;
		int last = cal.getActualMaximum(Calendar.DATE);
		
		//요일출력.
		String[] days = {"일", "월", "화", "수", "목", "금", "토"};
		for(int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println("");
		//1일의 요일지정
		for(int i = 0; i < pos; i++ ) {
			System.out.printf("%4s","");
		}
		//날짜출력
			for(int d = 1; d <= last; d++) {
			System.out.printf("%4d", d);
			if((pos+d) % 7 == 0) {//수정
				System.out.println();
			}
		}
		System.out.println("\n=========end of prog==========");
		
	}
}
