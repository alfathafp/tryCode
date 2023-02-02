package com.company;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.Test;
import io.restassured.response.Response;
import org.json.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import com.company.models.testdatastage;

import static io.restassured.RestAssured.given;

@Slf4j
public class getJsonServer {

    @Test
    public void getJsonURL() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        try {
        String myUrl = "jdbc:mysql://db-shared-engineering-staging-rw.kredivo.com:3306/?useSSL=false";
        String sqlSelect = "SELECT * FROM seit_automation.testdata_user";


        conn = DriverManager.getConnection(myUrl, "chandan_mishra", "fLUIWIiY28XYW1uoQ1bHlLbp03zoJ3Yd");
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(sqlSelect);

            JSONObject jsonObject = new JSONObject();
            JSONArray array = new JSONArray();
//
            while (rs.next()){
                JSONObject record = new JSONObject();
                JSONObject jsonObject1;
                record.put("key", rs.getString("key"));
                record.put("phone_number", rs.getString("phone_number"));
                record.put("pin", rs.getString("pin"));
                record.put("payload", rs.getString("payload"));
//                try {
//                    jsonObject1 = new JSONObject(rs.getString("payload"));
//                    record.put("payload", jsonObject1);
//                } catch (Exception e){
//                    System.out.println("payload null");
//                }
                record.put("user_id", rs.getString("user_id"));
                array.put(record);
            }

            conn.close();
            jsonObject.put("data", array);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(jsonObject.toString());
            String prettyJsonString = gson.toJson(je);
            try {
                FileWriter file = new FileWriter("/Users/alfath/FinAccel/LearningJsonServer/jsonFile/jsonfileResult3.json");
                file.write(prettyJsonString);
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("JSON file created......");

        }catch (SQLException e){
            conn.close();
            throw new NullPointerException();

        }

        String key = "ui.stag.edc.phone.1";

        String baseURL = "http://localhost:3000/";
        RequestSpecification testRequest = new RequestSpecBuilder().setBaseUri(baseURL).setUrlEncodingEnabled(false)
                .setAccept("application/json").addHeader("Content-Type", "application/json")
                .addFilter(new RestAssuredRequestFilter()).build().log().all();

        Response getJsonServer = given().spec(testRequest).queryParam("key", key).expect().statusCode(200).when().get("file");

//        JSONObject obj3 = new JSONObject(getJsonServer.getBody().asString());
        JSONArray obj = new JSONArray(getJsonServer.getBody().asString());
        String number = obj.getJSONObject(0).getString("number");
        String pin = obj.getJSONObject(0).getString("pin");
        int userId = obj.getJSONObject(0).getInt("user_id");
        JSONObject payload = new JSONObject(obj.getJSONObject(0).getJSONObject("payload").toString());

        System.out.println(number);


//        Map<String, String> hmap = new HashMap<>();
//        for (int i = 0; i < obj3.length(); i++){
//            String [] elementName = JSONObject.getNames(obj3);
//
//            hmap.put(Array.get(elementName, i).toString(), obj3.getString(Array.get(elementName, i).toString()));
//        }
//
//
//        for (Map.Entry<String, String> set: hmap.entrySet()) {
//            System.out.println(set.getKey() + " = " + set.getValue());
//        }
//
//    }

    }

    public void connectionDB() throws SQLException {

    }


    @Test
    public void getJsonFromJsonServer(){
        String key = "ui.stag.edc.phone1";

        String baseURL = "http://192.168.1.143:4301/";
        RequestSpecification testRequest = new RequestSpecBuilder().setBaseUri("http://192.168.1.143:4301/").setUrlEncodingEnabled(false)
                .setAccept("application/json").addHeader("Content-Type", "application/json")
                .addFilter(new RestAssuredRequestFilter()).build().log().all();

        Response getJsonServer = given().spec(testRequest).queryParam("key", "ui.stag.edc.phone1")

                .noFilters().expect().statusCode(200).when().get("userdata");
        JSONArray obj = new JSONArray(getJsonServer.getBody().asString());
        String number = obj.getJSONObject(0).getString("phone_number");
        String pin = obj.getJSONObject(0).getString("pin");
        int userId = obj.getJSONObject(0).getInt("user_id");
        String payload = obj.getJSONObject(0).getString("payload");
//        JSONObject payload = new JSONObject(obj.getJSONObject(0).getJSONObject("payload").toString());
//        System.out.println(payload.get("fingerprint"));
        cobaNih cobaNih = new cobaNih();
        cobaNih.ada();
    }


