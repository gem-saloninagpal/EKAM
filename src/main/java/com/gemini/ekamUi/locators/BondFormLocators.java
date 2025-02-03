package com.gemini.ekamUi.locators;

import org.openqa.selenium.By;

public class BondFormLocators {
    public static By saveAndDraft= By.xpath("//button[text()='Save & Draft']");
    public static By inputFields=By.xpath("//input[contains(@class,'input-field ')]");
    public static By issuerName=By.xpath("//input[@placeholder='Issuer Name']");
    public static By bondIsin=By.xpath("//input[@placeholder='Bond ISIN']");
    public static By getBondName=By.xpath("//td[@class='bondNameColumn']//span");

    public static By getBondIsin=By.xpath("//table//td[2]");
    public static String inputFieldsByName="//label[contains(text(),'input')]";
    public static String dropdownFieldsByName="//div[contains(@label,'input')][contains(@class,'p-dropdown')]";
    public static String calendarFieldsByName="//label[text()='input']//preceding::span[contains(@class,'p-calendar')][1]";
    public static By currentDate=By.xpath("//td[@class=\"p-datepicker-today\"]");
    public static By unlistedRadioBtn=By.xpath("//label[text()='Unlisted']//parent::div");
    public static By yearTenure=By.xpath("//input[@name='years']");

    public static By couponRate=By.xpath("//input[@name='couponRate']");
}
