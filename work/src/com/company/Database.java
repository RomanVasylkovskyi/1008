package com.company;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

@JsonAutoDetect
public class Database {
    /**
     * Серіалізація
     */
    public static void datasave(BuildArray buildArray, String File) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./src/DataBase/" + File + ".json"),  buildArray);
    }
    /**
     * Десеріалізація
     */
    public static BuildArray dataload(String File) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(File), BuildArray.class);
    }
}