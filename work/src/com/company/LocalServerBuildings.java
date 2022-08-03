package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.util.stream.Collectors;

public class LocalServerBuildings implements HttpHandler {
    static int requestCounter = 0;

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        httpExchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST");
        String[] requestParams = null;
        if ("GET".equals(httpExchange.getRequestMethod())) {
            requestParams = getRequestParams(httpExchange);
        }
        if ("POST".equals(httpExchange.getRequestMethod())) {
            requestParams = getRequestParams(httpExchange);
        }
        returnResponse(httpExchange, requestParams);
    }

    private String[] getRequestParams(HttpExchange httpExchange) {
        String parameters = httpExchange.getRequestURI().toString().split("\\?")[1];
        String[] params = parameters.split("&");

/*      for (String param : params) {
         System.out.println(param.split("=")[0] + " -> " + param.split("=")[1]);
      }*/
        return params;
    }
    private void returnResponse(HttpExchange httpExchange, String[] requestParamValues) throws IOException {
        requestCounter++;
        System.out.println("Request received: " + requestCounter);
        OutputStream outputStream = httpExchange.getResponseBody();

        // build test response of all parameters
        StringBuilder response = new StringBuilder();
        /*///////////////////////////////////////////////////////////////////////*/
//        for (String parameter : requestParamValues) {
//            response.append("\n\t\"").append(parameter.split("=")[0] + "\" = " + parameter.split("=")[1]).append(",");
//        }
//        response.deleteCharAt(response.length() - 1);
//        response.append("\n}");
        /*/////////////////////////////////////////////////////////////////*/

        /*обробка на отримання інформації*/
        if (requestParamValues[0].equals("info")) {
            response.append(new BufferedReader(new FileReader("./src/DataBase/JsonFile.json")).readLine());
        }

        /*обробка додавання*/
        if (requestParamValues[0].equals("AddBuild")) {
            ObjectMapper objectMapper = new ObjectMapper();
            RentPlace LRentPlace = objectMapper.readValue(new BufferedReader(new InputStreamReader(httpExchange.getRequestBody())).lines().collect(Collectors.joining("\n")), RentPlace.class);
            System.out.println(LRentPlace);
            BuildArray LBuildArray = Database.dataload("./src/DataBase/JsonFile.json");
            LBuildArray.add(LRentPlace);
            Database.datasave(LBuildArray, "JsonFile");
            response.append("added");
        }

/*обробка запиту на видалення всіх об'єктів вибраного типу*/
        if (requestParamValues[0].equals("deleteAthlete")) {
            String DLRentPlace = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody())).lines().collect(Collectors.joining("\n"));
            BuildArray DelRentPlace = Database.dataload("./src/Database/JsonFile.json");
            int tempSize = DelRentPlace.getlist().size();
            DelRentPlace.deleteByType(DLRentPlace);
            Database.datasave(
                    DelRentPlace, "DELBYTYP");
        }
        /*обробка запиту на отримання доступу(перевірка паролю)*/
        if (requestParamValues[0].equals("security")) {
            String pass = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody())).lines().collect(Collectors.joining("\n"));
            String password = "test1";
            if (pass.equals(password)) {
                response.append("true");
            } else {
                response.append("false");
            }
        }

        if (requestParamValues[0].equals("EditBuildBack")) {
            ObjectMapper objectMapper = new ObjectMapper();
            RentPlace tempPerson = objectMapper.readValue(new BufferedReader(new InputStreamReader(httpExchange.getRequestBody())).lines().collect(Collectors.joining("\n")), RentPlace.class);
            BuildArray tempPersonList = Database.dataload("./src/Database/JsonFile.json");
            Database.datasave(tempPersonList, "JsonFile");
            response.append("{\"Changing\": \"Changed\"}");
        }

        httpExchange.sendResponseHeaders(0, response.length());
        outputStream.write(response.toString().getBytes());
        outputStream.flush();
        outputStream.close();
    }

}

