package com.gemini.ekamAPI.stepDefinition;

import com.gemini.gemjar.exception.GemException;
import com.gemini.gemjar.utils.ui.DriverManager;
import io.cucumber.java.Before;


public class Hook {
    @Before
    public static void hook() throws GemException {
        DriverManager.setUpBrowser();
    }

}


