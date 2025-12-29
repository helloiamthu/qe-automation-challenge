package test.java.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class GitHubApiTest {

    @Test
    public void analyzeSeleniumHQRepos() {
        RestAssured.baseURI = "https://api.github.com";

        Response response = RestAssured
                .given()
                .get("/orgs/SeleniumHQ/repos");

        List<Map<String, Object>> repos = response.jsonPath().getList("$");

        int totalOpenIssues = 0;
        String topRepo = "";
        int maxStars = 0;

        for (Map<String, Object> repo : repos) {
            int openIssues = (int) repo.get("open_issues_count");
            int stars = (int) repo.get("stargazers_count");
            String name = (String) repo.get("name");

            totalOpenIssues += openIssues;

            if (stars > maxStars) {
                maxStars = stars;
                topRepo = name;
            }
        }

        System.out.println("Total open issues: " + totalOpenIssues);
        System.out.println("Highest-rated repo: " + topRepo + " (" + maxStars + " stars)");
    }
}
