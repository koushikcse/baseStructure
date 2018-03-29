package com.basestructure.network.ServerResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainServerResponse implements Serializable {
    @JsonProperty("code")
    private int code;
    @JsonProperty("message")
    private String message="";
    @JsonProperty("signal")
    private String signal="";

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getSignal() {
        return signal;
    }
}
