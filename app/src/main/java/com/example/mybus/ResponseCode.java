package com.example.mybus;

public class ResponseCode {
    public static final int SIGN_IN_SUCCESS = 200;
    public static final int SIGN_UP_SUCCESS = 200;
    public static final int UPDATE_SUCCESS = 2002;
    public static final int DELETE_SUCCESS = 2003;

    public static final int SIGN_IN_FAILED = 201;
    public static final int SIGN_UP_FAILED = 201;
    public static final int UPDATE_FAILED = 3002;
    public static final int DELETE_FAILED = 3003;

    public static final int EMPTY_RESPONSE = 4000;
    public static final int SERVER_ERROR = 4001;
    public static final int REQUEST_FAILED = 201;
    public static final int JSON_SERIALIZATION = 4003;
    public static final int EXIT_SUCCESS = 4004;
    public static final int UNCHANGED_INFORMATION = 4005;
}