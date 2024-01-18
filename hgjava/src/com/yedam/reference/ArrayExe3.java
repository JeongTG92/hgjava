package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe3 {

	public static void main(String[] args) {
		Friend f1 = new Friend(); //초기화.
		f1.name ="홍길동";
		f1.weight = 67.8;
		f1.score = 80;
		
		Friend f2 = new Friend();
		f2.name ="김민수";
		f2.weight = 71.5;
		f2.score = 91;
		
		Friend f3 = new Friend();
		f3.name ="박석일";
		f3.weight = 85.5;
		f3.score = 69;
		
		//새로운친구
		String name = "김말숙";
		double weight = 55.5;
		int score = 87;
		
		Friend f4 = new Friend();
		f4.name = name;
		f4.weight = weight;
		f4.score = score;
		
		
		
		Friend[] friends = {f1, f2, f3};
		friends = new Friend[5]; //위의 내용 초기화 {null,null,null,null,null}
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;//{f1,f2,f3,null,null}
		friends[3] = f4;//{f1,f2,f3,f4,null}
		
		// 김말숙 => 88 => 90점으로 변경
//		friends[3].score = 90; 
		Scanner scn = new Scanner(System.in);
		System.out.println("찾을 친구>>> ");
		String fname = scn.nextLine();
		System.out.println("변경점수>>> ");
		int fscore = Integer.parseInt(scn.nextLine());
		//입력으로 성적 점수 변경
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null && friends[i].name.equals(fname)) {//null은 뒤로 가면 안됨 무조건 앞에
				friends[i].score = fscore;
				}
			}
		//목록출력		
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null) {
				System.out.printf("%s 몸무게는 %.1fkg 점수는 %d\n", friends[i].name, friends[i].weight, friends[i].score);
				}
			}
		}
	}
		
		

