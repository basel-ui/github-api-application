package com.fh.burgenland.swm2.GithubRepositoriesAPI;

public class RepositoryAPI {
    private String name;
    private String description;
    private String homepage;
    private boolean privateRepository;
    private boolean hasIssues;
    private boolean hasWiki;
    private boolean hasDownloads;

    public RepositoryAPI(String name, String description, String homepage, boolean privateRepository, boolean hasIssues, boolean hasWiki, boolean hasDownloads) {
        this.name = name;
        this.description = description;
        this.homepage = homepage;
        this.privateRepository = privateRepository;
        this.hasIssues = hasIssues;
        this.hasWiki = hasWiki;
        this.hasDownloads = hasDownloads;
    }

    public RepositoryAPI() {

    }

    // Getter and setter methods for each field

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

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public boolean isPrivateRepository() {
        return privateRepository;
    }

    public void setPrivateRepository(boolean privateRepository) {
        this.privateRepository = privateRepository;
    }

    public boolean isHasIssues() {
        return hasIssues;
    }

    public void setHasIssues(boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public boolean isHasDownloads() {
        return hasDownloads;
    }

    public void setHasDownloads(boolean hasDownloads) {
        this.hasDownloads = hasDownloads;
    }
}