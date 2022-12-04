package app.constant;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Optional;

public class ListingArguments {
    @PositiveOrZero
    private Integer offset = 0;

    @Positive
    private Integer max;

    @Pattern(regexp = "id|name")
    private String sort;

    @Pattern(regexp = "asc|ASC|desc|DESC")
    private String order;

    public ListingArguments() {
    }

    public ListingArguments(Integer offset, Integer max, String sort, String order) {
        this.offset = offset;
        this.max = max;
        this.sort = sort;
        this.order = order;
    }

    public Optional<Integer> getOffset() {
        return Optional.ofNullable(offset);
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Optional<Integer> getMax() {
        return Optional.ofNullable(max);
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Optional<String> getSort() {
        return Optional.ofNullable(sort);
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Optional<String> getOrder() {
        return Optional.ofNullable(order);
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
