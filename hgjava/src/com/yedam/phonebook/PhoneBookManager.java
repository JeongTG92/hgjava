package com.yedam.phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.jar.Attributes.Name;

import com.yedam.Collection.SetExe;

// 생성자(초기화) 등록 조회 삭제 종료(파일저장) 기능구현
public class PhoneBookManager {

	private File dataFile = new File("c:/Temp/phonebook.txt");
	// 컬렉션 선언
	HashSet<PhoneInfo> storage = new HashSet<PhoneInfo>();
	
	// 싱글톤
	private static PhoneBookManager instance; // 초기값 null

	private PhoneBookManager() {
		// 초기화작업
		readFromFile();
		// 확인

	}

	public static PhoneBookManager getInstance() {
		if (instance == null) {
			instance = new PhoneBookManager();
		}
		return instance;
	}
	
	//메소드1,2,3
	private PhoneInfo getFriendInfo() {
		System.out.println("이름>");
		String name = MenuViewer.keybord.nextLine();
		System.out.println("연락처>");
		String phone = MenuViewer.keybord.nextLine();
		return new PhoneInfo(name, phone);
	}
	
	private PhoneInfo getCompanyFriendInfo() {
		System.out.println("이름>");
		String name = MenuViewer.keybord.nextLine();
		System.out.println("연락처>");
		String phone = MenuViewer.keybord.nextLine();
		System.out.println("회사>");
		String company = MenuViewer.keybord.nextLine();
		return new PhoneCompanyInfo(name, phone, company);
	
	}
	
	private PhoneInfo getUnivFriendInfo() {
		System.out.println("이름>");
		String name = MenuViewer.keybord.nextLine();
		System.out.println("연락처>");
		String phone = MenuViewer.keybord.nextLine();
		System.out.println("전공>");
		String major = MenuViewer.keybord.nextLine();
		System.out.println("학년>");
		int year = MenuViewer.keybord.nextInt();
		MenuViewer.keybord.nextLine();
		return new PhoneUnivInfo(name, phone, major, year);
	}
	
	//추가
	public void inputData() {
		System.out.println("구분");
		System.out.println("1.일반 2.회사 3.학교");
		System.out.print("선택>>> ");
		int choice = MenuViewer.keybord.nextInt();
		MenuViewer.keybord.nextLine();
		
		PhoneInfo info = null;
		switch(choice) {
		case InputSelect.NOMAL:
			info = getFriendInfo();
			break;
		case InputSelect.COMPANY:
			info = getCompanyFriendInfo();
			break;
		case InputSelect.UNIV:
			info = getUnivFriendInfo();
		}
		
		if(storage.add(info)) {
			System.out.println("등록 완료");
		}else {
			System.out.println("등록 오류");
		}
	}
	
	//삭제
	public void deleteData() {
		//이름검색후 삭제 Iterator => iter.hasNext, iter.next, iter.remove
		System.out.print("성함입력>>");
		String name = MenuViewer.keybord.nextLine();
		
		Iterator<PhoneInfo> iter = storage.iterator();
		while(iter.hasNext()) {
			PhoneInfo info = iter.next();
			if(info.getName().equals(name)) {
				iter.remove();
				System.out.println("삭제완료");
				return;
			}
			}
		
	}
	//검색
	public void searchData() {
		System.out.println("성함입력>>");
	    String name = MenuViewer.keybord.nextLine();
	    
	    Iterator<PhoneInfo> iter = storage.iterator();

	    while (iter.hasNext()) {
	        PhoneInfo info = iter.next();
	        if (info.getName().equals(name)) {
	        	iter.next();
	            System.out.println("검색 결과:");
	            System.out.println(info);
	            break;
	        }
	}
}

	// 초기화.
	public void readFromFile() {
		if (dataFile.exists() == false)
			return; // 메소드종료

		try {
			// 있으면...파일읽기
			FileReader fr = new FileReader(dataFile);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			PhoneInfo info = null;

			while ((str = br.readLine()) != null) {
				String[] record = str.split(",");
				// 컬렉션에 저장 //

				int type = Integer.parseInt(record[0]);
				switch (type) {
				case InputSelect.NOMAL:
					info = new PhoneInfo(record[1], record[2]);
					break;
				case InputSelect.COMPANY:
					info = new PhoneCompanyInfo(record[1], record[2], record[3]);
					break;
				case InputSelect.UNIV:
					info = new PhoneCompanyInfo(record[1], record[2], record[3]);
					Integer.parseInt(record[4]);

				}
				storage.add(info);
			} // end of while

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 저장
	public void storeToFile() {
		try {
			FileWriter fr = new FileWriter(dataFile);
			Iterator<PhoneInfo> iter = storage.iterator();

			while (iter.hasNext()) {
				PhoneInfo info = iter.next();
				// toString 활용
				fr.write(info.toString()+ "\n");
			}
			fr.flush(); fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}