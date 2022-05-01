package org.aibles.spring.criteriaquery.dto.response;

import java.time.LocalDateTime;

public class PostListingRes {
    private int id;
    private String title;
    private String creator;
    private LocalDateTime createdAt;

    public PostListingRes() {
    }

    public PostListingRes(int id, String title, String creator, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
