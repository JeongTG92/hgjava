package com.yedam.classes;
//패키지가 다르면 import로 불러올수있음
//실행.
public class StudentExe {
	
	public static void main(String[] args) {
		Student s1 = new Student("S001", "홍길동", 80, 178.9); //인스턴스 생성. 생성자
//		System.out.println(s1.sno);
		s1.setHeight(-167);
		System.out.println(s1.getHeight());
		s1.showInfo();
		
		Student s2 = new Student("S002", "김길동", 85, 180.2);
		s2.showInfo();
		
		Student s3 = new Student("S003", "박길동", 90, 173.6);
		s3.showInfo();
		
		Student s4 = new Student("S004", "김만수", 80, 182.3);
		s4.showInfo();
		
	}
}
		
		
		


