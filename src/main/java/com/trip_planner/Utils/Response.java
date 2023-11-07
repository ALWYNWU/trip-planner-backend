package com.trip_planner.Utils;

import java.util.HashMap;
import java.util.Objects;

public class Response extends HashMap<String, Object> {

    public Response() {
        put(Constant.CODE, 200);
        put(Constant.MESSAGE, "success");
    }
    public Response setData(Objects data){
        put(Constant.DATA, data);
        return this;
    }

    public static Response ok() {
        return new Response();
    }

    public static Response ok(String msg){
        Response r = new Response();
        r.put(Constant.MESSAGE, msg);
        return r;
    }

    public Response put(String key, Object value){
        super.put(key, value);
        return this;
    }

    public static Response error(int code, String msg) {
        Response r = new Response();
        r.put(Constant.CODE, code);
        r.put(Constant.MESSAGE, msg);
        return r;
    }

    public Integer getCode(){
        return (Integer) this.get("code");
    }

}
