package com.janeck.web.tools;

public class Feedback {
    private String name;
    private String email;
    private String rating;
    private String comments;

    public Feedback() {}

    public Feedback(String name, String email, String rating, String comments) {
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", rating='" + rating + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}