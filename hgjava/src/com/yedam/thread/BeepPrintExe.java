package com.yedam.thread;

import java.awt.Toolkit;

public class BeepPrintExe {
	public static void main(String[] args) {
		
//		Thread thread = new Thread(new BeepTask());
		Thread thread = new BeepThread();
		thread.start(); //start 호출하면 run()메소드 실행
		
		//메인쓰레드가 실행
		for(int i = 0; i < 5; i++) {
			System.out.println("print");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
