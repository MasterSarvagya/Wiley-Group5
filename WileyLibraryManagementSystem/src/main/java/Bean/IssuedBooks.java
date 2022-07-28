package Bean;

import java.time.LocalDateTime;
import java.util.Date;

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

}
