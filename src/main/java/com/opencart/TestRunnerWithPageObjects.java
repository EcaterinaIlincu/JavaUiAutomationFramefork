package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host");
        HomePage homepage = new HomePage(driver);

        homepage.navigateToRegisterPageFromHeader();

        RegisterPage registerPage = new RegisterPage(driver);


       String randomEmail = RandomDataManager.generateRandomEmail();
        String password = RandomDataManager.generatePassword();
        System.out.println(randomEmail);
        System.out.println(password);

       registerPage.fillInTheRegisterForm(RandomDataManager.generatedFirstName(),RandomDataManager.generateLastName(), randomEmail, password, true );
        registerPage.clickTheContinueButton();
        Thread.sleep(2000);

        LoginPage loginpage = new LoginPage(driver);

        loginpage.clickTheLogoutButton();
        Thread.sleep(1000);

        loginpage.navigateToLoginPageFromHeader();


        loginpage.fillInTheLoginForm(randomEmail, password);
        Thread.sleep(1000);

        loginpage.clickTheLogoutButton();
        Thread.sleep(1000);



        DriverManager.getInstance().tearDown();

        System.out.println("The execution is over");







    }
}