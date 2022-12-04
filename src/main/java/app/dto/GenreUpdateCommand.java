package app.dto;

import javax.validation.constraints.NotBlank;

public class GenreUpdateCommand {
    private Long id;

    @NotBlank
    private String name;

    public GenreUpdateCommand(Long id, @NotBlank String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
