package com.lph.rsa.Utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.lph.rsa.domain.Result;
import org.apache.tools.ant.types.Assertions;

import java.util.Map;

/**
 * gson转换工具类
 * @author: lph
 * @date:  2019/10/29 9:15
 * @version V1.0
 */
public class GsonUtil {

    public static void main(String[] args){
        Gson gson = new Gson();
        Result result = new Result(200, "成功", null);
        String json = gson.toJson(result);
        System.out.println("json is " + json);


        Gson buildedGson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        String buildedJson = buildedGson.toJson(result);
        System.out.println("buildedJson is " + buildedJson);

        JsonObject jsonObject = new JsonObject();
//...
        JsonObject nestJsonObject = new JsonObject();
        nestJsonObject.addProperty("username", "one");
        nestJsonObject.addProperty("score", 99);
        jsonObject.add("data", nestJsonObject);
        String toJson2 = buildedGson.toJson(jsonObject);
        System.out.println(toJson2);

        String json1 = "{\"code\":400,\"message\":\"参数错误\"}";
        Result result1 = new Gson().fromJson(json1, Result.class);

        System.err.println(result1.getCode());

        String jsonString = "{'employee.name':'one','employee.salary':10}";
        Gson gson1 = new Gson();
        Map map = gson1.fromJson(jsonString, Map.class);
        System.err.println(map);

    }
}
