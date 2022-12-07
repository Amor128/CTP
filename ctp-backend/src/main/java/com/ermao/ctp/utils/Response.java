package com.ermao.ctp.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ermao
 * Date: 2022/12/7 11:57
 */
@Data
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -3760445487636086034L;

    private Integer code;

    private String message;

    private T data;

    public static Response<Object> ok() {
        Response<Object> response = new Response<>();
        response.setCode(200);
        response.setMessage("OK");
        response.setData("{}");
        return response;
    }

    public static Response<Object> fail() {
        Response<Object> response = new Response<>();
        response.setCode(400);
        response.setMessage("ERROR");
        response.setData("{}");
        return response;
    }
}
