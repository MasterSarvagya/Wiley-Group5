package Bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

	private Integer empID;
	private Long empPhoneNumber;
	private Integer bookLimit;
	private Boolean isAdmin;
	private String empName, password;

	@Override
	public String toString() {
		return empID + "\t" + empName + "\t\t" + empPhoneNumber + "\t" + bookLimit;
	}

}
