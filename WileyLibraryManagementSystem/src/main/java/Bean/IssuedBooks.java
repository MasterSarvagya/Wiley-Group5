package Bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuedBooks {

	private int empID, bookID;
	private Date issueDate, returnDate;
	private double lateFees;

}
