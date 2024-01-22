package com.yedam.classes;

import com.yedam.condition.iFCondition;

//private 필드에선 자유롭게 사용 외부접근 차단
//학생번호, 이름, 점수, 키: 속성
//소개(학생번호, 이름, 점수)
public class Student {
	//필드 
	private String sno;  //초기값 null
	private String sname;
	private int score; //0
	private double height; //0.0
	private boolean onSchool;
	
	//생성자: 기본생성자. new Friend()<-반환값이 없다 
	public Student(String no, String name) {
		sno = no;
		sname = name;
		
	}
	public Student(String no, String name, int score) {
		this(no, name);
		this.score = score;
		
	}
	public Student(String sno, String sname, int score, double height) {
		this.sno = sno;
		this.sname = sname;
		this.score = score;
		this.height = height;
	}
	//메소드
	public void showInfo() {
		System.out.printf("번호는 %s, 이름은 %s 점수는 %d 키는 %.1f입니다.\n", sno, sname, score, height);
	}
	
	String showInfostr() {
		return "번호는" + sno;
	}
	public void setHeight(double height) {
		if(height < 0) {
			this.height = 160;
		}else {
			this.height = height;
		}
	}
	public double getHeight() {
		return this.height;
	}
	//sno sname score 작성
	public void setSno(String sno) {
			this.sno = sno;
		}
	public String getSno() {
		return this.sno;
	}
	public void setSname(String sname) {
			this.sname = sname;
		}
	public String getSname() {
		return this.sname;
	}
	public void setScore(int score) {
		if(score < 0) {
			this.score = score;
		}else if(score > 100) {
			this.score = score;
		}
	}
	public int getScore() {
		return this.score;
	}
	public boolean isOcSchool() {
		return onSchool;
	}
}			