package com.yedam;

public class Singleton {
	//전체프로그램에서 인스턴스를 하나만 생성.
	
		//1.생성자 private 선언
		//2.Singleton (예시) 타입의 필드 선언.
		//3.인스턴스 반환하도록 getInstance() 제공.
		private static Singleton instance = new Singleton(); 
		
		private Singleton() {
			
		}
		
		public static Singleton getInstance() {
			return instance;
		}

}
