package app.mapper;

import app.entity.Genre;
import org.apache.ibatis.annotations.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Mapper
public interface GenreMapper {

    @Select("select * from genre where id=#{id}")
    Genre findById(Long id);

    @Insert("insert into genre(name) values(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Genre genre);

    @Delete("delete from genre where id=#{id}")
    void deleteById(Long id);

    @Update("update genre set name=#{name} where id=#{id}")
    void update(@Param("id") Long id, @Param("name") String name);

    @Select("select * from genre")
    List<Genre> findAll();

    @Select("select * from genre order by ${sort} ${order}")
    List<Genre> findAllBySortAndOrder(@NotNull @Pattern(regexp = "id|name") String sort,
                                      @NotNull @Pattern(regexp = "asc|ASC|desc|DESC") String order);

    @Select("select * from genre order by ${sort} ${order} limit ${offset}, ${max}")
    List<Genre> findAllByOffsetAndMaxAndSortAndOrder(@PositiveOrZero int offset,
                                                     @Positive int max,
                                                     @NotNull @Pattern(regexp = "id|name") String sort,
                                                     @NotNull @Pattern(regexp = "asc|ASC|desc|DESC") String order);

    @Select("select * from genre limit ${offset}, ${max}")
    List<Genre> findAllByOffsetAndMax(@PositiveOrZero int offset, @Positive int max);

}
