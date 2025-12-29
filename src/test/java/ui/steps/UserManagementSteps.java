package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import ui.base.BaseTest;
import ui.pages.*;

public class UserManagementSteps extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserManagementPage userPage;
    String createdUsername;

    @Before
    public void init() {
        setup();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        userPage = new UserManagementPage(driver);
        sleep(3000);
    }

    @Given("I open OrangeHRM login page")
    public void openLoginPage() {
        loginPage.open();
        sleep(2000);
    }

    @When("I login with valid admin credentials")
    public void login() {
        loginPage.login("Admin", "admin123");
        sleep(3000);
    }

    @When("I navigate to Admin User Management")
    public void navigateAdmin() {
        dashboardPage.goToAdmin();
        sleep(3000);
    }

    @When("I create a new user")
    public void createUser() {
        createdUsername = userPage.createUser();
        sleep(3000);
    }

    @Then("I should see the user in Records Found table")
    public void verifyUser() {
        Assert.assertTrue(userPage.searchAndVerifyUser(createdUsername));
        sleep(5000);
    }

    @After
    public void close() {
        tearDown();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
