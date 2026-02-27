package com.github.jirkasindelar323.model;

public class Project {
    private String name;
    private String description;
    private String techStack;
    private String githubUrl;
    private String liveUrl;

    public Project() {
    }

    public Project(String name, String description, String techStack, String githubUrl, String liveUrl) {
        this.name = name;
        this.description = description;
        this.techStack = techStack;
        this.githubUrl = githubUrl;
        this.liveUrl = liveUrl;
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

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }
}
