package book.store.repository;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationProvider<T, V> {
    Specification<T> getSpecification(V params);
}
