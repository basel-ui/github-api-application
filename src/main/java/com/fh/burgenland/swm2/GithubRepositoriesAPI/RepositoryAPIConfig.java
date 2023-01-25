package com.fh.burgenland.swm2.GithubRepositoriesAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryAPIConfig {

    @Bean
    public RepositoryAPI repositoryAPI(){
        return new RepositoryAPI();
    }
}

