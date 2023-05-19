package libraryapp.dto;

import libraryapp.entity.Genre;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class BookDtoOut {

    private UUID id;
    private String title;
    private Set<String> authors;
    private Long isbn;
    private Long quantity;
    private LocalDate releaseDate;
    private Set<Genre> genres ;
    private Double rating;
}
