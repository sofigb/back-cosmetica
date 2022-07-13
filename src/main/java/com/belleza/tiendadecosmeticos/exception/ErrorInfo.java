package com.belleza.tiendadecosmeticos.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor

public class ErrorInfo {

    @JsonProperty("message")
    private String message;

    @JsonProperty("status_code")
    private int statusCode;

    @JsonProperty("uri")
    private String uriRequested;


    public ErrorInfo(String message, String uriRequested, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.uriRequested = uriRequested;
    }
}
