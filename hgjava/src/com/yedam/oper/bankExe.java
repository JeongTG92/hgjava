package com.yedam.oper;


import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

//은행계좌 55000 - 60000 출금 안되게
public class bankExe {
	public static void main(String[] args) {
		//입금, 출금, 잔고, 종료.
		Scanner scn = new Scanner(System.in);
		int balance = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("1.입금 2.출금 3.잔고 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:System.out.println("입금액>>> ");
					int cash = Integer.parseInt(scn.nextLine());
					if(balance + cash > 100000) {
						System.out.println("입금금액초과!");
						break;
						}
						balance += cash;
						System.out.println("입금완료!");
						break;
			case 2:System.out.println("출금액>>> ");
			       	cash = Integer.parseInt(scn.nextLine());
			       	if(balance - cash < 0) {
			       		System.out.println("출금금액초과!");
			       		break;
			       	}
			       	balance -= cash;
			       	System.out.println("출금완료!");
			       	break;
			case 3:System.out.println("계좌의 잔고 :\n" + balance +"원");
			     	break;
			case 4: run = false;
			}
		}
		System.out.println("end of prog.");
	}
}
