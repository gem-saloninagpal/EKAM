package com.gemini.ekamUi.stepdefinitions;

import com.gemini.ekamUi.locators.BondFormLocators;
import com.gemini.ekamUi.locators.BondLocators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.Random;

public class BondForm {

    String _bondName;
    String _isin;
    @When("^Hover over Save & Draft and verify tooltip$")
    public void verifySaveAndDraftTooltip() {
        try {
             String tooltipText= DriverAction.getAttributeName(BondFormLocators.saveAndDraft,"title");
            if (tooltipText.equals("Please fill out Bond ISIN and Bond Name")) {
                GemTestReporter.addTestStep("Hover over Save & Draft and verify tooltip", "Successfully verified the tooltip", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Hover over Save & Draft and verify tooltip", "Could not verify the tooltip on hovering over Save & Draft.", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Hover over Save & Draft and verify tooltip", "Exception encountered- " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }

    @And("Enter issuer name {string} and isin")
    public void enterIssuerNameAndIsin(String issuerName) {
        try {
            _bondName=issuerName;
            _isin = generateCustomString();
            DriverAction.typeText(BondFormLocators.issuerName, issuerName);
            DriverAction.typeText(BondFormLocators.bondIsin, _isin);
            DriverAction.waitSec(2);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Enter issuer name and isin", "Exception encountered- " + e, STATUS.ERR, DriverAction.takeSnapShot());
        }
    }

    private String generateCustomString() {
        Random random = new Random();
        StringBuilder result = new StringBuilder("IN");

        // Generate 9 random characters (letters and digits)
        for (int i = 0; i < 9; i++) {
            if (random.nextBoolean()) {
                // Append a random uppercase letter
                result.append((char) ('A' + random.nextInt(26)));
            } else {
                // Append a random digit
                result.append(random.nextInt(10));
            }
        }
            result.append(random.nextInt(10));

            return result.toString();
    }

    @Then("^Verify the drafted bond$")
    public void verifyTheDraftedBond() {
        try{
            DriverAction.typeText(BondLocators.searchBond,_bondName);
            String draftedBondName=DriverAction.getElementText(BondFormLocators.getBondName);
        //    String draftedBondIsin=DriverAction.getElementText(BondFormLocators.getBondIsin);
            if(draftedBondName.contains(_bondName)){
                GemTestReporter.addTestStep("Verify the drafted bond","Successfully verified the drafted bond.",STATUS.PASS,DriverAction.takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Verify the drafted bond","Could not verify the drafted bond.",STATUS.FAIL,DriverAction.takeSnapShot());
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Verify the drafted bond","Exception encountered- "+e,STATUS.ERR,DriverAction.takeSnapShot());
        }
    }

    @And("^Enter mandatory details in bond form$")
    public void enterMandatoryDetailsInBondForm() {
        try{
            //handle tenure, COUPON RATE and unlisted separately
            DriverAction.click(BondFormLocators.unlistedRadioBtn);
            DriverAction.typeText(BondFormLocators.yearTenure,"2");
            DriverAction.typeText(BondFormLocators.couponRate,"2");
            String[]fields={"Security","Issue Type","Issue Size","Face Value","Issue Price","Issue Opening","Minimum Investment","Issuance Mode","Payment Frequency","First Coupon Payment Date","Type Of Coupon","Day Count Basis","Purpose Of Issue","Key Investment","Primary Security"};
            for(int i=0;i< fields.length;i++){
                //dropdown
                if(fields[i].equals("Security")||fields[i].equals("Issue Type")||fields[i].equals("Issuance Mode")||fields[i].equals("Payment Frequency")||fields[i].equals("Type Of Coupon")||fields[i].equals("Day Count Basis")){
                    DriverAction.click(By.xpath(BondFormLocators.dropdownFieldsByName.replace("input",fields[i])));
                }
                //price
                else if(fields[i].equals("Issue Size")||fields[i].equals("Face Value")||fields[i].equals("Issue Price")||fields[i].equals("Minimum Investment")){
                    DriverAction.typeText(By.xpath(BondFormLocators.inputFieldsByName.replace("input",fields[i])),"100000");
                }
                //calendar
                else if(fields[i].equals("Issue Opening Date")||fields[i].equals("First Coupon Payment Date")){
                    DriverAction.click(By.xpath(BondFormLocators.calendarFieldsByName.replace("input",fields[i])));
                    DriverAction.click(BondFormLocators.currentDate);
                }
                //text
                else{
                    DriverAction.typeText(By.xpath(BondFormLocators.inputFieldsByName.replace("input",fields[i])),"test");
                }
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("Enter mandatory details in bond form","Exception encountered- "+e,STATUS.ERR);
        }
    }
}
