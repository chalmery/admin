package io.github.common.utils;

import com.google.gson.Gson;

public class JsonUtils {


    public static String toJSONString(Object obj) {
        return new Gson().toJson(obj);
    }


}
