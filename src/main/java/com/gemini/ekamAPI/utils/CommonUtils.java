package com.gemini.ekamAPI.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

//import com.auth0.jwt.JWT;
//import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gemini.ekamAPI.stepDefinition.APIStepDefinition;
import com.gemini.gemjar.enums.Status;
import com.gemini.gemjar.reporting.GemTestReporter;
import com.gemini.gemjar.utils.api.ApiInvocation;
import com.gemini.gemjar.utils.api.ProjectSampleJson;
import com.gemini.gemjar.utils.api.Request;
import com.gemini.gemjar.utils.api.Response;
import com.gemini.gemjar.utils.app.ProjectConfigData;
import io.github.classgraph.ResourceList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import static com.gemini.ekamAPI.stepDefinition.APIStepDefinition.appendSubjectInEndpoint;
import static com.gemini.ekamAPI.stepDefinition.APIStepDefinition.getFilesWithExtensionMap;
//import static sun.jvm.hotspot.debugger.win32.coff.DebugVC50X86RegisterEnums.Status;

public class CommonUtils {
    public static String url;
    public static String subject;
    public static String tokenForAuth;
    public static String value;

    static String _newBondIsin;

    public static Response appendSubjectOnHitGetApi(String UrlNameFromConfig, String method, String step) {
        Response response = new Response();
        try {
            Request request = new Request();
            url = ProjectConfigData.getProperty(UrlNameFromConfig);
            request.setBaseUrl("https://bondui.geminisolutions.com/#/");
            appendSubjectInEndpoint();
            if (!APIStepDefinition.appendedUrl.equals(url)) {
                GemTestReporter.addTestStep("Url of the test case", APIStepDefinition.appendedUrl, Status.INFO);
                request.setURL(APIStepDefinition.appendedUrl);
            } else {
                GemTestReporter.addTestStep("Url of the test case", url, Status.INFO);
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
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
            if ((response.getResponseBody()) != null) {
                GemTestReporter.addTestStep("Response Body", response.getResponseBody(), Status.INFO);
            } else {
                GemTestReporter.addTestStep("Response Body", "No-Response", Status.INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep(method.toUpperCase() + " Request Verification ", method.toUpperCase() + " Request Did not Executed Successfully", Status.FAIL);
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
        }
        return response;
    }

    public static Response appendSubjectOnHitPostApi(String UrlNameFromConfig, String method, String step, String sampleName) {
        Response response = new Response();
        try {
            String filePath = "src/main/resources/" + sampleName + ".json";
            Request request = new Request();
            url = ProjectConfigData.getProperty(UrlNameFromConfig);
            request.setBaseUrl("https://bondui.geminisolutions.com/#/");
            appendSubjectInEndpoint();
            if (!APIStepDefinition.appendedUrl.equals(url)) {
                GemTestReporter.addTestStep("Url of the test case", APIStepDefinition.appendedUrl, Status.INFO);
                request.setURL(APIStepDefinition.appendedUrl);
            } else {
                GemTestReporter.addTestStep("Url of the test case", url, Status.INFO);
                request.setURL(url);
            }
            request.setHeader("Authorization", "Bearer " + tokenForAuth);
            request.setMethod(method);
            if (sampleName.contains("bondInfo")) {
                setNewString(filePath); //here we are just updating bond isin
            }
            if (step != null) {
                request.setStep(step);
            }
            if (sampleName != null) {
                String payload = ProjectSampleJson.getSampleDataString(sampleName);
                request.setRequestPayload(payload);
            }
            response = ApiInvocation.handleRequest(request);
//            token =response.getJsonObject().get("jwttoken").toString();
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
            if ((response.getResponseBody()) != null) {
                GemTestReporter.addTestStep("Response Body", response.getResponseBody(), Status.INFO);
            } else {
                GemTestReporter.addTestStep("Response Body", "No-Response", Status.INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep(method.toUpperCase() + " Request Verification ", method.toUpperCase() + " Request Did not Executed Successfully", Status.FAIL);
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
        }
        return response;
    }

    public static Response HitAPI(String UrlNameFromConfig, String method, String step, String sampleName) {
        Response response = new Response();
        try {
            Request request = new Request();
            url = ProjectConfigData.getProperty(UrlNameFromConfig);
            request.setBaseUrl("https://bondui.geminisolutions.com/#/");
            GemTestReporter.addTestStep("Url of the test case", url, Status.INFO);
            request.setURL(url);
            request.setHeader("Authorization", "Bearer " + tokenForAuth);
            request.setMethod(method);
            if (step != null) {
                request.setStep(step);
            }
            if (sampleName != null) {
                Map<String, ResourceList> list=getFilesWithExtensionMap("json");
                String dynamicFilePath=list.get(sampleName).toString();
              //  String payload = ProjectSampleJson.getSampleDataString();
                String payload = ProjectSampleJson.getSampleDataString(dynamicFilePath);
                request.setRequestPayload(payload);
                if(sampleName.contains("create")){
                    String filePath = "src/main/resources/" + sampleName + ".json";
                    setNewString(filePath);
                }
            }
            response = ApiInvocation.handleRequest(request);
//            token =response.getJsonObject().get("jwttoken").toString();
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
            if ((response.getResponseBody()) != null) {
                GemTestReporter.addTestStep("Response Body", response.getResponseBody(), Status.INFO);
            } else {
                GemTestReporter.addTestStep("Response Body", "No-Response", Status.INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep(method.toUpperCase() + " Request Verification ", method.toUpperCase() + " Request Did not Executed Successfully", Status.FAIL);
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
        }
        return response;
    }

    public static Response HitAPIAndUpdateIsin(String UrlNameFromConfig, String method, String step, String sampleName) {
        Response response = new Response();
        try {
//            String filePath = "src/main/resources/" + sampleName + ".json";
            Request request = new Request();
            url = ProjectConfigData.getProperty(UrlNameFromConfig);
            url += _newBondIsin;
            request.setBaseUrl("https://bondui.geminisolutions.com/#/");
            GemTestReporter.addTestStep("Url of the test case", url, Status.INFO);
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
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
            if ((response.getResponseBody()) != null) {
                GemTestReporter.addTestStep("Response Body", response.getResponseBody(), Status.INFO);
            } else {
                GemTestReporter.addTestStep("Response Body", "No-Response", Status.INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep(method.toUpperCase() + " Request Verification ", method.toUpperCase() + " Request Did not Executed Successfully", Status.FAIL);
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
        }
        return response;
    }


    public static void statusValidation(int actual, int expected) {
        Status STATUS = actual == expected ? Status.PASS : Status.FAIL;
        GemTestReporter.addTestStep("Status Validation", "Expected: " + expected
                + " Actual: " + actual, STATUS);
    }

    public static Response HitLoginAPI(String UrlNameFromConfig, String method, String step, String sampleName) {
        Response response = new Response();
        try {
            Request request = new Request();
            String url = ProjectConfigData.getProperty(UrlNameFromConfig);
            GemTestReporter.addTestStep("Url of the test case", url, Status.INFO);
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
            if (url.contains("login"))
                tokenForAuth = response.getResponseBodyJson().getAsJsonObject().get("access_token").getAsString();
            subject = jwtToken(tokenForAuth);
            System.out.println(subject);
            setUserId();
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
            if ((response.getResponseBody()) != null) {
                GemTestReporter.addTestStep("Response Body", response.getResponseBody(), Status.INFO);
            } else {
                GemTestReporter.addTestStep("Response Body", "No-Response", Status.INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep(method.toUpperCase() + " Request Verification ", method.toUpperCase() + " Request Did not Executed Successfully", Status.FAIL);
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
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
        return (decodedJWT.getSubject());
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

    public static Response appendKeyWithEndpoint(String UrlNameFromConfig, String sampleName, String step, String method, String key, String filePath) {
        Response response = new Response();
        try {
            Request request = new Request();
            url = ProjectConfigData.getProperty(UrlNameFromConfig);
            request.setBaseUrl("https://bondui.geminisolutions.com/#/");
            appendKeyInEndpoint(key, filePath);
            if (!APIStepDefinition.appendedUrl.equals(url)) {
                GemTestReporter.addTestStep("Url of the test case", APIStepDefinition.appendedUrl, Status.INFO);
                request.setURL(APIStepDefinition.appendedUrl);
            } else {
                GemTestReporter.addTestStep("Url of the test case", url, Status.INFO);
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
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
            if ((response.getResponseBody()) != null) {
                GemTestReporter.addTestStep("Response Body", response.getResponseBody(), Status.INFO);
            } else {
                GemTestReporter.addTestStep("Response Body", "No-Response", Status.INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            GemTestReporter.addTestStep(method.toUpperCase() + " Request Verification ", method.toUpperCase() + " Request Did not Executed Successfully", Status.FAIL);
            GemTestReporter.addTestStep("Response Message", response.getResponseMessage(), Status.INFO);
        }
        return response;
    }

    private static void appendKeyInEndpoint(String key, String filePath) {
        try {
            filePath = "src/main/resources/" + filePath + ".json";
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Step 2: Parse the JSON and fetch the required value
            JSONObject jsonObject = new JSONObject(content);
            value = jsonObject.getString(key);  // Replace 'yourKey' with the actual key name
            System.out.println(value);
            APIStepDefinition.appendKeyInEndpoint();

        } catch (Exception e) {
            GemTestReporter.addTestStep("Append key in endpoint", "Exception encountered- " + e, Status.ERR);
        }
    }

    public static void setNewString(String filePath) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(jsonContent);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, false);

            // Parse JSON into a LinkedHashMap to preserve key order
            Map<String, Object> jsonMap = mapper.readValue(jsonContent, LinkedHashMap.class);


            // Generate a single unique value for all "bondIsin" keys
            if(!filePath.contains("bondInfo")) {
                _newBondIsin = generateISIN();
            }

            // Recursively update all "bondIsin" keys with the same value
            updateBondIsin(jsonObject, _newBondIsin);

            // Write the updated JSON back to the file
            mapper.writerWithDefaultPrettyPrinter().writeValue(Paths.get(filePath).toFile(), jsonObject.toMap());
            System.out.println("Updated JSON file successfully!");

        } catch (Exception e) {
            GemTestReporter.addTestStep("Set new value for the key of- " + filePath, "Exception encountered- " + e, Status.ERR);
        }
    }

    public static String generateISIN() {
        StringBuilder isin = new StringBuilder("IN"); // Start with "IN"

        Random random = new Random();

        // Generate 9 alphanumeric characters
        for (int i = 0; i < 9; i++) {
            if (random.nextBoolean()) {
                // Random letter (A-Z)
                char randomChar = (char) ('A' + random.nextInt(26));
                isin.append(randomChar);
            } else {
                // Random digit (0-9)
                isin.append(random.nextInt(10));
            }
        }

        // Generate a random digit for the last character
        isin.append(random.nextInt(10));

        return isin.toString();
    }

    private static void updateBondIsin(Object obj, String newBondIsin) {
        if (obj instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) obj;

            // Iterate over keys in the object
            jsonObject.keys().forEachRemaining(key -> {
                if (key.equals("bondIsin")) {
                    // Update the value of "bondIsin" to the provided value
                    jsonObject.put(key, newBondIsin);
                } else {
                    // Recursively process nested objects or arrays
                    updateBondIsin(jsonObject.get(key), newBondIsin);
                }
            });
        } else if (obj instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) obj;

            // Iterate over elements in the array
            for (int i = 0; i < jsonArray.length(); i++) {
                updateBondIsin(jsonArray.get(i), newBondIsin);
            }
        }
    }


}
