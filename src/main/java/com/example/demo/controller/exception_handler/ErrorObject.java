package com.example.demo.controller.exception_handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorObject {
    public ErrorObject(String errorTitle, List<String> errorDetails) {
        this(errorTitle, null, errorDetails);
    }
    public ErrorObject(String errorTitle, String errorDetail) {
        this(errorTitle, errorDetail, null);
    }
    private String errorTitle;
    private String errorDetail;
    private List<String> errorDetails;
}
