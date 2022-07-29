package Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Books {

	private Integer bookID, originalQty, leftQty;
	private String bookName, bookAuthor, bookType;

	@Override
	public String toString() {
		return bookID + "\t" + originalQty + "\t" + leftQty + "\t" + bookName + "\t" + bookAuthor + "\t" + bookType;
	}
}