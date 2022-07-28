package Bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

	private Integer empID, empPhoneNumber,bookLimit;
	private Boolean isAdmin;
	private String empName,password;

}