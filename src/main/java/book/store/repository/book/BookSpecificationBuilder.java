package book.store.repository.book;

import book.store.dto.book.BookSearchParametersDto;
import book.store.model.Book;
import book.store.repository.SpecificationBuilder;
import book.store.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder
        implements SpecificationBuilder<Book, BookSearchParametersDto> {
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParameters) {
        Specification<Book> spec = Specification.where(null);
        if (searchParameters.authors() != null && searchParameters.authors().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("author")
                    .getSpecification(searchParameters.authors()));
        }
        if (searchParameters.genres() != null && searchParameters.genres().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("genre")
                    .getSpecification(searchParameters.genres()));
        }
        if (searchParameters.languages() != null && searchParameters.languages().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("language")
                    .getSpecification(searchParameters.languages()));
        }
        if (searchParameters.publishers() != null && searchParameters.publishers().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("publisher")
                    .getSpecification(searchParameters.publishers()));
        }
        return spec;
    }
}
