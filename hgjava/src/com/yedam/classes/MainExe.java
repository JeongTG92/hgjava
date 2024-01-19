package com.yedam.classes;

import java.security.AccessControlContext;
import java.util.Scanner;

import com.yedam.condition.iFCondition;

public class MainExe {
	public static void main(String[] args) {
		
		StudentApp app = new StudentApp();//인스턴스
		
		Scanner scn =new Scanner(System.in);
		boolean run = true;
		
		String sno = "", sname = "";
		int score = 0;
		double height = 0;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 6.단건조회 9.종료" );
		int menu = Integer.parseInt(scn.nextLine());
		
		switch(menu) {
		case 1 : //등록기능.
			System.out.println("학생번호>>> ");	
			sno = scn.nextLine();
			System.out.println("학생이름>>> ");
			sname = scn.nextLine();
			System.out.println("학생점수>>> ");
			score = Integer.parseInt(scn.nextLine());
			System.out.println("학생키>>> ");
			height = Double.parseDouble(scn.nextLine());
			//매개값으로사용
			Student std = new Student(sno, sname, score, height);
			
			if(app.add(std)) {
				System.out.println("입력성공!");
			}else {
				System.out.println("입력실패!");
			}
			break;
			
		case 2 : //목록출력
			Student[] list = app.list();
			for(int i = 0; i < list.length; i++) {
				if(list[i] != null) {
					list[i].showInfo();
				}
			}
			System.out.println("조회");
			break;
		case 3 : //수정
			System.out.println("학생번호 확인>>> ");
			sno = scn.nextLine();
			//정상 학번 체크
			if(app.get(sno) == null) {
				System.out.println("학생번호를 다시 확인 해주세요");
				break;
			}
			//정상적인 점수가 입력됏는지
		while (true) {
			System.out.println("학생점수 수정>>> ");
			score = Integer.parseInt(scn.nextLine());
			if(score < 0) {
				System.out.println("점수를 확인해주세요.");
				continue;
			}
			break;
		}			
			if(app.modify(sno, score)) {
				System.out.println("수정 완료");
			}else {
				System.out.println("잘못된 입력값입니다.");
			}
		
			break;
		case 4 : //삭제
			System.out.println("삭제할 학생번호>>>");
			sno = scn.nextLine();
			if(app.del(sno)) {
				System.out.println("삭제하였습니다.");
			}else {
				System.out.println("없는 이름 입니다.");
			}
		case 6 :
			System.out.println("조회할 학생 번호>>>");
			sno = scn.nextLine();
			
			Student s1 = app.get(sno);
			if(s1 != null) {
				s1.showInfo();
			}else {
				System.out.println("학생번호없음");
			}
			break;
			
		case 9 ://종료.
			run = false;
			System.out.println("시스템 종료.");
			}
		}
		System.out.println("end of prog.");
		
	}// end of main()
}
		


