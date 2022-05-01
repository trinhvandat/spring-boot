package org.aibles.spring.criteriaquery.dto.request;

public class PostListingReq {

    private String title;
    private String creator;

    public PostListingReq() {
    }

    /**
     * PostListingReq constructor full args.
     * @param title - post's title: String
     * @param creator - post's creator: String
     */
    public PostListingReq(String title, String creator) {
        this.title = title;
        this.creator = creator;
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
}
