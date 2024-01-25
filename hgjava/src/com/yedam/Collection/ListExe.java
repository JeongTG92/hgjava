package com.yedam.Collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.condition.iFCondition;

public class ListExe {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("홍길동");
		names.add("김민석");
		names.add("김민석");
		names.add(1, "이만수");
		names.add(1, "이만우");
		names.set(1, "김만우");
		names.remove(1);// 한건씩 삭제
//		names.clear();//전체삭제

			System.out.println(names.size());// 크기확인
			
			// 반복문.
			for(String name : names) {
				System.out.println(name);
			}
			
//		if (names.size() > 2) {
//			System.out.println(names.get(1));// names[1]
//		}
// ---------------------------------------------------------------------
			
		List<Member> members = new ArrayList<Member>();
		members.add(new Member(1, "홍길동"));
		members.add(new Member(2, "김민석")); // 4:김길동
		members.add(new Member(3, "이충희"));
		
		
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getName().equals("김민석"))
				members.set(i, new Member(4, "김길동"));
//			String name = members.get(i).getName(); //이름값만 가져올떄
//			int id = members.get(i).getMid();	//정수값만 가져올떄
//			System.out.printf("이름:%s, 아이디: %d\n", name, id);
			System.out.printf("%s\n", members.get(i).toString());
		}
	
		
		
		
	}
}
