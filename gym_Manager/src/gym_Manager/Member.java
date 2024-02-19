package gym_Manager;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private int mno;
	private String Name;
	private String Email;
	private Date Birth;
	private String Gender;
	private String Address;
	private String Phone;
	
}
