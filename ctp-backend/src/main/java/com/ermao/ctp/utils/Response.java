package com.ermao.ctp.utils;


import lombok.Data;

import java.io.Serializable;

/**
 * @author Ermao
 * Date: 2022/12/7 11:57
 */
@Data
public class Response implements Serializable {
    private static final long serialVersionUID = -3760445487636086034L;
    private static final String EMPTY_JSON = "{}";
    private static final Integer OK_CODE = 200;
    private static final Integer FAIL_CODE = 400;

    private Integer code;

    private String message;

    private Object data;


    public static Response ok() {
        Response response = new Response();
        response.setCode(OK_CODE);
        response.setMessage("OK");
        response.setData(EMPTY_JSON);
        return response;
    }

    public static Response ok(Object data) {
        Response response = new Response();
        response.setCode(OK_CODE);
        response.setMessage("OK");
        response.setData(data);
        return response;
    }

    public static Response fail() {
        Response response = new Response();
        response.setCode(FAIL_CODE);
        response.setMessage("ERROR");
        response.setData(EMPTY_JSON);
        return response;
    }

    public static Response ok(String message) {
        Response response = new Response();
        response.setCode(OK_CODE);
        response.setMessage(message);
        response.setData(EMPTY_JSON);
        return response;
    }
}
