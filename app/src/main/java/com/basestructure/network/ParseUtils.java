package com.basestructure.network;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by innofied on 15/5/17.
 */

public class ParseUtils {

    static String getResponseAsString(Response response) throws IOException {
        return getResponseAsString(response.body());
    }

    static String getResponseAsString(ResponseBody responseBody) throws IOException {
        StringBuilder responseBuilder = new StringBuilder();
        char[] charBuffer = new char[100];
        Reader reader = responseBody.charStream();
        BufferedReader bufferedReader = new BufferedReader(reader);
        int read;
        while ((read = bufferedReader.read(charBuffer)) != -1) {
            responseBuilder.append(charBuffer, 0, read);
        }
        return responseBuilder.toString().trim();
    }

    static String getValueFromJson(String jsonStr)
            throws IllegalStateException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readValue(jsonStr, JsonNode.class);
            return jsonNode.get("is_logged").asText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
