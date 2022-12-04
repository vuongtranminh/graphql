package app.repository.impl;

import app.constant.ListingArguments;
import app.entity.Genre;
import app.mapper.GenreMapper;
import app.repository.GenreRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GenreRepositoryImpl implements GenreRepository {

    private final GenreMapper genreMapper;

    public GenreRepositoryImpl(GenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return Optional.ofNullable(genreMapper.findById(id));
    }

    @Override
    public Genre save(String name) {
        Genre genre = new Genre(name);
        genreMapper.save(genre);
        return genre;
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(genre -> genreMapper.deleteById(id));
    }

    @Override
    public List<Genre> findAll(ListingArguments args) {
        if (args.getMax().isPresent() && args.getSort().isPresent() && args.getOffset().isPresent() && args.getOrder().isPresent()) {
            return genreMapper.findAllByOffsetAndMaxAndSortAndOrder(
                    args.getOffset().get(),
                    args.getMax().get(),
                    args.getSort().get(),
                    args.getOrder().get());
        }

        if (args.getMax().isPresent() && args.getOffset().isPresent() && (!args.getSort().isPresent() || !args.getOrder().isPresent())) {
            return genreMapper.findAllByOffsetAndMax(args.getOffset().get(), args.getMax().get());
        }

        if ((!args.getMax().isPresent() || !args.getOffset().isPresent()) && args.getSort().isPresent() && args.getOrder().isPresent()) {
            return genreMapper.findAllBySortAndOrder(args.getSort().get(), args.getOrder().get());
        }

        return genreMapper.findAll();
    }

    @Override
    public int update(Long id, String name) {
        genreMapper.update(id, name);
        return -1;
    }
}
