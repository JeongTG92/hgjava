package com.yedam.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentExe {
	public static void main(String[] args) {
		
		
		
		List<Student>storage = new ArrayList<Student>();
		storage.add(new Student(201, "김민규", 90));
		storage.add(new Student(202, "박민석", 77));
		storage.add(new Student(203, "김창석", 85));
		storage.add(new Student(204, "이연복", 88));
		storage.add(new Student(205, "김민재", 94));
		
		// 컬렉션정보 출력.
		for(Student std : storage) {
			System.out.println(std.toString());
		}
		
		try {
			FileWriter fw = new FileWriter("c:/Temp/text.dat");
			BufferedWriter bw = new BufferedWriter(fw);
			
			//반복
			for(Student std : storage) {
				String str = std.getSno() + " " + std.getSname() + " " + std.getScore();
				bw.write(str + "\n");
			}
			bw.flush();
			fw.flush();
			bw.close(); 
			fw.close(); 
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
		
	}//end of main
	static void read () {
		
		// text.dat 파일 읽어서 => Student 컬렉션저장.
		List<Student> storage = new ArrayList<Student>();
		try {
			FileReader fr = new FileReader("c:/Temp/text.dat");
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				String read = br.readLine(); // 101 name 90
				if (read == null) {
					break;
				}
				String[] readAry = read.split(" ");
				Student std = new Student(Integer.parseInt(readAry[0]),//학생번호 
															readAry[1], //이름
											                Integer.parseInt(readAry[2])//점수
															);
				storage.add(std);
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 컬렉션정보 출력.
				for(Student std : storage) {
					System.out.println(std.toString());
				}
	}
}
