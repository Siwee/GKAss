package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductsPage extends BaseClass {

    private static By item1 = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
    private static By item2 = By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']");
    private static By cartButtonBy = By.xpath("//*[@id='shopping_cart_container']/a");
    private static By productPageTitle = By.xpath("//*[@id='header_container']/div[2]/span");
    private static By numberOfItemsOnCart=By.xpath("//*[@id='shopping_cart_container']/a/span");


    public static void addProductsToCart() {

        try {

             driver.findElement(item1).click();
            driver.findElement(item2).click();
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void navigateToCart() {

        try {
            Thread.sleep(2000);
            driver.findElement(cartButtonBy).click();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static String getItemsOnCart() {
        String noOfItemsInCart=null;
        try {

            noOfItemsInCart= driver.findElement(numberOfItemsOnCart).getText();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return noOfItemsInCart;
    }
//    public boolean isAt(Products products) {
//        try {
//            products.isAt();
//        } catch (Error e) {
//            return false;
//        }
//        return true;
//    }
}
