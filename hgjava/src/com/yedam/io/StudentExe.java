package com.yedam.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//public class StudentExe {
//	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		boolean run = true;
//
//		
//		while(run)
//		{
//			System.out.println("1.등록 2.목록 9.종료");
//			System.out.print("선택>>> ");
//			
//			int menu = Integer.parseInt(scn.nextLine());
//			
//			switch(menu)
//			{
//			case 1:
//				System.out.println("학생번호 학생이름 점수 입력>>> ");
//				Student inputInfo = null;
//				while(true)
//				{
//					try {
//						String studentInfo = scn.nextLine();
//						String[] spliceInfo = studentInfo.split(" ");
//						inputInfo = new Student(Integer.parseInt(spliceInfo[0]), //학생번호
//												spliceInfo[1], 					 //학생이름
//												Integer.parseInt(spliceInfo[2]));//점수
//						break;
//					}catch (Exception e) {
//						System.out.println("올바르지 않은 입력입니다.");
//					}
//				}
//				
//				if(app.add(inputInfo))
//				{
//					System.out.println("등록완료");
//				}
//				else {
//					System.out.println("등록실패");
//				}
//				break;
//			case 2:
//				List<Student> list = app.list();
//				for(Student std : list)
//				{
//					System.out.println(std.toString());
//				}
//				break;
//			case 9:
//				System.out.println("프로그램 종료");
//				app.save();
//				run = false;
//				break;
//			}
//		}
//	}
//	static void write(List<Student> _stroage)
//	{
//		//Student 정보가 저장된 컬렉션을 text.txt파일에 저장
//		try {
//			FileWriter fw = new FileWriter("c:/temp/testFile.txt");
//			BufferedWriter bw = new BufferedWriter(fw);
//			
//			for(Student std : _stroage)
//			{
//				String str = std.getSno() + " " + std.getSname() + " " + std.getScore();
//				bw.write(str + "\n");
//			}
//			
//			bw.flush();
//			fw.flush();
//			bw.close();
//			fw.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("end of write.");
//	}
//	static void read(List<Student> _storage)
//	{
//		// text.txt 파일 읽어서 => Student 정보를 컬렉션에 저장
//		try {
//			FileReader fr = new FileReader("c:/temp/testFile.txt");
//			BufferedReader br = new BufferedReader(fr);
//			
//			while(true)
//			{
//				String read = br.readLine(); //학생번호 이름 점수
//				if (read == null) {break;}
//				String[] readAry = read.split(" ");
//				_storage.add(new Student(Integer.parseInt(readAry[0]), 	//학생 번호
//										readAry[1], 					//학생 이름
//										Integer.parseInt(readAry[2])));	//학생 점수
//			}
//			
//			br.close();
//			fr.close();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("end of read.");
//	}
//}
