package com.endlesscreation.spring.dtos;

public class SimpleResponse {
    public static SimpleResponse SUCCESS =new SimpleResponse(true, "Success");
    public static SimpleResponse FAIL =new SimpleResponse(false, "Fail");
    public static SimpleResponse NOTHING =new SimpleResponse(false, "changed");

    private final boolean success;
    private final String message;

    public SimpleResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
