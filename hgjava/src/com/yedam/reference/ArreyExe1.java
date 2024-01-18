package com.yedam.reference;

public class ArreyExe1 {

	public static void main(String[] args) {
		//배열 선언
		int[] intAry = {10, 20, 30};// intAry[0]특정위치에서는 같음 === int, intAry[] !== int
		int[][] intArray = {{10,20}, {30,40}, {50}}; //배열언에 또 배열 
		//intAry[0] === int[], intArray[0][0] === int
		
		String[] strAry = new String[5]; //크기선언
		strAry = new String[] {"Hello","World","Nice"};
		
		for(String elem : strAry) {
			System.out.println(elem);
		}
	}

}
