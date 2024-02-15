package co.yedma;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 전체필드값을 가지는 생성자
@NoArgsConstructor // 기본생성자.
public class Employee {
	private int empNo; //사원번호
	private String empName;// 사원이름
	private String email;
	private String phone;
	private Date hireDate;
	private int salary;
	private String department;
}
