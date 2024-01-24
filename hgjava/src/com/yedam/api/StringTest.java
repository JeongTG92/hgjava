package com.yedam.api;

import java.security.PublicKey;
import java.text.ParseException;
import java.text.ParsePosition;

import com.yedam.condition.iFCondition;

public class StringTest {
	public static void main(String[] args) throws ParseException {
		// 1번 문제의 데이터.
		String[] jumins = { "970101-1234567"// 남자
				, "970101-2234567"// 여자
				, "9701011234567"// 남자
				, "970101 1234567"// 남자
				, "030101 4234567"// 여자
				,"030101 1234567"//오류
		};
		
		for (String ssn : jumins) {
			checkGender(ssn);
			
			int yy = Integer.parseInt(ssn.substring(0,6));
			boolean before2000 = yy > 23;
			
			char pos = ssn.charAt(ssn.length() - 7);
			String gender = "여자";
			
			if(before2000) {
				if(pos == '1') {
					gender = "남자";
				}else if(pos == '2' ){
					gender = "여자";
				}else {
					gender = "오류";
				}
			}
			System.out.println(gender);
		}
		

		// 2번 문제 길동이란 이름이 볓번 나오는가?
		String[] names = { "홍길동", "길동이", "김길동", "이만기", "이춘양" };
		
		int cnt = 0;
		for (String name : names) {
			if(name.contains("길동") && !name.equals("길동이")) {
				cnt++;
			}
		}
		System.out.println("수 : "+cnt);
		
		
		
		
			
	}


	static void checkGender(String ssn) {

	}
}
