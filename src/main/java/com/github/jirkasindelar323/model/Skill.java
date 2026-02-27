package com.github.jirkasindelar323.model;

public class Skill {
    private String name;
    private String category;
    private int proficiency;

    public Skill() {
    }

    public Skill(String name, String category, int proficiency) {
        this.name = name;
        this.category = category;
        this.proficiency = proficiency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }
}
