package com.amadeus.amadeus.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashMap;
import java.util.Map;
public class Response {

    public ResponseEntity<Map<String, String>> loginSuccessResponse() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Login successful");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, String>> loginFailureResponse() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Invalid credentials");

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("message", message);
        response.put("data", data);

        return new ResponseEntity<>(response, status);
    }
}

