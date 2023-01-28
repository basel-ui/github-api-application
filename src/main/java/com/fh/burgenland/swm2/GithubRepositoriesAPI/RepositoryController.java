package com.fh.burgenland.swm2.GithubRepositoriesAPI;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/github")
public class RepositoryController {
    private final GitHubService gitHubService;

    public RepositoryController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/users/{USERNAME}/repos")
    public List<RepositoryAPI> getRepositories(@PathVariable("USERNAME") String username) throws GitHubException {
        // Code to retrieve repositories from GitHub
        return gitHubService.getRepositories(username);
    }

    @PostMapping("/user/repos")
    public void createRepository(@RequestBody RepositoryAPI repositoryAPI) throws GitHubException {
        // Code to create a new repository on GitHub
        gitHubService.createRepository(repositoryAPI);
    }

    @DeleteMapping("/users/{OWNER}/{REPO}")
    public boolean deleteRepository(@PathVariable("OWNER") String owner, @PathVariable("REPO") String repo) throws GitHubException {
        return gitHubService.deleteRepository(owner, repo);
    }
}
