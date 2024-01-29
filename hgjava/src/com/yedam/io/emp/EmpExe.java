package com.yedam.io.emp;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class EmpExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		EmpApp app = new EmpApp();
		
		while(run)
		{
			System.out.println("1.등록 2.목록 9.종료");
			System.out.print("선택>>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu)
			{
			case 1:
				System.out.println("사원번호 이름 입사일자 급여>>> ");
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-mm-dd");
				Employee inputInfo = null;
				while(true)
				{
					try {
						String employeeInfo = scn.nextLine();
						String[] spliceInfo = employeeInfo.split(" ");
						inputInfo = new Employee(Integer.parseInt(spliceInfo[0]), 
												spliceInfo[1],
												simpleDateFormat.parse(spliceInfo[2]), 
												Integer.parseInt(spliceInfo[3]));
						break;
					}catch (Exception e) {
						System.out.println("올바르지 않은 입력입니다.");
					}
				}
				
				if(app.add(inputInfo))
				{
					System.out.println("등록완료");
				}
				else {
					System.out.println("등록실패");
				}
				break;
			case 2:
				List<Employee> list = app.list();
				for(Employee std : list)
				{
					System.out.println(std.toString());
				}
				break;
			case 9:
				System.out.println("프로그램 종료");
				app.save();
				run = false;
				break;
			}
		}
	}
}
