package com.yedam.Collection;

import java.util.Stack;

public class StackExe {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("홍길동");
		stack.push("김민석");
		stack.push("최만석");
		
		stack.pop();//pop 객체가져오고 삭제 peek 객체가져오고 삭제는 X
		while(!stack.isEmpty()) {
			String result = stack.peek();
			System.out.println(result);
		}
		
		//home->product->sell->시점.
	}
}
