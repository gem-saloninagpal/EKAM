package com.gemini.athenaAPI.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gemini.athenaAPI.stepDefinition.APIStepDefinition;
import com.gemini.generic.api.utils.ApiInvocation;
import com.gemini.generic.api.utils.ProjectSampleJson;
import com.gemini.generic.api.utils.Request;
import com.gemini.generic.api.utils.Response;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.utils.ProjectConfigData;

import java.io.File;

import static com.gemini.athenaAPI.stepDefinition.APIStepDefinition.appendSubjectInEndpoint;

public class CommonUtils {
    public static String url;
    public static String subject;
    public static String tokenForAuth;
    public static Response appendSubjectOnHitGetApi(String UrlNameFromConfig, String method, String step) {
        Response response = new Response();
        try {
            Request request = new Request();
            url = ProjectConfigData.getProperty(UrlNameFromConfig);
            request.setBaseUrl("https://bondui.geminisolutions.com/#/");
            appendSubjectInEndpoint();
            if(!APIStepDefinition.appendedUrl.equals(url)){
                GemTestReporter.addTestStep("Url of the test case", APIStepDefinition.appendedUrl, STATUS.INFO);
                request.setURL(APIStepDefinition.appendedUrl);
            }else {
                GemTestReporter.addTestStep("Url of the test case", url, STATUS.INFO);
                request.setURL(url);
            }
            request.setHeader("Authorization", "Bearer " + tokenForAuth);
            request.setMethod(method);
            if (step != null) {
                request.setStep(step);
            }
//            if (sampleName != null) {
//                String payload = ProjectSampleJson.getSampleDataString(sampleName);
//                request.setRequestPayload(payload);
//            }
            response = ApiInvocation.handleRequest(request);
//            token =response.getJsonObject().get("jwttoken").toString();
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), STATUS.INFO);
            if ((response.getResponseBody()) != null) {
                GemTestReporter.addTestStep("Response Body", response.getResponseBody(), STATUS.INFO);
            } else {
                GemTestReporter.addTestStep("Response Body", "No-Response", STATUS.INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep(method.toUpperCase() + " Request Verification ", method.toUpperCase() + " Request Did not Executed Successfully", STATUS.FAIL);
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), STATUS.INFO);
        }
        return response;
    }

    public static Response appendSubjectOnHitPostApi(String UrlNameFromConfig, String method, String step, String sampleName) {
        Response response = new Response();
        try {
            Request request = new Request();
            url = ProjectConfigData.getProperty(UrlNameFromConfig);
            request.setBaseUrl("https://bondui.geminisolutions.com/#/");
            appendSubjectInEndpoint();
            if(!APIStepDefinition.appendedUrl.equals(url)){
                GemTestReporter.addTestStep("Url of the test case", APIStepDefinition.appendedUrl, STATUS.INFO);
                request.setURL(APIStepDefinition.appendedUrl);
            }else {
                GemTestReporter.addTestStep("Url of the test case", url, STATUS.INFO);
                request.setURL(url);
            }
            request.setHeader("Authorization", "Bearer " + tokenForAuth);
            request.setMethod(method);
            if (step != null) {
                request.setStep(step);
            }
            if (sampleName != null) {
                String payload = ProjectSampleJson.getSampleDataString(sampleName);
                request.setRequestPayload(payload);
            }
            response = ApiInvocation.handleRequest(request);
//            token =response.getJsonObject().get("jwttoken").toString();
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), STATUS.INFO);
            if ((response.getResponseBody()) != null) {
                GemTestReporter.addTestStep("Response Body", response.getResponseBody(), STATUS.INFO);
            } else {
                GemTestReporter.addTestStep("Response Body", "No-Response", STATUS.INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep(method.toUpperCase() + " Request Verification ", method.toUpperCase() + " Request Did not Executed Successfully", STATUS.FAIL);
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), STATUS.INFO);
        }
        return response;
    }
    public static Response HitAPI(String UrlNameFromConfig, String method, String step, String sampleName) {
        Response response = new Response();
        try {
            Request request = new Request();
            url = ProjectConfigData.getProperty(UrlNameFromConfig);
            request.setBaseUrl("https://bondui.geminisolutions.com/#/");
                GemTestReporter.addTestStep("Url of the test case", url, STATUS.INFO);
                request.setURL(url);
            request.setHeader("Authorization", "Bearer " + tokenForAuth);
            request.setMethod(method);
            if (step != null) {
                request.setStep(step);
            }
            if (sampleName != null) {
                String payload = ProjectSampleJson.getSampleDataString(sampleName);
                request.setRequestPayload(payload);
            }
            response = ApiInvocation.handleRequest(request);
//            token =response.getJsonObject().get("jwttoken").toString();
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), STATUS.INFO);
            if ((response.getResponseBody()) != null) {
                GemTestReporter.addTestStep("Response Body", response.getResponseBody(), STATUS.INFO);
            } else {
                GemTestReporter.addTestStep("Response Body", "No-Response", STATUS.INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep(method.toUpperCase() + " Request Verification ", method.toUpperCase() + " Request Did not Executed Successfully", STATUS.FAIL);
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), STATUS.INFO);
        }
        return response;
    }

    public static void statusValidation(int actual, int expected) {
        STATUS status = actual == expected ? STATUS.PASS : STATUS.FAIL;
        GemTestReporter.addTestStep("Status Validation", "Expected: " + expected
                + " Actual: " + actual, status);
    }

    public static Response HitLoginAPI(String UrlNameFromConfig, String method, String step, String sampleName) {
        Response response = new Response();
        try {
            Request request = new Request();
            String url = ProjectConfigData.getProperty(UrlNameFromConfig);
            GemTestReporter.addTestStep("Url of the test case", url, STATUS.INFO);
            request.setURL(url);
            request.setMethod(method);
            if (step != null) {
                request.setStep(step);
            }
            if (sampleName != null) {
                String payload = ProjectSampleJson.getSampleDataString(sampleName);
                request.setRequestPayload(payload);
            }
            response = ApiInvocation.handleRequest(request);
            if(url.contains("login"))
                tokenForAuth = response.getResponseBodyJson().getAsJsonObject().get("access_token").getAsString();
                subject= jwtToken(tokenForAuth);
               System.out.println(subject);
               setUserId();
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), STATUS.INFO);
            if ((response.getResponseBody()) != null) {
                GemTestReporter.addTestStep("Response Body", response.getResponseBody(), STATUS.INFO);
            } else {
                GemTestReporter.addTestStep("Response Body", "No-Response", STATUS.INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep(method.toUpperCase() + " Request Verification ", method.toUpperCase() + " Request Did not Executed Successfully", STATUS.FAIL);
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), STATUS.INFO);
        }
        return response;
    }

    public static String jwtToken(String tokenForAuth) throws Exception {
        // Replace this with your actual JWT token
        String token = tokenForAuth;

        // Decode the token
        DecodedJWT decodedJWT = JWT.decode(token);

        // Print out the header, payload, and signature
        System.out.println("Subject: " + decodedJWT.getSubject());
        return(decodedJWT.getSubject());
    }

    public static void setUserId() throws Exception {

        // Path to your JSON file
        File jsonFile = new File("src/main/resources/notificationPreferences.json");

        // Read the JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        // Modify the "userId" field with the extracted subject
        if (rootNode.isObject()) {
            ObjectNode objectNode = (ObjectNode) rootNode;
            objectNode.put("userId", subject);
        }

        // Write the modified JSON back to the file (or use it in a request)
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, rootNode);

        // Optional: Print the modified JSON to console
        String updatedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        System.out.println(updatedJson);

        // Now you can use the updated JSON in your HTTP request
    }

}
