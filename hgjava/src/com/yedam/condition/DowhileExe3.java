package com.yedam.condition;

public class DowhileExe3 {

	public static void main(String[] args) {
		boolean run = false;
		int cnt = 0;
		
		do {
			System.out.println("한번 출력합니다.." + cnt);
			run = true;
			if(cnt ++ > 3) {
				run = false;
			}
		} while(run); 
		System.out.println("ean of prog.");


	}

}
