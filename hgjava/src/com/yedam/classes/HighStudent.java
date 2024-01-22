package com.yedam.classes;

import java.lang.invoke.StringConcatFactory;

//담임선생님.
public class HighStudent extends Student {
	private String teacher;
	
	//생성자
//	public HighStudet() {
//		super();
//	}
	public HighStudent(String sno, String name) {
		super(sno, name);
	}
	
	public HighStudent(String sno, String name,int score, String taecher) {
		super(sno, name, score);
		this.teacher = teacher;
	}
	public void setTeacher(String taecher) {
		this.teacher = teacher;
	}
	public String getTeacher() {
		return this.teacher;
	}
	
	//부모메소드를 재정의
	public void showInfo() {
		//자식클래스:teacher 추가 출력
		System.out.printf("번호는 %s, 이름은 %s 점수는 %d, 선생님은 %s입니다.\n", getSno(), getSname(), getScore(), teacher);
	}
}
