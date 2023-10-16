package book.store.dto.book;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class CreateBookRequestDto {
    @NotNull(message = "Invalid title, should not be null")
    @Size(min = 1, message = "Invalid title. Length of title mustn't be less than 1 letter")
    private String title;

    @NotNull(message = "Invalid author, should not be null")
    @Size(min = 3, message = "Invalid author. Length of author should be 3 or more letters")
    private String author;

    @NotNull(message = "Invalid isbn, should not be null")
    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})"
            + "[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)"
            + "(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
            message = "Invalid isbn. Please, enter valid 10-digit or 13-digit ISBN")
    private String isbn;

    @NotNull(message = "Invalid price, should not be null")
    @DecimalMin(value = "0.01", message = "Invalid price. Price can't be less than 0.01")
    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;

    @Size(min = 5, max = 255, message = "Invalid size of description, "
            + "should be between 5 to 255 signs")
    private String description;

    @Size(min = 5, max = 255, message = "Invalid publisher, should be between 5 to 255 signs")
    private String publisher;

    @Digits(integer = 4, fraction = 0, message = "Invalid publishYear, "
            + "should not contain more than 4 digits")
    private Integer publishYear;

    @Size(min = 3, message = "Invalid language. Shouldn't be less than 3 letters")
    private String language;

    @Size(min = 3, message = "Invalid genre. Shouldn't be less than 3 letters")
    private String genre;

    @Min(value = 1, message = "Invalid number of pages, minimum should be 1")
    private Integer pages;

    @URL(message = "Invalid coverImage. Should content a link to coverImage in URL format")
    private String coverImage;
}