    @Test
    public void getFromJson() throws JsonProcessingException {
        String key = "ui.stag.edc.phone1";

        String baseURL = "http://192.168.1.143:4301/";
        ObjectMapper objectMapper = new ObjectMapper();
        long starttime = System.currentTimeMillis();
        System.out.println(starttime);
//
//        Map<String, String> testDataStageData = new HashMap<>();
        RequestSpecification testRequest = new RequestSpecBuilder().setBaseUri("http://192.168.1.143:4301/").setUrlEncodingEnabled(false)
                .setAccept("application/json").addHeader("Content-Type", "application/json")
                .addFilter(new RestAssuredRequestFilter()).build().log().all();
        Response getJsonServer = given().spec(testRequest).queryParam("key", key).expect().statusCode(200).when().get("testdatauser");
        JSONArray obj = new JSONArray(getJsonServer.getBody().asString());
        try {
//            String number = obj.getJSONObject(0).getString("phone_number");
//            String pin = obj.getJSONObject(0).getString("pin");
//            int userId = obj.getJSONObject(0).getInt("user_id");
//            String payload = obj.getJSONObject(0).getString("payload");
//            testdatastage testdatastage1 = new testdatastage(key, number, pin,payload, userId);
//            System.out.println(testdatastage1.getKey());
//
//            testDataStageData.put("key", obj.getJSONObject(0).getString("key"));
//            testDataStageData.put("phone_number", obj.getJSONObject(0).getString("phone_number"));
//            testDataStageData.put("pin", obj.getJSONObject(0).getString("pin"));
//            testDataStageData.put("payload", obj.getJSONObject(0).getString("payload"));
//            testDataStageData.put("user_id", String.valueOf(obj.getJSONObject(0).getInt("user_id")));

//            String json = "[{\n" +
//                    "        \"key\": \"api.lender.extra.config.phone1\",\n" +
//                    "        \"phone_number\": \"84039601573\",\n" +
//                    "        \"pin\": \"131212\",\n" +
//                    "        \"payload\": \"{\\n    \\\"fingerprint\\\": \\\"KNeqLqgEainPIofuH7xEXIsGrnGDpOTjojxA25aD8hOOwWx3k81keWGBWYtasFJba+9ER+O9Db9m\\\\naLleWn4Zm1JoTyhgMyMJY9KrAlwCgdsGDLmAvCbLXxD+VKHSP6jkG3zRmczueIsofHqoxETUGBAj\\\\nhkzp9gMDQYjBvWa1L6aKOzDnpbC093s2ul0jZcLs5wtfwmkufp+pSdgdudBB8YZ9k6PUQaLA4d+t\\\\nSoxJTpO3TSXflY4xcncRs8SuNPWxfSuu6eizodzTHtpghEHivgX8/+zv4WsJelQAatmlzCVFr62n\\\\n0OaeC7QD1qRRt+VAsdKQtxcDyEZtdxJQa8qurs7UUwtv7TBUt8/Q6IPBdj1aGKqJTRA+7XhnwRpI\\\\n69ZfZPedW1vwMkbqKOSx7bmxJw==\\\\n\\\",\\n    \\\"mobile_number\\\": \\\"+62-84039601573\\\",\\n    \\\"password\\\": \\\"MTMxMjEy\\\",\\n    \\\"platform\\\": \\\"ANDROID\\\",\\n    \\\"tracker_id\\\": \\\"861017\\\"\\n}\",\n" +
//                    "        \"user_id\": 2562265\n" +
//                    "    }]";
            testdatastage[] testdatastage = objectMapper.readValue(getJsonServer.getBody().asString(), testdatastage[].class);

            long duration = System.currentTimeMillis() - starttime;
            System.out.println((double) duration/1000);
            System.out.println();
            testdatastage[0].getPayload();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
