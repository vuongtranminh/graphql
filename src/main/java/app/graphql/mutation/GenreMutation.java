package app.graphql.mutation;

import app.dto.GenreSaveCommand;
import app.dto.GenreUpdateCommand;
import app.entity.Genre;
import app.repository.GenreRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GenreMutation {

    private final GenreRepository repository;

    public GenreMutation(GenreRepository repository) {
        this.repository = repository;
    }

    @MutationMapping
    public String updateGenre(@Argument(name = "genre") GenreUpdateCommand command) {
        repository.update(command.getId(), command.getName());
        return "success";
    }

    @MutationMapping
    public Genre createGenre(@Argument(name = "genre") GenreSaveCommand command) {  // name to map graphql
        Genre genre = repository.save(command.getName());
        return genre;
    }

    @MutationMapping
    public String removeGenre(@Argument(name = "id") Long id) {
        repository.deleteById(id);
        return "success";
    }

}
