package com.yedam.classes.abstracts;

//추상클래스
public abstract class Animal {
	private String name;
	
	public Animal() {
		
	}
	public Animal(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println("[Animal] 음식을 먹습니다.");
	}
	//추상메소드:구현부분X, 자식클래스에서 반드시 overriding(재정의)
	public abstract void sleep();
}
