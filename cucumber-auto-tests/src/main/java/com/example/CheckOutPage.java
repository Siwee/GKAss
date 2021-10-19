package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckOutPage extends BaseClass {

    private static By firstNameBy = By.id("first-name");
    private static By lastNameBy = By.id("last-name");
    private static By postalCodeBy = By.id("postal-code");
    private static By continueButtonBy = By.id("continue");
    private static By finishButtonBy = By.id("finish");
    private static By checkoutButtonBy = By.id("checkout");
    private static By completeOrderText = By.xpath("//*[@id='checkout_complete_container']/h2");

    public static void insertCheckOutInfo() {
        try {
            driver.findElement(checkoutButtonBy).click();
            Thread.sleep(2000);
            driver.findElement(firstNameBy).sendKeys("Siwe");
            Thread.sleep(1000);
            driver.findElement(lastNameBy).sendKeys("Mkhize");
            Thread.sleep(1000);
            driver.findElement(postalCodeBy).sendKeys("1685");
            Thread.sleep(1000);
            driver.findElement(continueButtonBy).click();
            Thread.sleep(3000);
            scrollToElement();
            Thread.sleep(2000);
            driver.findElement(finishButtonBy).click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String getCompleteOrderPageTitle() {
        String title=null;
        try {

            title= driver.findElement(completeOrderText).getText();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return title;
    }

    public static  void scrollToElement() {
        try {
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("javascript:window.scrollBy(250,350)");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
