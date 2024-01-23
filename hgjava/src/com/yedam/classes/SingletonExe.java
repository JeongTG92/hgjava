package com.yedam.classes;

import com.yedam.Singleton;

public class SingletonExe {
	public static  void main(String[] args) {
		Singleton s1 = Singleton.getInstance(); //new 호출 X 
		Singleton s2 = Singleton.getInstance(); //싱글톤 둘다 같은 주소값
		
		System.out.println(s1 == s2);
	}
}
