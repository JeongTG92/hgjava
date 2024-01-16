package com.yedam.variable;

public class VariableExe4 {
 public static void main(String[] arge) {
	 
	 //true / false.
	 boolean isTrue = true; //10 > 20;
	 
	 isTrue = update(10);
	 
	 if(isTrue) {
		 System.out.println("참값");
	 }else {
		 System.out.println("거짓값");
	 }
	 
	 Member m1 = new Member();
	 m1.name = "홍길동";
	 m1.age = 20;
	 m1.height = 167.8;
 	
	 Member m2 =new Member();
	 m2.name = "홍길동";
	 m2.age = 20;
	 m2.height = 167.8;
	 
	 isTrue = m1.height > m2.height;
	 isTrue = m1.age == m2.age;
	 isTrue = m1 == m2;
	 
	 System.out.println(isTrue);
	 
	 byte a = 10;
	 int b = a; //자동 타입변환 작은타입이 큰타입으로 저장 될때
	 
	 int intvalue = 10000;
	 byte bytevalue = (byte) intvalue;
	 System.out.println(bytevalue);
 } 
 
 
 //end of main
 	public static boolean update(int arg) {
		return arg % 2 == 0; // 홀수 f 짝수 t
		
	} //end of update
}//end of class
