package book.store.service.impl;

import book.store.dto.book.BookDto;
import book.store.dto.book.CreateBookRequestDto;
import book.store.exception.EntityNotFoundException;
import book.store.mapper.BookMapper;
import book.store.model.Book;
import book.store.repository.BookRepository;
import book.store.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookRepository.save(bookMapper.toModel(requestDto));
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find a book by id" + id)
        );
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto updateById(Long id, CreateBookRequestDto requestDto) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book by id" + id + " doesn't exist.");
        }
        Book book = bookMapper.toModel(requestDto);
        book.setId(id);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
