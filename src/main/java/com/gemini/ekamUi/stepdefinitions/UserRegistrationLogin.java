package com.gemini.ekamUi.stepdefinitions;

import com.gemini.ekamUi.locators.BondLocators;
import com.gemini.ekamUi.locators.LoginLocators;
import com.gemini.gemjar.enums.Status;
import com.gemini.gemjar.reporting.GemTestReporter;
import com.gemini.gemjar.utils.ui.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.gemini.ekamUi.stepdefinitions.CommonFunctions.changeResolution;

public class UserRegistrationLogin {

    static String _watchlistedBond;
    @Then("^Validate error messages on email and password \"([^\"]*)\", \"([^\"]*)\"$")
    public void validateErrorMessages(String expectedEmailValidation, String expectedPasswordValidation){
        try{
            List<WebElement> errors= DriverAction.getElements(LoginLocators.messages);
                String emailMessage=errors.get(0).getText();
                String passwordMessage=errors.get(1).getText();
                if(emailMessage.equals(expectedEmailValidation)&&passwordMessage.equals(expectedPasswordValidation)){
                    GemTestReporter.addTestStep("Validate error messages on email and password","Successfully validated the messages", Status.PASS,DriverAction.takeSnapShot());
                }else{
                    GemTestReporter.addTestStep("Validate error messages on email and password","Could not validate the messages", Status.FAIL,DriverAction.takeSnapShot());
                }

        }catch(Exception e){
            GemTestReporter.addTestStep("Validate error message on email and password","Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @When("Click the button {string}")
    public void clickTheButton(String button) {
        try{
            changeResolution();
            if(DriverAction.isDisplayed(By.xpath(LoginLocators.button.replace("input",button)))) {
                DriverAction.click(By.xpath(LoginLocators.button.replace("input", button)));
            }else if(DriverAction.isDisplayed(By.xpath(LoginLocators.button1.replace("input",button)))){
                DriverAction.click(By.xpath(LoginLocators.button1.replace("input", button)));
            }else if(DriverAction.isDisplayed(By.xpath(LoginLocators.button2.replace("input",button)))){
                DriverAction.click(By.xpath(LoginLocators.button2.replace("input", button)));
            }else{
                System.out.println("Button not found!");
            }
            DriverAction.waitSec(4);
        }catch(Exception e){
            GemTestReporter.addTestStep("Click the button- "+button,"Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @Then("Validate credentials box appears")
    public void validateCredentialsBoxAppears() {
        try{
            if(DriverAction.isDisplayed(LoginLocators.enterCredentials)){
                GemTestReporter.addTestStep("Validate credentials box appears","Successfully validated the credentials box.",Status.PASS,DriverAction.takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Validate credentials box appears","Could not validate the credentials box.",Status.FAIL,DriverAction.takeSnapShot());
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Validate credentials box appears","Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("^Click the login button$")
    public void clickTheLoginButton() {
        try{
            DriverAction.click(LoginLocators.loginBtn,"Click the login button");
        }catch(Exception e){
            GemTestReporter.addTestStep("Click the login button","Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("^Enter email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterEmailAndPassword(String email, String password) {
        try{
            DriverAction.typeText(LoginLocators.emailField,email);
            DriverAction.typeText(LoginLocators.passwordField,password);
        }catch(Exception e){
            GemTestReporter.addTestStep("Enter email and password","Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @Then("^Validate user logs in on entering valid email and password$")
    public void validateUserLogsInOnEnteringValidEmailAndPassword() {
        try{
            if(DriverAction.isDisplayed(LoginLocators.bondsHeading)) {
                GemTestReporter.addTestStep("Validate user logs in on entering valid email and password", "User successfully logged in.", Status.PASS, DriverAction.takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Validate user logs in on entering valid email and password", "User successfully logged in.", Status.FAIL, DriverAction.takeSnapShot());
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Validate user logs in on entering valid email and password","Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("^Click the Profile icon$")
    public void clickTheProfileIcon() {
        try{
            DriverAction.click(LoginLocators.userProfile,"Click the profile icon");
        }catch(Exception e){
            GemTestReporter.addTestStep("Click the profile icon","Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @Then("^Validate user logs out of the portal$")
    public void validateUserLogsOutOfThePortal() {
        try{
            DriverAction.waitSec(5);
            if(DriverAction.isDisplayed(LoginLocators.loginBtn1)) {
                GemTestReporter.addTestStep("Validate user logs out of the portal", "User successfully logged out.", Status.PASS, DriverAction.takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Validate user logs out of the portal", "User successfully logged out.", Status.FAIL, DriverAction.takeSnapShot());
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Validate user logs out of the portal","Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @Then("^Verify confirmation dialog$")
    public void verifyConfirmationDialog() {
        try{
            if(DriverAction.isDisplayed(LoginLocators.logoutConfirmationModal)){
                GemTestReporter.addTestStep("Verify confirmation dialog","Successfully verified confirmation modal.",Status.PASS,DriverAction.takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Verify confirmation dialog","Could not verify confirmation modal.",Status.FAIL,DriverAction.takeSnapShot());
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Verify confirmation dialog","Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("Select the option {string}")
    public void selectTheOption(String option) {
        try{
            DriverAction.click(By.xpath(LoginLocators.option.replace("input",option)),"Select the option- "+option);
        }catch(Exception e){
            GemTestReporter.addTestStep("Select the option- "+option,"Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("^Click the logout button in confirmation dialog$")
    public void clickTheLogoutButtonInConfirmationDialog() {
        try{
            DriverAction.waitUntilElementClickable(LoginLocators.logoutButton,3);
            DriverAction.click(LoginLocators.logoutButton,"Click the logout button in confirmation dialog");
        }catch(Exception e){
            GemTestReporter.addTestStep("Click the logout button in confirmation dialog","Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("^View bond details$")
    public void viewBondDetails() {
        try{
            DriverAction.click(LoginLocators.viewBondDetails,"View bond details.");
        }catch(Exception e){
           GemTestReporter.addTestStep("View bond details","Exception encountered- "+e, Status.ERR);
        }
    }

    @Then("^Validate the state of invest now according to allotment and maturity$")
    public void validateStateOfInvestNow() {
        try{
            boolean isActivated=false;
            boolean StatusFetched=false;
            LocalDate currentDate = LocalDate.now();

            // Define the input date ("14 Dec, 2024") and specify the format
            String allotmentDate = DriverAction.getElementText(LoginLocators.allotmentDate);
            String maturityDate = DriverAction.getElementText(LoginLocators.maturityDate);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM, yyyy");
            LocalDate getAllotmentDate = LocalDate.parse(allotmentDate, formatter);
            LocalDate getMaturityDate = LocalDate.parse(maturityDate, formatter);

            // Compare the dates
            if ((getAllotmentDate.isEqual(currentDate)||getAllotmentDate.isBefore(currentDate))&&((getMaturityDate.isEqual(currentDate)||getMaturityDate.isAfter(currentDate)))) {
                isActivated=true;
            }
            String Status= DriverAction.getAttributeName(LoginLocators.buttonStatus,"disabled title");
            if(Status == null){
                StatusFetched=true;
            }
            if(StatusFetched==isActivated){
               GemTestReporter.addTestStep("Validate Status of invest now","Status of invest now is verified.", com.gemini.gemjar.enums.Status.PASS,DriverAction.takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Validate Status of invest now","Status of invest now is not verified.",com.gemini.gemjar.enums.Status.PASS,DriverAction.takeSnapShot());
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Validate Status of invest now","Exception encountered- "+e,Status.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("^Click the watchlist icon$")
    public void clickTheBookmarkIcon() {
        try{
                DriverAction.waitUntilElementClickable(BondLocators.watchlistIcon,10);
                changeResolution();
         //   _watchlistedBond=DriverAction.getElementText(BondLocators.watchlistedBondName);
                DriverAction.click(BondLocators.watchlistIcon, "Click the watchlist icon");

        }catch(Exception e){
            GemTestReporter.addTestStep("Click the watchlist icon","Exception encountered- "+e, Status.ERR,DriverAction.takeSnapShot());
        }
    }
}
