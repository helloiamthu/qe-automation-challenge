package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;
    By adminMenu = By.xpath("//span[text()='Admin']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAdmin() {
        driver.findElement(adminMenu).click();
    }
}
