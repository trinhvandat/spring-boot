package org.aibles.spring.criteriaquery.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "POSTS")
public class PostEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    public PostEntity() {
    }

    /**
     * Function declare PostEntity - Constructor.
     * @param id - post's id: Integer
     * @param title - post's title: String
     * @param creator - post's creator: String
     * @param createdAt - post's createdAt: LocalDateTime
     */
    public PostEntity(Integer id, String title, String creator, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostEntity)) return false;
        PostEntity that = (PostEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
