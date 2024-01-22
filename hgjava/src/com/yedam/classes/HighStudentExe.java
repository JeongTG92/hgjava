package com.yedam.classes;

import com.yedam.condition.iFCondition;

public class HighStudentExe {

	public static void main(String[] args) {
		HighStudent hiStd = new HighStudent("T001","홍길동",90,"김썜");
		
		System.out.println(hiStd.getSno());
		System.out.println(hiStd.getTeacher());
		hiStd.showInfo();//부모클래스의 멤버
		
		System.out.println("-------------------------");
		//부모클래스의 참조변수에 자식클래스의 인스턴스를 대입.
		Student std = (Student) new HighStudent("T002","박길동",80,"김썜");
		if(std instanceof HighStudent) {
			HighStudent hstd = (HighStudent) std;//Student (casting)타입 
			System.out.println(hstd.getTeacher());
		}
		
//		Student std1 = new Student("S003", "박석민", 80);
//		if(std instanceof HighStudent) {
////			HighStudent hstd1 = (HighStudent) std1;
//			System.out.println(hstd1.getTeacher());
//		}
		
//		System.out.println(std.getTeacher());
		
		System.out.println("------------------------");
		Student[] students = new Student[10];
//		HighStudent[] hiStudent = new HighStudent[10];
		students[0] = new Student("S001","김민석",90);
		students[1] = hiStd; //HighStudent
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				students[i].showInfo();
			}
		}
		
		
		
		long ln1 = (int)10; //자동 형 변환(promotion) 큰범위변수 = (큰범위변수) 작은범위값
		int n1 = (int) ln1; //강제 형 변환(casting)
	}

}
