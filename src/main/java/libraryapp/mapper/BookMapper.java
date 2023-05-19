package libraryapp.mapper;

import libraryapp.dto.BookDtoOut;
import libraryapp.entity.Author;
import libraryapp.entity.Book;


import java.util.HashSet;
import java.util.stream.Collectors;


public class BookMapper {

   public static BookDtoOut mapToDtoOut(Book book){
        return BookDtoOut.builder()
                .id(book.getId())
                .authors(book.getAuthor().stream()
                        .map(Author::getName)
                        .collect(Collectors.toSet()))
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .rating(book.getRating())
                .releaseDate(book.getReleaseDate())
                .quantity(book.getQuantity())
                .genres(new HashSet<>(book.getGenres()))
                .build();
    }
}
