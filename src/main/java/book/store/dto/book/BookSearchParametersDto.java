package book.store.dto.book;

public record BookSearchParametersDto(String[] authors,
                                      String[] publishers,
                                      String[] languages,
                                      String[] genres) {
}
