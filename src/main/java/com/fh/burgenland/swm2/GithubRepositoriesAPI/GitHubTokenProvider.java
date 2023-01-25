package com.fh.burgenland.swm2.GithubRepositoriesAPI;

import org.springframework.stereotype.Component;

@Component
public class GitHubTokenProvider {
    private final String token;

    public GitHubTokenProvider() {
        this.token = System.getenv("GITHUB_TOKEN");
    }
    public String getToken() {
        return token;
    }
}
