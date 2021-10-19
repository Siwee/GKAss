package com.example.StepDefinitions;

import com.example.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.testng.annotations.Test;

@Test
public class HomePageSteps extends BaseClass {


    String projectPath=System.getProperty("user.dir");
    String driverLoc=projectPath+"/src/test/resources/drivers/chromedriver.exe";
    @Before
    public void setup(){
        setDriver(driverLoc);
    }

    @After
    public void teardown(){
        closeDriver();
    }


    @Given("^I navigate to the SWAGLABS URL$")
    public void i_navigate_to_the_swaglabs_url() throws Throwable {
        BaseClass.navigateToHome();
    }

    @When("^I login using accepted user credentials$")
    public void i_login_using_accepted_user_credentials() throws Throwable {
        SwagLabsLoginPage.login();
    }

    @Then("^I am successfully logged in and can see the products page$")
    public void i_am_successfully_logged_in_and_can_see_the_products_page() throws Throwable {
        Assert.assertTrue(SwagLabsLoginPage.getProductPageTitle().contains("PRODUCTS"));
    }

    @Given("^I have logged in and in products page$")
    public void i_have_logged_in_and_in_products_page() throws Throwable {
        BaseClass.navigateToHome();
        SwagLabsLoginPage.login();

    }

    @When("I add items to cart")
    public void i_add_items_to_cart() {
        ProductsPage.addProductsToCart();
    }

    @Then("Items are added to cart")
    public void items_are_added_to_cart() {
        Assert.assertTrue(ProductsPage.getItemsOnCart().contains("2"));
    }

    @Given("^I have login and in products page$")
    public void i_have_login_and_in_products_page() throws Throwable {
        BaseClass.navigateToHome();
        SwagLabsLoginPage.login();
    }
    @And("^I add new items to cart$")
    public void i_add_new_items_to_cart() throws Throwable {
        ProductsPage.addProductsToCart();
    }
    @When("^I place an order$")
    public void i_place_an_order() throws Throwable {
        ProductsPage.navigateToCart();
        CheckOutPage.insertCheckOutInfo();
    }

    @Then("^Order is complete and the complete order information is displayed$")
    public void order_is_complete_and_the_complete_order_information_is_displayed() throws Throwable {
        Assert.assertTrue(CheckOutPage.getCompleteOrderPageTitle().contains("THANK YOU FOR YOUR ORDER"));
    }




}
