package com.github.jirkasindelar323.model;

public class PersonalInfo {
    private String name;
    private String title;
    private String bio;
    private String email;
    private String github;
    private String linkedin;
    private String location;

    public PersonalInfo() {
    }

    public PersonalInfo(String name, String title, String bio, String email, String github, String linkedin, String location) {
        this.name = name;
        this.title = title;
        this.bio = bio;
        this.email = email;
        this.github = github;
        this.linkedin = linkedin;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
