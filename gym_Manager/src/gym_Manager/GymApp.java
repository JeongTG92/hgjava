package gym_Manager;

import java.util.Scanner;

public class GymApp {
	public static void main(String[] args) {
		GymDAO gdao = new GymDAO();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = 0;
		
		while(run) {
			System.out.println(" 1.신규회원등록 2.이용권구매 3.상세회원조회 4.전체회원조회 5.구매내역조회 "
					+ "6.회원정보수정  7.회원등급수정 8.회원삭제 9.총매출 10.종료");
			System.out.printf("선택>> ");
			menu=scn.nextInt();scn.nextLine();
		
		if(menu == 1) {
			System.out.println("이름 : ");
			String name = scn.nextLine();
			System.out.println("이메일 : ");
			String email = scn.nextLine();
			System.out.println("생년월일(8자리) : ");
			String birth = scn.nextLine();
			System.out.println("성별(남/여) : ");
			String gender = scn.nextLine();
			System.out.println("주소 : ");
			String address = scn.nextLine();
			System.out.println("전화번호 : ");
			String phone = scn.nextLine();
			
		try {
			Member mb = new Member(name, email, birth, gender, address, phone);
				if(gdao.Insertmb(mb)) {
					System.out.println("가입 완료");
				}else {
					System.out.println("등록 오류");
				}
		 	} catch (Exception e) {
		 		e.printStackTrace();
		 	}
		}
		}
	}
}
