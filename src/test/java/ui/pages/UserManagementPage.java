package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class UserManagementPage {

    WebDriver driver;
    WebDriverWait wait;

    By addBtn = By.xpath("//button[normalize-space()='Add']");
    By userRoleLabel = By.xpath("//label[normalize-space()='User Role']");
    By selectRole = By.xpath(
        "//label[normalize-space()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"
    );
    By selectStatus = By.xpath(
        "//label[normalize-space()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"
    );
    By dropdownOption(String value) {
        return By.xpath("//div[@role='listbox']//span[normalize-space()='" + value + "']");
    }
    By username = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By password = By.xpath("(//input[@type='password'])[1]");
    By confirmPassword = By.xpath("(//input[@type='password'])[2]");
    By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    By employeeDropdown = By.xpath("//div[@role='listbox']");
    By saveBtn = By.xpath("//button[@type='submit']");
    By searchUsernameInput = By.xpath("//label[normalize-space()='Username']/following::input[1]");
    By searchBtn = By.xpath("//button[normalize-space()='Search']");
    By resultTable = By.xpath("//div[@class='oxd-table-body']");

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    private By employeeOption(String name) {
        return By.xpath("//div[@role='option']//span[normalize-space()='" + name + "']");
    }

    private By usernameInTable(String username) {
    return By.xpath("//div[@class='oxd-table-body']//div[text()='" + username + "']");
}

    public void selectUserRole(String role) {
        driver.findElement(selectRole).click();
        driver.findElement(dropdownOption(role)).click();
    }

    public void selectStatus(String status) {
        driver.findElement(selectStatus).click();
        driver.findElement(dropdownOption(status)).click();
    }

    public void selectEmployeeName(String employeeName) {
        driver.findElement(employeeNameInput).sendKeys(employeeName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(
            employeeOption(employeeName)
    )).click();
}


    public String createUser() {
        String newUsername = "auto_user_" + System.currentTimeMillis();
        driver.findElement(addBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userRoleLabel));
        selectUserRole("Admin");
        selectStatus("Enabled");
        selectEmployeeName("Orange Test");
        driver.findElement(username).sendKeys(newUsername);
        driver.findElement(password).sendKeys("Password@123");
        driver.findElement(confirmPassword).sendKeys("Password@123");
        driver.findElement(saveBtn).click();
        return newUsername;
    }

    public boolean searchAndVerifyUser(String username) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn));
    driver.findElement(searchUsernameInput).sendKeys(username);
    driver.findElement(searchBtn).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(resultTable));
    return driver.findElements(usernameInTable(username)).size() > 0;
}
}
