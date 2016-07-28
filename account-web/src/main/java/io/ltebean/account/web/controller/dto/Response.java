package io.ltebean.account.web.controller.dto;

/**
 * Created by leo on 16/6/6.
 */
public class Response {

    public int status = 200;

    public String message = "";

    public Object data;

    public Response(Object data) {
        this.data = data;
    }

    public Response() {
    }

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Response error(String message) {
        Response response = new Response();
        response.status = 500;
        response.message = message;
        return response;
    }

    public static Response badRequest() {
        Response response = new Response();
        response.status = 400;
        return response;
    }
}
