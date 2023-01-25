package com.fh.burgenland.swm2.GithubRepositoriesAPI;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.http.*;

import java.io.IOException;
import java.util.List;

@Service
public class GitHubService {
    private final GitHubApi gitHubApi;
    private RepositoryAPI repositoryAPI;
    private final GitHubTokenProvider tokenProvider;

    public GitHubService(RepositoryAPI repositoryAPI, GitHubTokenProvider tokenProvider) {
        this.repositoryAPI = repositoryAPI;
        this.tokenProvider = tokenProvider;
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Request newRequest = request.newBuilder()
                            .addHeader("Authorization", "Bearer " + tokenProvider.getToken())
                            .build();
                    return chain.proceed(newRequest);
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitHubApi = retrofit.create(GitHubApi.class);
    }

    public List<RepositoryAPI> getRepositories(String username) throws GitHubException {
        // Code to get all your Repositories from GitHub using gitHubApi
        try {
            return gitHubApi.getRepositories(username).execute().body();
        } catch (IOException e) {
            throw new GitHubException(500, e.getMessage());
        }
    }

    public void createRepository(RepositoryAPI repositoryAPI) throws GitHubException {
        // Code to create a repository on GitHub using gitHubApi
        try {
            gitHubApi.createRepository(repositoryAPI).execute();
        } catch (IOException e) {
            throw new GitHubException(500, e.getMessage());
        }
    }

    public boolean deleteRepository(String owner, String repo) throws GitHubException {
        // Code to delete a repository on GitHub using gitHubApi
        try {
            Response<Void> response = gitHubApi.deleteRepository(owner, repo).execute();
            if(response.isSuccessful()){
                return true;
            }
            throw new GitHubException(response.code(),response.message());
        } catch (IOException e) {
            throw new GitHubException(500, e.getMessage());
        }
    }
    public void setRepositoryAPI(RepositoryAPI repositoryAPI) {
        this.repositoryAPI = repositoryAPI;
    }

    private interface GitHubApi {
        // Code to define the endpoints for the GitHub API
        @GET("/users/{USERNAME}/repos")
        Call<List<RepositoryAPI>> getRepositories(@Path("USERNAME") String username);

        @POST("/users/repos")
        Call<RepositoryAPI> createRepository(@Body RepositoryAPI repository);

        @DELETE("/repos/{owner}/{repo}")
        Call<Void> deleteRepository(@Path("owner") String owner, @Path("repo") String repo);
    }
}