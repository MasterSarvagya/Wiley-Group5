package Bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Books {

	private Integer bookID,originalQty,leftQty;
	private String bookName, bookAuthor, bookType;

}
//I  m shivangi