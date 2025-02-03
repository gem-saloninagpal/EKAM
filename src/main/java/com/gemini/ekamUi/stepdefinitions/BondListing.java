package com.gemini.ekamUi.stepdefinitions;

import com.gemini.ekamUi.locators.BondLocators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BondListing {
    String rating;

    @Then("^Validate bookmarked bond under watchlist$")
    public void validateBondUnderWatchlist(){
        try{
            String bond= DriverAction.getElementText(BondLocators.watchlistedBond);
            if(UserRegistrationLogin._watchlistedBond.equals(bond)){
                GemTestReporter.addTestStep("Validate bookmarked bond under watchlist","Successfully validated the bookmarked bond under watchlist", STATUS.PASS,DriverAction.takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Validate bookmarked bond under watchlist","Could not validate the bookmarked bond under watchlist", STATUS.FAIL,DriverAction.takeSnapShot());
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Validate bookmarked bond under watchlist","Exception encountered- "+e, STATUS.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("^Enter text to search \"([^\"]*)\"$")
    public void enterTextToSearch(String bond) {
        try{
            DriverAction.waitUntilElementIsClickable(BondLocators.watchlistIcon);
            DriverAction.typeText(BondLocators.searchbar,bond,"Search a bond- "+bond);
        }catch(Exception e){
            GemTestReporter.addTestStep("Enter text to search- "+bond,"Exception encountered- "+e,STATUS.ERR,DriverAction.takeSnapShot());
        }
    }

    @Then("^Verify records get filtered on the basis of searched bond \"([^\"]*)\"$")
    public void verifyFilteredRecords(String bond) {
        try{
            String upperCaseBond=bond.toUpperCase();
            List<WebElement> bonds=DriverAction.getElements(BondLocators.filteredBonds);
            int c=0;
            for(int i=0;i<bonds.size();i++){
                if(bonds.get(i).getText().contains(upperCaseBond)){
                    c++;
                }
            }
            if(c==bonds.size()){
                GemTestReporter.addTestStep("Verify records get filtered on the basis of searched bond","Successfully verified.",STATUS.PASS,DriverAction.takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Verify records get filtered on the basis of searched bond","Could not verify.",STATUS.FAIL,DriverAction.takeSnapShot());
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Verify records get filtered on the basis of searched bond","Exception encountered- "+e,STATUS.ERR,DriverAction.takeSnapShot());
        }
    }

    @When("Expand {string} dropdown")
    public void expandDropdown(String filter) {
        try{
            DriverAction.waitUntilElementIsClickable(By.xpath(BondLocators.bondFilterDropdown.replace("input",filter)));
            DriverAction.click(By.xpath(BondLocators.bondFilterDropdown.replace("input",filter)));
        }catch(Exception e){
            GemTestReporter.addTestStep("Expand rating dropdown","Exception encountered- "+e,STATUS.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("Select option {string}")
    public void selectOption(String option) {
        try{
            rating=option;
            DriverAction.click(By.xpath(BondLocators.filterOption.replace("input",rating)));
        }catch(Exception e){
            GemTestReporter.addTestStep("Select option- "+rating,"Exception encountered- "+e,STATUS.ERR,DriverAction.takeSnapShot());
        }
    }

    @Then("Validate records on the basis of rating {string}")
    public void validateRecordsOnTheBasisOfRating(String optionSelected) {
        try{
            List<WebElement> bonds=DriverAction.getElements(BondLocators.filteredBonds);
            List<WebElement>ratings=DriverAction.getElements(BondLocators.getRating);
            for(int i=0;i<bonds.size();i++) {
              if(!ratings.get(i).getText().contains(optionSelected)){
                  GemTestReporter.addTestStep("Validate records on the basis of rating","Could not validate records on the basis of rating.",STATUS.FAIL,DriverAction.takeSnapShot());
                  System.exit(0);
              }
            }
            GemTestReporter.addTestStep("Validate records on the basis of rating","Successfully validated the filtered records on the basis of rating.",STATUS.PASS,DriverAction.takeSnapShot());
        }catch(Exception e){
            GemTestReporter.addTestStep("Validate records on the basis of rating","Exception encountered- "+e,STATUS.ERR,DriverAction.takeSnapShot());
        }
    }
}
