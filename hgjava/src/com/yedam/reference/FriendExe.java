package com.yedam.reference;

import java.nio.channels.ScatteringByteChannel;
import java.security.AccessControlContext;
import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifGPSTagSet;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.swing.text.Highlighter.Highlight;

import com.yedam.condition.iFCondition;

//친구의 정보를 저장하고 변경하고...관리
//Create, Read, update, Delete
public class FriendExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Friend[] friends = new Friend[5]; //{null,null,null,null,null} while 안으로 선언하면 계속 초기화
		double weight = 0;
		int score = 0;
		
		while(run) {
			System.out.println("1.등록 2.조회 3.수정 4.삭제 5.점수조회 6.분석 9.종료");
														//5.입력점수 이상인 사람
														//6.평균점수: 85, 최고점수 90
			int menu = Integer.parseInt(scn.nextLine()); 
			switch(menu) {
			case 1 : //등록
				System.out.println("이름>>>");
				String name = scn.nextLine();
				System.out.println("몸무게>>>");
				weight = Double.parseDouble(scn.nextLine());
				System.out.println("점수>>>");
				score = Integer.parseInt(scn.nextLine());
				
				Friend friend = new Friend();
				friend.name = name;
				friend.weight = weight;
				friend.score = score;
				
				//비어있는 위치 한건 입력 종료.
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] == null) {
						friends[i] = friend;
						break;
					}
				}
			System.out.println("정상적으로 입력되었습니다.");
			break;
			
			case 2 : //조회
				//전체 목록 이름:홍길동 몸무게 77.2 점수 80
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] != null) {
						System.out.printf("%s 몸무게는 %.1fkg 점수는 %d\n", friends[i].name, friends[i].weight, friends[i].score);
					}
				}
				break;
			case 3 : //수정
				System.out.println("조회할 이름>>>");
				name = scn.nextLine();
				System.out.println("수정 몸무게>>>");
				String sweight = scn.nextLine();
				if(!sweight.equals("")) {
					weight = Double.parseDouble(sweight);
				}
				System.out.println("수정 점수>>>");
				String sscore = scn.nextLine();
				if(!sscore.equals("")) {
					score = Integer.parseInt(sscore);
				}
				
				boolean exit = false;
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] != null && friends[i].name.equals(name)) {
						friends[i].score = (score != 0) ? score : friends[i].score;
						friends[i].weight = (weight != 0) ? weight : friends[i].weight;
						exit = true;
					}
				}
				if(exit) {
					System.out.println("수정완료");
					
				}
				break;

			case 4 : //삭제
				System.out.println("삭제할 이름>>>");
				name = scn.nextLine();
				for(int i = 0; i < friends.length; i++) {
					if(friends[i] != null && friends[i].name.equals(name)) {
						friends[i] = null;
						break;
					}
				}
				System.out.println("삭제완료");
				break;
			case 5 : //점수조회
					System.out.println("조회할 점수>>");
					score = Integer.parseInt(scn.nextLine());
					
			case 6 ://분석조회
					double avg = 0;
					int max = 0, cnt = 0;
					double sum = 0;
						
			case 9 : //종료	
				run = false;
				
				System.out.println("종료합니다");
			}
		}//end of while
		System.out.println("end of prog");
	}//end of main

}
