package com.johan.tester;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import com.johan.page.HomePage;
import com.johan.page.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    @Test
    public void positiveloginTest() {
        WebDriver driver = WebDriverManager.chromiumdriver().create();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        homePage.validateOnHomePage();
        System.out.println("Page url :" + driver.getCurrentUrl());
        System.out.println("Page Title :" + driver.getTitle());
        driver.quit();
    }
    @Test
    public void negativeloginTest() {
        WebDriver driver = WebDriverManager.chromiumdriver().create();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("invalid");
        loginPage.clickLoginButton();

        homePage.validateOnHomePage();
        driver.quit();
    }
}
