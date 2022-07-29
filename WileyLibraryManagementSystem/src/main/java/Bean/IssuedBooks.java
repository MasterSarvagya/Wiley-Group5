package Bean;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuedBooks {

	private int empID, bookID;
	private LocalDateTime issueDateTime, returnDateTime;
	private double lateFees;

	@Override
	public String toString() {
		return empID + "\t" + bookID + "\t" + issueDateTime + "\t" + returnDateTime + "\t" + lateFees;
	}

}
