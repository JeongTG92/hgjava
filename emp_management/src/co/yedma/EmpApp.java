package co.yedma;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;

//사용자의 입출력처리.
public class EmpApp {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
		EmpDAO edao = new EmpDAO();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = 0;

		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 9.종료");
			System.out.print("선택>> ");
			menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) {
				System.out.print("사원번호>> ");
				int no = scn.nextInt();
				scn.nextLine();
				System.out.print("사원명>> ");
				String name = scn.nextLine();
				System.out.print("이메일>> ");
				String mail = scn.nextLine();
				System.out.print("연락처>> ");
				String phone = scn.nextLine();
				System.out.print("입사일자>> ");
				String hire = scn.nextLine();
				System.out.print("급여>>  ");
				String sal = scn.nextLine();
				System.out.print("부서정보>> ");
				String dept = scn.nextLine();

				try {
					Employee emp = new Employee(no, name, mail, phone, sdf.parse(hire), Integer.parseInt(sal), dept);

					if (edao.insertEmp(emp)) {
						System.out.println("정상적으로 등록");
					} else {
						System.out.println("등록 에러");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (menu == 2) {
				System.out.print("부서정보>> ");
				String dept = scn.nextLine();
				int page = 1;
				while (true) {
				System.out.println("사원번호    이름     전화번호   부서");
				System.out.println("===============================");
				List<Employee> list = edao.getList(dept, page);
				for (Employee emp : list) {
					System.out.println(emp.getEmpNo() + "  " + emp.getEmpName() + "   " + emp.getPhone() + "   "
							+ emp.getDepartment());
				}
				// 64건 => <<1 2 3 4 5 ..>>
				int totalCnt = edao.getTotalCnt(dept);
				int lastPage = (int) Math.ceil(totalCnt / 5.0);
				for (int i = 1; i <= lastPage; i++) {
					System.out.printf("%3d", i);
				}
				System.out.println();
				System.out.print("페이지>> ");
				page = scn.nextInt();
				scn.nextLine();
				if(page == -1) {
					break; //목록보기 빠져나옴
				}
			}//end of while

			} else if (menu == 3) {
				System.out.print("사원번호>> ");
				String no = scn.nextLine();
				System.out.println("수정부서>> ");
				String dept = scn.nextLine();
				System.out.println("수정 연락처>>");
				String phone = scn.nextLine();

				Employee emp = new Employee();
				emp.setEmpNo(Integer.parseInt(no));
				emp.setDepartment(dept);

				if (edao.updateEmp(emp)) {
					System.out.println("정상수정");
				} else {
					System.out.println("수정 중 에러");
				}
			} else if (menu == 4) {
				// 삭제: 사원번호 처리 . deleteEmp(사원번호)
				System.out.println("삭제할 사원번호>> ");
				String no = scn.nextLine();

				if (edao.deleteEmp(Integer.parseInt(no))) {
					System.out.println("정상 삭제");
				} else {
					System.out.println("삭제중 에러");
				}
			} else if (menu == 9) {
				System.out.println("종료합니다");
				run = false;
			}
		}
	}
}
