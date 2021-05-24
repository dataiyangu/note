package com.leesin.json.test;

import com.alibaba.fastjson.JSONObject;

public class Test {
    public static void main(String[] args) {
        String json = "{\n" +
            "\"name\" : \"haha\"\n" +
            "}";
        // string - > object object多出的字段为默认值
        App app = JSONObject.parseObject(json, App.class);
        System.out.println(app);

        String json2 = "{\n" +
            "\"name\" : \"haha\",\n" +
            "\"age\" : 2,\n" +
            "\"sex\" : \"男\"\n" +
            "}";
        // string - > object String多出的字段自动忽略
        App app1 = JSONObject.parseObject(json2, App.class);
        System.out.println(app1);

        String json3 = "{\n" +
            "        \"skuBarcode\": \"400136953\",\n" +
            "        \"carryCode\": \"CA-01-01-033\"\n" +
            "    }";
        ReviewLaunchReq app2 = JSONObject.parseObject(json3, ReviewLaunchReq.class);
        System.out.println(app2);

        String json4 = "{\n" +
            "    \"bizType\": 7,\n" +
            "    \"bizObjJson\": {\n" +
            "        \"skuBarcode\": \"400136953\",\n" +
            "        \"carryCode\": \"CA-01-01-033\"\n" +
            "    }\n" +
            "}";
        BizDto app3 = JSONObject.parseObject(json4, BizDto.class);
        System.out.println(app3);
    }
}
