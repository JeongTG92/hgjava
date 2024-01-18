package com.yedam.todo;

import java.util.Scanner;

import javax.swing.border.TitledBorder;

public class Todo0117 {

	public static void main(String[] args) {
	
	    String[] name = {"홍길동", "김길동", "박길동"};
		String[] tel = {"010-1111-2222", "010-2222-3333", "010-3333-1111"};
		for(int i = 0; i < name.length; i++) {
			System.out.printf("이름 : %s\n연락처 : %s", name[i], tel[i]);
			
			System.out.println("\n======================");
           }
	
		}
	}