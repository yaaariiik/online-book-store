package book.store.dto.book;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private String description;
    private String publisher;
    private String language;
    private String genre;
    private Integer pages;
    private String coverImage;
}
