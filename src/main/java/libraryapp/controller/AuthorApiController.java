package libraryapp.controller;


import libraryapp.dto.AuthorDtoIn;
import libraryapp.dto.AuthorDtoOut;
import libraryapp.entity.Author;
import libraryapp.entity.Genre;
import libraryapp.mapper.AuthorMapper;
import libraryapp.repository.AuthorRepository;
import libraryapp.service.JpaAuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/author")
@CrossOrigin("http://localhost:3000/")
public class AuthorApiController {
    private final JpaAuthorService authorService;

    public AuthorApiController(JpaAuthorService authorService, AuthorRepository authorRepository) {
        this.authorService = authorService;
    }

    @GetMapping
    List<AuthorDtoOut> getAuthors(){
        return authorService.getAuthors().stream()
                .map(AuthorMapper::mapAuthorDtoOut)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public List<AuthorDtoOut> getAuthorById( @PathVariable UUID id){
        return authorService.getAuthorById(id).stream()
                .map(AuthorMapper::mapAuthorDtoOut)
                .collect(Collectors.toList());
    }
    @GetMapping("{name}")
    public List<AuthorDtoOut>getAuthorByName(@PathVariable String name){
        return authorService.getAuthorByName(name).stream()
                .map(AuthorMapper::mapAuthorDtoOut)
                .collect(Collectors.toList());
    }

    @GetMapping("{genres}")
    public List<AuthorDtoOut>getAuthorByGenres (@PathVariable Genre genre){
        return authorService.findByGenre(genre).stream()
                .map(AuthorMapper::mapAuthorDtoOut)
                .collect(Collectors.toList());
    }

    @GetMapping("/topAuthor")
    public  List<AuthorDtoOut>getTopAuthor(){
        return authorService.topThree().stream()
                .map(AuthorMapper::mapAuthorDtoOut)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody AuthorDtoIn authorDtoIn){
        return authorService.addAuthor(authorDtoIn);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Author updateAuthor(@PathVariable UUID id, @RequestBody AuthorDtoIn authorDtoIn){
        return authorService.updateAuthor(id, authorDtoIn);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@RequestParam UUID id){
        authorService.deleteById(id);
    }

    @GetMapping("/{authorId}")
    public Double authorRatting(@PathVariable UUID authorId){
        Optional<Author> authorById = authorService.getAuthorById(authorId);
        Author auth = authorById.get();
        return auth.getRating();
    }
}