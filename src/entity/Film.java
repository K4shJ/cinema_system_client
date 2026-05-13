package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 影片信息
 */
public class Film implements Serializable {

    private String id;

    private String name;

    private String description;

    private String producer;

    public Film(String id, String name, String producer, String description) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + producer + "\t" + description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(name, film.name) && Objects.equals(description, film.description) && Objects.equals(producer, film.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, producer);
    }
}
