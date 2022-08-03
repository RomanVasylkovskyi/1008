package com.company;

public class RentPlace {


    private String location;
    private String typeB;
    private String infoB;
    private String infoOwn;
    private String rentDataS =BuildStorage.getStartRentData();
    private String rentDataF =BuildStorage.getFinishRentData();
    private String rules;
    private double money;


    public RentPlace(String location, String typeB, String infoB, String infoOwn, String rentDataS, String rentDataF, String rules, double money) {

        this.setLocation(location);
        this.setTypeB(typeB);
        this.setInfoB(infoB);
        this.setInfoOwn(infoOwn);
        this.setRentDataS(rentDataS);
        this.setRentDataF(rentDataF);
        this.setRules(rules);
        this.setMoney(money);
    }


    public String getTypeB() {
        return typeB;
    }


    public String getRentDataS() {
        return rentDataS;
    }

    public String getRentDataF() {
        return rentDataF;
    }

    public String getLocation() {
        return location;
    }

    public String getInfoB() {
        return infoB;
    }

    public String getInfoOwn() {
        return infoOwn;
    }

    public String getRules() {
        return rules;
    }

    public double getMoney() {
        return money;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTypeB(String typeB) {
        this.typeB = typeB;
    }

    public void setInfoB(String infoB) {
        this.infoB = infoB;
    }

    public void setInfoOwn(String infoOwn) {
        this.infoOwn = infoOwn;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setRentDataS(String rentDataS) {
        this.rentDataS = rentDataS;
    }

    public void setRentDataF(String rentDataF) {
        this.rentDataF = rentDataF;
    }
}
