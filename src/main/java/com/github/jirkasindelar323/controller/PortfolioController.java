package com.github.jirkasindelar323.controller;

import com.github.jirkasindelar323.model.PersonalInfo;
import com.github.jirkasindelar323.model.Project;
import com.github.jirkasindelar323.model.Skill;
import com.github.jirkasindelar323.service.PortfolioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/info")
    public PersonalInfo getPersonalInfo() {
        return portfolioService.getPersonalInfo();
    }

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return portfolioService.getProjects();
    }

    @GetMapping("/skills")
    public List<Skill> getSkills() {
        return portfolioService.getSkills();
    }
}
