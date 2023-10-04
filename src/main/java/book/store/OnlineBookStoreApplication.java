package book.store;

import book.store.dto.book.CreateBookRequestDto;
import book.store.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookStoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                CreateBookRequestDto theFountainhead = new CreateBookRequestDto();
                theFountainhead.setTitle("Джерело");
                theFountainhead.setAuthor("Айн Ренд");
                theFountainhead.setIsbn("9786177279555");
                theFountainhead.setPrice(BigDecimal.valueOf(396));

                bookService.save(theFountainhead);
                System.out.println("All books: " + bookService.findAll());
                System.out.println("Book by id: " + bookService.findById(1L));
            }
        };
    }
}
