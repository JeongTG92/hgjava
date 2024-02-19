package gym_Manager;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import javax.management.MBeanAttributeInfo;
import javax.swing.plaf.basic.BasicToolBarSeparatorUI;
import javax.xml.crypto.dsig.XMLSignature;

import org.w3c.dom.css.ElementCSSInlineStyle;

import oracle.net.aso.b;

public class GymApp {
	public static void main(String[] args) {
		GymDAO gdao = new GymDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/mm/dd");
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = 0;

		while (run) {
			System.out
					.println(" 1.신규회원등록\r\n 2.이용권구매\r\n 3.상세회원조회\r\n 4.전체회원조회\r\n 5.회원정보수정\r\n 6.회원등급수정\r\n 7.회원삭제\r\n 8.총매출\r\n 9.종료");
			System.out.printf("선택>> ");
			menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) {
				System.out.print("회원번호 : ");
				int mno = scn.nextInt();
				scn.nextLine();
				System.out.print("이름 : ");
				String name = scn.nextLine();
				System.out.print("이메일 : ");
				String email = scn.nextLine();
				System.out.print("생년월일(6자리 ex : 00/00/00) : ");
				String birth = scn.nextLine();
				System.out.print("성별(남/여) : ");
				String gender = scn.nextLine();
				System.out.print("주소 : ");
				String address = scn.nextLine();
				System.out.print("전화번호 : ");
				String phone = scn.nextLine();

				try {
					Member mb = new Member(mno, name, email, sdf.parse(birth), gender, address, phone);
					if (gdao.Insertmb(mb)) {
						System.out.println("가입 완료");
					} else {
						System.out.println("등록 오류");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (menu == 2) {
				System.out.print("회원번호>>");
				int mno = scn.nextInt();
				System.out.println("+=================+\n");
				System.out.println("|1. 1개월 :   55,500 |\n");
				System.out.println("|2. 3개월 :  135,000 |\n");
				System.out.println("|3. 6개월 :  255,000 |\n");
				System.out.println("|4.12개월 :  499,000 |\n");
				System.out.println("+=================+\n");
				System.out.println("결제할 이용권 :");
				
				int menu2 = scn.nextInt();
				scn.nextLine();
				if(menu2 >= 1 && menu2 <= 4) {
			       MemberShip mbs = new MemberShip();			        
			       switch (menu2) {
			            case 1:
			            	
			                mbs.setOption("1개월");
			                mbs.setPrice(55000);
			                break;
			            case 2:
			            	
			            	mbs.setOption("3개월");
			                mbs.setPrice(135000);
			                break;
			            case 3:
			            	
			            	mbs.setOption("6개월");
			                mbs.setPrice(225000);
			                break;
			            case 4:
			            	
			            	mbs.setOption("12개월");
			                mbs.setPrice(499000);
			                break;
			            default:
			            	mbs.setOption("");
			                mbs.setPrice(0);
			     }
			       if(gdao.InsertmbShip(mbs)) {
			    	   System.out.println("정상 결제");
			       }else {
			    	   System.out.println("결제 에러");
			       }
		    }
		}
			else if(menu == 3) {
				System.out.println("회원번호 입력 : ");
				int mno= scn.nextInt();
				while(true) {
					List<Member> list = gdao.getList(null, menu); 
					for (Member mb1 : list) {
						System.out.println("===================");
						System.out.println("이름 : "+mb1.getName()+"\r\n이메일 : "+mb1.getEmail()+"\r\n생년월일 : "+mb1.getBirth()+"\r\n성별 : "
								+mb1.getGender() +"\r\n주소지 : "+ mb1.getAddress() +"\r\n전화번호"+ mb1.getPhone());
						System.out.println("===================");
					}
					break;
				}
				
					
				}else if(menu == 4) {
					System.out.println("성별 : ");
					String gender = scn.nextLine();
					int page = 1;
					while(true) {
					System.out.println("| 회원번호 |  이름  |  성별  |   거주지    |    전화번호    |회원등급|");
					System.out.println("============================================================");
					List<Member> list = gdao.getList(gender, page);
					for (Member mb : list) {
						System.out.println("    "+mb.getMno()+"      "+ mb.getName() +"     "+
						mb.getGender() +"      "+ mb.getAddress() +"     "+ mb.getPhone());
							
					}
						int totalCnt = gdao.getTotalCnt(gender);
						int lastPage = (int) Math.ceil(totalCnt / 5.0);
						for (int i = 1; i <= lastPage; i++) {
							System.out.printf("%3d", i);
						}
						System.out.println();
						System.out.print("페이지 선택 : ");
						page = scn.nextInt();
						scn.nextLine();
						if(page == -1) {
							break;
						}
				}
			}else if (menu == 5) {
				Member mb = new Member();
				System.out.print("수정 할 회원번호 :");
				String mno = scn.nextLine();
				System.out.println("1.이메일 2.거주지 3.전화번호");
				int menu2 = 0;
				menu2 = scn.nextInt();scn.nextLine();
				
				
					if(menu2 == 1) {
						System.out.println("이메일 변경");
						String email = scn.nextLine();
						mb.setEmail(email);
							if(gdao.updateMb(mb)){
								System.out.println("수정 완료");
							}else {
								System.out.println("수정 중 에러");
							}
					}else if(menu2 == 2) {
						System.out.println("거주지 변경");
						String address = scn.nextLine();
						mb.setAddress(address);
							if(gdao.updateMb(mb)){
								System.out.println("수정 완료");
							}else {
								System.out.println("수정 중 에러");
							}
					}else if(menu2 == 3) {
						System.out.println("전화번호변경");
						String phone = scn.nextLine();
						mb.setPhone(phone);
							if(gdao.updateMb(mb)){
								System.out.println("수정 완료");
							}else {
								System.out.println("수정 중 에러");
							}
					}
				
			}else if (menu == 6) {
				System.out.println("회원번호 등록");
			}else if(menu == 7) {
				System.out.println("삭제할 회원번호 : ");
				String mno = scn.nextLine();
				
				if(gdao.deleteMb(Integer.parseInt(mno))) {
					System.out.println("정상 삭제");
				} else {
					System.out.println("삭제 중 에러");
				}
			}else if(menu == 8) {
				System.out.println("총 매출");
			}else if(menu == 9) {
				System.out.println("시스템 종료");
				run = false;
			}
		}
	}
}
