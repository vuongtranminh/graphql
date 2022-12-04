package app.graphql.query;

import app.constant.ListingArguments;
import app.entity.Genre;
import app.repository.GenreRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GenreQuery {

    private final GenreRepository repository;

    public GenreQuery(GenreRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public Genre genre(@Argument(name = "id") Long id) {
        return repository
                .findById(id)
                .orElse(null);
    }

    @QueryMapping
    public List<Genre> genres(@Argument(name = "args") ListingArguments args) {
        return repository.findAll(args);
    }

}
