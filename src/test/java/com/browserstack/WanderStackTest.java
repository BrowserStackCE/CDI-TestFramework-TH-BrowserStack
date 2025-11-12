package com.browserstack;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class WanderStackTest extends SeleniumTest {

    private final int defaultTimeoutInSeconds = 5;

    @Test
    public void completeBookingFlow() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeoutInSeconds));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://wanderstack.vercel.app//");
        driver.manage().window().maximize();
        Assert.assertTrue(driver.getTitle().contains("Travel and Hospitality Website"));

        // Step 1: Sign In
        WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign In')]")));
        js.executeScript("arguments[0].scrollIntoView({block:'center'})", signInBtn);
        signInBtn.click();

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#signin-email")));
        js.executeScript("arguments[0].scrollIntoView({block:'center'})", emailField);
        emailField.sendKeys("sample1@browserstack.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#signin-password")));
        js.executeScript("arguments[0].scrollIntoView({block:'center'})", passwordField);
        passwordField.sendKeys("browserstack@123");

        WebElement signInSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign In')]")));
        js.executeScript("arguments[0].scrollIntoView({block:'center'})", signInSubmit);
        signInSubmit.click();

        // Step 2: Navigate Home
        WebElement homeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Home')]")));
        js.executeScript("arguments[0].scrollIntoView({block:'center'})", homeBtn);
        homeBtn.click();


        // Step 4: Flights
        WebElement flightsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Flights')]")));
        flightsTab.click();

        WebElement selectFlight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Select Flight')]")));
        selectFlight.click();

        // Step 5: Passenger Details
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'first name')]")));
        firstName.sendKeys("Demo");
        
        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'last name')]")));
        lastName.sendKeys("Credentials");
        
        WebElement dob = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@type='date']")));
        dob.sendKeys("2002-01-01");
        
        WebElement nationality = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'nationality')]")));
        nationality.sendKeys("Indian");
        
        WebElement passport = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'passport number')]")));
        passport.sendKeys("W300000");
        
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'email')]")));
        email.sendKeys("sample1@browserstack.com");
        
        WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'phone number')]")));
        phone.sendKeys("9999999999");
        
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(., 'Continue')]")));
        continueBtn.click();

        WebElement continueBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(., 'Continue')]")));
        continueBtn.click();
        
        // Step 6: Address + Complete Booking
        WebElement street = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'street address')]")));
        street.sendKeys("Street 1");
        
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'city')]")));
        city.sendKeys("Mumbai");
        
        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'state')]")));
        state.sendKeys("Maharashtra");
        
        WebElement zip = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'ZIP')]")));
        zip.sendKeys("400001");
        
        WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder, 'country')]")));
        country.sendKeys("India");
        
        WebElement completeBookingBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(., 'Complete Booking')]")));
        completeBookingBtn.click();
        
        // Final assertion (optional, adjust as per app behavior)
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("booking"), 
            "Booking not completed successfully");
        
    }
}
