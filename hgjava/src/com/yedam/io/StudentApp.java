package com.yedam.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentApp {
	// 초기화(text.dat) => 컬렉션에 저장
	// 추가 => 컬렉션에 추가
	// 목록
	// 종료 => 컬렉션 -> 파일 저장
	List<Student> storage = new ArrayList<Student>();

	public StudentApp() {
		init();
	}
	
	public void init() {
		// text.txt 파일 읽어서 => Student 정보를 컬렉션에 저장
		try {
			FileReader fr = new FileReader("c:/temp/testFile.txt");
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				String read = br.readLine(); // 학생번호 이름 점수
				if (read == null) {
					break;
				}
				String[] readAry = read.split(" ");
				storage.add(new Student(Integer.parseInt(readAry[0]), // 학생 번호
										readAry[1], // 학생 이름
										Integer.parseInt(readAry[2]))); // 학생 점수
			}

			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of read.");
	}

	public boolean add(Student _std) {
		return storage.add(_std);
	}

	public List<Student> list() {
		return storage;
	}

	public void save() {
		// Student 정보가 저장된 컬렉션을 text.txt파일에 저장
		try {
			FileWriter fw = new FileWriter("c:/temp/testFile.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (Student std : storage) {
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
		System.out.println("end of write.");
	}
}
