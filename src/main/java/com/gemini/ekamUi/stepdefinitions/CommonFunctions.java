package com.gemini.ekamUi.stepdefinitions;

import com.gemini.ekamUi.locators.MyLocators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CommonFunctions {
    @Then("Validate the popup message")
    public void validateThePopupMessage() {
        try{
            String popupMessage= DriverAction.getElementText(MyLocators.popupMessage);
            System.out.println(popupMessage);
            if(popupMessage.equals("Bond added to watchlist")||popupMessage.equals("Bond removed from watchlist")){
                GemTestReporter.addTestStep("Validate the popup message","Successfully validated the popup message", STATUS.PASS,DriverAction.takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Validate the popup message","Could not validate the popup message", STATUS.FAIL,DriverAction.takeSnapShot());
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Validate the popup message","Exception encountered- "+e,STATUS.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("Switch to {string}")
    public void switchTo(String tab) {
        try{
            DriverAction.click(By.xpath(MyLocators.tabSwitch.replace("input",tab)));
        }catch(Exception e){
            GemTestReporter.addTestStep("Switch to "+tab,"Exception encountered- "+e,STATUS.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("^Change resolution$")
    public static void changeResolution() {
        try {
            Robot robot = new Robot();

            for (int i = 0; i < 4; i++) {
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_SUBTRACT);

                robot.keyRelease(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Change resolution", "Exception encountered- " + e, STATUS.ERR);
        }

    }

    @Given("^Navigate to admin portal$")
    public void navigateToAdminPortal() {
        try{
            DriverAction.launchUrl("https://bondui.geminisolutions.com/#/admin");
        }catch(Exception e){

        }
    }
}
