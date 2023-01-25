package com.fh.burgenland.swm2.GithubRepositoriesAPI;

import java.io.IOException;

public class GitHubException extends IOException {
    private int errorCode;
    private String errorMessage;

    public GitHubException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}