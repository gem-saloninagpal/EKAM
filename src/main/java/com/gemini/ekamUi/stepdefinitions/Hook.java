package com.gemini.ekamUi.stepdefinitions;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.Before;


public class Hook {
    @Before
    public static void hook() throws GemException {
        DriverManager.setUpBrowser();
    }

//    @After
//    public static void afterHook() throws GemException {
//        DriverManager.closeDriver();
//    }
}


