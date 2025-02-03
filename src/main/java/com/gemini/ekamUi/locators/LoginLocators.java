package com.gemini.ekamUi.locators;

import org.openqa.selenium.By;

public class LoginLocators {
    public static By messages=By.xpath("//div[contains(@class,'error')]");
    public static String button="//div[contains(@class,'input')]";
    public static By enterCredentials=By.xpath("//div[contains(text(),'Enter your login credentials')]");
    public static By loginBtn=By.xpath("//button[@type='submit']");
    public static By loginBtn1=By.xpath("//button[@class='login-button']");
    public static By emailField=By.xpath("//input[@name='email']");
    public static By passwordField=By.xpath("//input[@name='password']");
    public static By bondsHeading=By.xpath("//h2[contains(@class,'Explore')]");
    public static By userProfile=By.xpath("//div[@class=\"userProfile\"]");
    public static By logoutConfirmationModal=By.xpath("//div[contains(@class,'logoutConfirmationModalFooter')]");
    public static String option="//p[text()='input']//parent::section";
    public static By logoutButton=By.xpath("//div[@class='btnContainer']//button[2]");
    public static By viewBondDetails=By.xpath("(//div[contains(@class,'BondCard_bondCard')]//div[contains(@class,'companyName')])[1]");
    public static By allotmentDate=By.xpath("(//span[text()='Allotment Date']//following::span)[1]");
    public static By maturityDate=By.xpath("(//header[text()='Maturity Date']//following::p)[1]");
    public static By buttonStatus=By.xpath("//button[contains(@class,'CalculateInvestment')]");
    public static String button1="//button[text()='input']";
    public static String button2="//div[text()='input']";
}
