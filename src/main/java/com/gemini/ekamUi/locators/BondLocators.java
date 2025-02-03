package com.gemini.ekamUi.locators;

import org.openqa.selenium.By;

public class BondLocators {
    public static By watchlistIcon=By.xpath("(//div[contains(@id,'watchlist')])[1]/parent::div");
    public static By watchlistedBondName=By.xpath("(//div[@data-pr-tooltip=\"Add to Watchlist\"])[1]/preceding::div[contains(@class,'companyName')][position()=1]");
    public static By watchlistedBond=By.xpath("(//div[contains(@class,'WatchListCard_companyName')])[1]");
    public static By searchbar=By.xpath("//input[@type='text']");
    public static By filteredBonds=By.xpath("//div[contains(@class,'BondCard_companyName')]");
    public static String bondFilterDropdown="//span[text()='input']//parent::a//parent::div";
    public static String filterOption="//label[contains(text(),'input')]/preceding::div[1]";
    public static By getRating=By.xpath("//div[text()='Rating']//following::div[1]");
    public static By searchBond=By.xpath("//input[@placeholder='Search bond']");
}
