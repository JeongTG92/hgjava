package com.yedam.Collection.emp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.condition.iFCondition;

public class EmpApp {
	public static void main(String[] args) {
		List<Employee> storage = new ArrayList<Employee>();

		SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Date date = null;

		while (run) {
			System.out.println("1.등록 2.조회(입사일자) 9.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("등록하세요");
				String[] sumAry = scn.nextLine().split(" ");
				boolean isOk = true;
				try {
					storage.add(new Employee(Integer.parseInt(sumAry[0]), sumAry[1], sdf.parse(sumAry[2]),
							Integer.parseInt(sumAry[3])));

				} catch (Exception e) {
					System.out.println("잘못입력하셨습니다");
					isOk = false;
				}
				if (isOk) {
					System.out.println("입력완료");

				}
				break;
			case 2:
				//
				System.out.print("조회일 입력");
				try {
					date = sdf.parse(scn.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("날짜 포맷이 부정확");
				}
				for (int i = 0; i < storage.size(); i++) {
					if (storage.get(i).getHireDate().after(date) || storage.get(i).getHireDate().equals(date)) {
						System.out.println(storage.get(i).toString());

					}
				}
			case 9:
				run = false;
			}
		}
		System.out.println("end of prog");

	}

	void method() {

		// "int101 Str홍길동 date23-05-08 int100"
		String val = "101 홍길동 23-05-08 100";
		SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
		String[] valAry = val.split(" ");
		for (String value : valAry) {
			System.out.println(value);
		}
		try {
			new Employee(Integer.parseInt(valAry[0]), // 사번
					valAry[1], // 이름
					sdf.parse(valAry[2]), // 날짜
					Integer.parseInt(valAry[3]));// 급여
		} catch (Exception e) {

		}

	}
}
