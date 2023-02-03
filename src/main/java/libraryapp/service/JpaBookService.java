package libraryapp.service;

import libraryapp.dto.BookDtoIn;
import libraryapp.entity.Book;
import libraryapp.entity.Genre;
import libraryapp.repository.BookRepository;
import libraryapp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class JpaBookService implements BookService{

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book add(BookDtoIn newBook) {
        Book book = Book.builder()
                .title(newBook.getTitle())
                .author(Set.of())
                .isbn(newBook.getIsbn())
                .releaseDate(newBook.getReleaseDate())
                .quantity(newBook.getQuantity())
                .rating(0.0)
                .genres(newBook.getGenres())
                .build();
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    @Override
    public Optional<Book> findById(UUID bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<Book> findByAuthorId(UUID authorId) {
        return bookRepository.findBookByAuthor_Id(authorId);
    }

    @Override
    public void deleteById(UUID bookId) {
        bookRepository.deleteById(bookId);
    }

//    @Override
//    public void updateQuantity(UUID bookId, Long quantity) {
//        Optional<Book> bookToBeUpdated = bookRepository.findById(bookId).ifPresent(book -> book.setQuantity(ge));
//        if(bookToBeUpdated.isPresent()){
//            Book book = bookToBeUpdated.get();
//            book.setQuantity(quantity);
//            bookRepository.save(book);
//        }
//    }
    //TODO move updateQuantity to BorrowEventElementService

    @Override
    public List<Book> findByGenre(Genre genre) {
        return bookRepository.findBookByGenre(genre);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


}
