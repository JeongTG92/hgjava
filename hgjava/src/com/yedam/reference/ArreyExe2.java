package com.yedam.reference;

import java.security.PublicKey;
import java.util.Iterator;
import java.util.Scanner;

import com.yedam.condition.iFCondition;

public class ArreyExe2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
//		System.out.println("친구입력>>>>");
//		String name = scn.nextLine();
		
		String[] friends = {"홍길동","김민수","박석민","최홍만","김길동"};
		double[] dblAry = {67.3, 72.5, 88.3, 79.3, 90.4};
		int[] scores = new int[5];
		scores[0] = 78;
		scores[1] = 95;
		scores[2] = 77;
		scores[3] = 91;
		scores[4] = 85;
		//김민수는 72.5kg 92점 입니다.
//		for(int i = 0; i < friends.length; i++) {
//			if(friends[i].equals(name)) {
//				System.out.printf("이름은 %s이고, 몸무게는%.1f, 점수는 %d입니다.", friends[i],dblAry[i],scores[i]);
//		}
		//최고값 계산하기 위한 변수
		int max = 0;
		String name = "";
		double weight = 0;
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] > max) {
				name = friends[i];
				weight = dblAry[i];
				max = scores[i];
			}
		}System.out.printf("최고 %s %.1fkg %d점 입니다.", name,weight,max);
	}	
		
		//		//김민수는 2번째에 있습니다.
//		boolean exit = false;
//		for(int i =0; i < friends.length; i++) {
//			if(friends[i].equals(name)) {
//				System.out.printf("%s는 %d번째에 있습니다.",name, (i+1));
//				exit = true;
//
//			}
//		}
//		if(!exit) {
//			System.out.println("찾는 친구가 없습니다.");
		
//		System.out.println("\nend of prog");
	
		
		
		
		
		
		
		
		
		
		
		
		
public static void method1() {	
		
//		double[] dblAry = {67.3, 72.5, 88.3, 79.3, 90.4};
//		//배열의 값 중에서 제일 큰값을 출력.
//		double max = 0;
//		for(int i = 0; i < dblAry.length; i++) {
//			if(dblAry[i] > max) {
//				max = dblAry[i];
//			}
//		}
//		System.out.printf("최고 몸무게 %.1fkg",max);
//		double avg = 0;
//		double sum = 0;
//		//친구들의 평균 몸무게는 78.8입니다.
//		for(int i = 0; i < dblAry.length; i++) {
//			sum += dblAry[i];
//		}
//		avg = sum / dblAry.length;
//		
//		System.out.printf("친구들의 평균 몸무게는 %.1f 입니다", avg);
//		System.out.println("\nend of prog");
}
			
public static void method2() {		
//		int[] scores = new int[10];
//		
//		scores = new int[5];
//		scores[0] = 78;
//		scores[1] = 95;
//		scores[2] = 77;
//		scores[3] = 91;
//		scores[4] = 85;// 할당된 배열의 크기를 넘으면 에러
//		
//		//80점 이상인 학생은 3명입니다.
//		//90점 이상 학생은 없습니다
//		int cnt = 0;
//		int nnt = 0;
//		for(int i = 0; i < scores.length; i++) {
////			System.out.println("scores["+ i +"]"+scores[i]);
//			if(scores[i] > 80) {
//				cnt++;
//		    }else if(scores[i] > 90) {
//		    	nnt++;
//		    }
//		}
//		System.out.println("90점 이상인 학생은" + nnt + "명 입니다.");
//		System.out.println("80점 이상인 학생은" + cnt + "명 입니다.");
 }
}