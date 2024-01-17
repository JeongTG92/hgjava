package com.yedam.todo;

public class Todo0117 {

	public static void main(String[] args) {
	
		String[] name = {"홍길동", "\n김길동", "\n박길동"};
		String[] tel = {"010-1111-2222", "010-2222-3333", "010-3333-1111"};
		for(int i = 0; i < name.length; i++) {
			System.out.printf("%s\n", name[i]);
			System.out.printf("%s\n", tel[i]);
			System.out.printf("===============");
           }
		}
	}