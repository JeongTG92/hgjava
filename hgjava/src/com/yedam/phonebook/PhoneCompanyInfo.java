package com.yedam.phonebook;

import java.util.jar.Attributes.Name;

public class PhoneCompanyInfo extends PhoneInfo{
	String company;
	
	public PhoneCompanyInfo(String name, String phone, String company) {
		super(name, phone); //부모생성자.
		this.company = company;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("company: " + company);
	}
	
	@Override
	public String toString() {
		return InputSelect.COMPANY + "," + getName() + "," + getPhone() + "," + company;
	}
}
