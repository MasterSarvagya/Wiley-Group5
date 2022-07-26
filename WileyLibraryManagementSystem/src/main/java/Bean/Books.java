package Bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Books {

	private int bookID;
	private String bookName, bookAuthor, bookType;

}
