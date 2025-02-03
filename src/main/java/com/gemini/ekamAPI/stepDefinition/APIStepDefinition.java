package com.gemini.ekamAPI.stepDefinition;

import com.gemini.ekamAPI.utils.CommonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class APIStepDefinition {
    int statusCode;
   public String auth_token;
   public static String appendedUrl;

    @Given("Set endpoint {string} and Method {string}")
    public void setEndpointAndMethod(String endpoint, String method) {
        statusCode = CommonUtils.HitAPI(endpoint, method,null,null).getStatus();
    }

    @Given("Set endpoint {string} method {string} and SampleName {string}")
    public void setEndpointMethodAndSampleName(String endpoint, String method, String sampleName) {
        System.out.println("helloooooo!!!!!!!!!");
        statusCode = CommonUtils.HitAPI(endpoint, method, null,sampleName).getStatus();
        System.out.print(statusCode);
    }

    @Given("Set endpoint {string} with isin and Method {string}")
    public void setEndpointWithIsinAndMethod(String endpoint, String method) {
        statusCode = CommonUtils.HitAPIAndUpdateIsin(endpoint, method,null,null).getStatus();
    }


    @Given("Set endpoint {string} with subject, method {string} and SampleName {string}")
    public void setEndpointWithSubjectMethodAndMethod(String endpoint, String method, String sampleName) {
        System.out.println("helloooooo!!!!!!!!!");
        statusCode = CommonUtils.appendSubjectOnHitPostApi(endpoint, method,null,sampleName).getStatus();
    }

    @Given("Set endpoint {string} with subject and method {string}")
    public void setEndpointWithSubjectMethodAndMethod(String endpoint, String method) {
        System.out.println("helloooooo!!!!!!!!!");
        statusCode = CommonUtils.appendSubjectOnHitGetApi(endpoint, method,null).getStatus();
    }

    @Given("Set endpoint {string} method {string} and SampleName {string} for login")
    public void setEndpointMethodAndSampleNameForLogin(String endpoint, String method, String sampleName) {
        System.out.println("helloooooo!!!!!!!!!");
        statusCode = CommonUtils.HitLoginAPI(endpoint, method, null,sampleName).getStatus();
    }
//    @Given("Set authenticate {string} method {string} and SampleName {string}")
//    public void setAuthenticateMethodAndSampleName(String endpoint, String method, String sampleName) {
//        statusCode = CommonUtils.HitApiToGetToken(endpoint, method, null,sampleName).getStatus();
//    }

    @Then("Verify Status code {int}")
    public void verifyStatusCodeExpected_status(int expectedStatusCode) {
        CommonUtils.statusValidation(statusCode, expectedStatusCode);
    }

    @And("Append subject in endpoint")
    public static void appendSubjectInEndpoint() {
        appendedUrl= CommonUtils.url + CommonUtils.subject;
    }


    @And("Set endpoint {string} with key {string} from filepath {string}, method {string} and SampleName {string}")
    public void setEndpointWithKeyMethodAndSampleName(String endpoint, String key, String method, String sampleName, String filePath) {
        CommonUtils.appendKeyWithEndpoint(endpoint, method, null, sampleName, key, filePath);
    }

    @And("Append key in endpoint")
    public static void appendKeyInEndpoint() {
        appendedUrl= CommonUtils.url + CommonUtils.value;
    }


}



