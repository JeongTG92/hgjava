package com.yedam.io.emp;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//초기화(데이터 활용 컬렉션)
//추가
//목록
//종료(컬렉션 -> 파일저장)                                 
public class EmpApp {
	List<Employee> storage = new ArrayList<Employee>();
	
	public EmpApp() {
		init();
	}
	public boolean add(Employee _emp)
	{
		return storage.add(_emp);
	}
	public List<Employee> list(){
		return storage;
	}
	public void init()
	{
		try {
			String folderPath = "c:/temp/emp.txt";
			
			File file = new File(folderPath);
			
			if (!file.exists())
			{
				file.createNewFile();
			}
			
			FileInputStream fis = new FileInputStream(folderPath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			storage = (List<Employee>)ois.readObject();
			ois.close();
			fis.close();
			
		}catch(EOFException e)
		{
			System.out.println("파일을 불러왔지만 현재 비어있음.");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("파일이 없습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("알 수 없는 오류.");
		}
	}
	public void save()
	{
		//기본스트림 => 보조스트림 => 저장
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/emp.txt");			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(storage); //객체 타입을 파일에 쓰기
			oos.flush(); fos.flush();
			oos.close(); fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
