package com.gemini.ekamAPI.stepDefinition;

import com.gemini.ekamAPI.utils.CommonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ResourceList;
import io.github.classgraph.ScanResult;

import java.util.Map;

public class APIStepDefinition {
    int statusCode;
   public String auth_token;
   public static String appendedUrl;

    @Given("^Set endpoint \"([^\"]*)\" and Method \"([^\"]*)\"$")
    public void setEndpointAndMethod(String endpoint, String method) {
        statusCode = CommonUtils.HitAPI(endpoint, method,null,null).getStatus();
    }

    @Given("^Set endpoint \"([^\"]*)\" method \"([^\"]*)\" and SampleName \"([^\"]*)\"$")
    public void setEndpointMethodAndSampleName(String endpoint, String method, String sampleName) {
        System.out.println("helloooooo!!!!!!!!!");
        statusCode = CommonUtils.HitAPI(endpoint, method, null,sampleName).getStatus();
        System.out.print(statusCode);
    }

    @Given("^Set endpoint \"([^\"]*)\" with isin and Method \"([^\"]*)\"$")
    public void setEndpointWithIsinAndMethod(String endpoint, String method) {
        statusCode = CommonUtils.HitAPIAndUpdateIsin(endpoint, method,null,null).getStatus();
    }


    @Given("^Set endpoint \"([^\"]*)\" with subject, method \"([^\"]*)\" and SampleName \"([^\"]*)\"$")
    public void setEndpointWithSubjectMethodAndMethod(String endpoint, String method, String sampleName) {
        System.out.println("helloooooo!!!!!!!!!");
        statusCode = CommonUtils.appendSubjectOnHitPostApi(endpoint, method,null,sampleName).getStatus();
    }

    @Given("^Set endpoint \"([^\"]*)\" with subject and method \"([^\"]*)\"$")
    public void setEndpointWithSubjectMethodAndMethod(String endpoint, String method) {
        System.out.println("helloooooo!!!!!!!!!");
        statusCode = CommonUtils.appendSubjectOnHitGetApi(endpoint, method,null).getStatus();
    }

    @Given("^Set endpoint \"([^\"]*)\" method \"([^\"]*)\" and SampleName \"([^\"]*)\" for login$")
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

    @And("^Append subject in endpoint$")
    public static void appendSubjectInEndpoint() {
        appendedUrl= CommonUtils.url + CommonUtils.subject;
    }


    @And("^Set endpoint \"([^\"]*)\" with key \"([^\"]*)\" from filepath \"([^\"]*)\", method \"([^\"]*)\" and SampleName \"([^\"]*)\"$")
    public void setEndpointWithKeyMethodAndSampleName(String endpoint, String key, String method, String sampleName, String filePath) {
        CommonUtils.appendKeyWithEndpoint(endpoint, method, null, sampleName, key, filePath);
    }

    @And("^Append key in endpoint$")
    public static void appendKeyInEndpoint() {
        appendedUrl= CommonUtils.url + CommonUtils.value;
    }

    public static Map<String, ResourceList> getFilesWithExtensionMap(String extension) {
        ClassGraph jarcg = new ClassGraph();
        ScanResult sr = jarcg.disableModuleScanning().scan(5);
        ResourceList rl = sr.getResourcesWithExtension(extension);
        return rl.asMap();
    }


}



