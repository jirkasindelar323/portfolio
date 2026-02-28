package com.github.jirkasindelar323.service;

import com.github.jirkasindelar323.model.PersonalInfo;
import com.github.jirkasindelar323.model.Project;
import com.github.jirkasindelar323.model.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    public PersonalInfo getPersonalInfo() {
        return new PersonalInfo(
                "Jirka Sindelar",
                "Yeer-ka",
                "Software Developer",
                "Passionate developer with experience in Java, Spring Boot, and React",
                "jirkasindelar@example.com",
                "https://github.com/jirkasindelar323",
                "https://www.linkedin.com/in/jiri-sindelar-540a5b143",
                "601/199 William St, Melbourne VIC, Australia"
        );
    }

    public List<Project> getProjects() {
        return List.of(
                new Project(
                        "Portfolio Website",
                        "My personal portfolio built with React and Spring Boot",
                        "React, Spring Boot, TypeScript",
                        "https://github.com/jirkasindelar323/portfolio",
                        "https://jirkasindelar.com"
                )
        );
    }

    public List<Skill> getSkills() {
        return List.of(
                new Skill("Java", "Backend", 9),
                new Skill("Spring Boot", "Backend", 8),
                new Skill("React", "Frontend", 7),
                new Skill("TypeScript", "Frontend", 7),
                new Skill("PostgreSQL", "Database", 7),
                new Skill("Git", "Tools", 8)
        );
    }
}
