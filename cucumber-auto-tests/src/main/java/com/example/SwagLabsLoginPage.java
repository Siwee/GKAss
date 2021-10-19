package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsLoginPage extends BaseClass {

    private static By usernameBy = By.name("user-name");
    private static By passwordBy = By.name("password");
    private static By loginButtonBy = By.name("login-button");
    private static By productPageTitle = By.xpath("//*[@id='header_container']/div[2]/span");

    public static void login() {
        try {
            Thread.sleep(2000);
            driver.findElement(usernameBy).sendKeys("standard_user");
            Thread.sleep(1000);
            driver.findElement(passwordBy).sendKeys("secret_sauce");
            Thread.sleep(1000);
            driver.findElement(loginButtonBy).click();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String getProductPageTitle() {
        String title=null;
        try {

           title= driver.findElement(productPageTitle).getText();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return title;
    }

}
