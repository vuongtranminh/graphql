package app.repository;

import app.constant.ListingArguments;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface MybatisRepository<T, ID> {

    Optional<T> findById(ID id);

    T save(@NotBlank String name);

    void deleteById(ID id);

    List<T> findAll(@NotNull ListingArguments args);

    int update(ID id, @NotBlank String name);

}
