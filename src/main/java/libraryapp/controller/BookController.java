package libraryapp.controller;

import jakarta.validation.Valid;
import libraryapp.dto.AuthorDtoOut;
import libraryapp.dto.BookDtoIn;
import libraryapp.dto.BookDtoOut;
import libraryapp.entity.Book;
import libraryapp.mapper.AuthorMapper;
import libraryapp.mapper.BookMapper;
import libraryapp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("http://localhost:3000/")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> add(  @RequestBody BookDtoIn bookDtoIn){
        final Book book = bookService.add(bookDtoIn);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDtoOut> findById(@PathVariable UUID id){
        final Optional<Book> optionalBook = bookService.findById(id);
        return optionalBook.map(book -> ResponseEntity.ok(BookMapper.mapToDtoOut(book)))
                .orElseGet(()-> ResponseEntity.of(Optional.empty()));
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<BookDtoOut> findByTitle(@PathVariable String title){
        final Optional<Book> optionalBook = bookService.findByTitle(title);
        return optionalBook.map(book -> ResponseEntity.ok(BookMapper.mapToDtoOut(book)))
                .orElseGet(()-> ResponseEntity.of(Optional.empty()));
    }
    @GetMapping("author/{authorId}")
    public List<BookDtoOut> findByAuthorId(@PathVariable UUID authorId){
        return bookService.findByAuthorId(authorId).stream()
                .map(BookMapper::mapToDtoOut)
                .collect(Collectors.toList());
    }
    @DeleteMapping
    public void deleteById (@RequestParam UUID bookId){
        bookService.deleteById(bookId);
    }
//    @PatchMapping("{bookId}")
//    public void updateQuantity(@PathVariable UUID bookId, @RequestParam Long quantity){
//        bookService.updateQuantity(bookId, quantity);
//    }
    @GetMapping
    public List<BookDtoOut> findAll(){
        return bookService.findAll().stream()
                .map(BookMapper::mapToDtoOut)
                .collect(Collectors.toList());
    }


    @GetMapping("/topBook")
    public  List<BookDtoOut>getTopBooks(){
        return bookService.topThreeBook().stream()
                .map(BookMapper::mapToDtoOut)
                .collect(Collectors.toList());
    }


}
