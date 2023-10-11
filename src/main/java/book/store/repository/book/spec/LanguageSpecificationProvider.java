package book.store.repository.book.spec;

import book.store.model.Book;
import book.store.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;

public class LanguageSpecificationProvider implements SpecificationProvider<Book, String[]> {
    private static final String KEY = "language";

    @Override
    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root.get(KEY).in(Arrays.stream(params).toArray());
    }
}
