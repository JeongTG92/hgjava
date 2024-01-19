package com.yedam.classes;

import java.io.ObjectInputStream.GetField;
import java.security.PublicKey;
import java.util.List;

import com.yedam.condition.iFCondition;

//학생정보관리 기능 구현
public class StudentApp {
	//필드.
	private Student[] students; //기본값 null.
	
	//생성자
	public StudentApp() {
		students = new Student[10];
	}
	
	//메소드.
	//1등록
	public boolean add(Student std) {
		for(int i=0; 0 < students.length; i++) {
			if(students[i] == null) {
				students[i] = std;
				return true;
			}
		}
		return false;
//		System.out.println("입력성공!");
	}
	//2목록
	public Student[] list() {
		return students;
	}
	
	//3수정.(학생번호-점수)
	public boolean modify(String sno, int score) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				students[i].setScore(score);
				return true;
			}
		}
		return false;
	}//4삭제
	public boolean del(String sno) {
		for(int i = 0; i <students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				students[i] = null;
				return true;
				
			}
		}
		return false;
	}
	//단건조회(학생번호)
	public Student get(String sno) {
		for(int i = 0; i <students.length; i++) {
			if(students[i] != null && students[i].getSno().equals(sno)) {
				return students[i];	
			}
		}
		return null;
	}
}