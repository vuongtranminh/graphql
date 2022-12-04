package app.entity;

public class Genre {

    private Long id;
    private String name;

    public Genre() {
    }

    public Genre(String name) {
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
