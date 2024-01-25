package com.yedam.Collection;

public class Box<T> {// T : 오브젝트가 아닌 나중에 결정
	T  obj;
	
	void setObj(T obj) {
		this.obj = obj;
	}
	
	T  getObj() {
		return obj;
	}
}
