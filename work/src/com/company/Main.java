package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {


//        BuildArray buildArray = new BuildArray();
//        for (int i=0;i<3;i++){
//            buildArray.add(new RentPlace(BuildStorage.getAdres(),BuildStorage.getTypeBuild(),BuildStorage.getInfoBuild(),BuildStorage.getOwnerInfo(), BuildStorage.getStartRentData(),BuildStorage.getFinishRentData(),BuildStorage.getRentRules(),BuildStorage.getCost()));
//        }
//        Database.datasave(buildArray,"JsonFile");


        System.out.println();

        simplestServerExample();
    }




    public static void simplestServerExample() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        server.createContext("/back", new LocalServerBuildings());
        server.start();
        System.out.println(System.lineSeparator() + "Server started at:\tlocalhost:8080");
    }


}