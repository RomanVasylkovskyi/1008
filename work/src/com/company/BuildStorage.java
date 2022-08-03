package com.company;

public class BuildStorage {

    private static String Adres[] = new String[]{"Vinnytsia region, Kozyatyn district, Hlukhivtsi village, 1 Zavodska street, 22130", "Vinnytsia region, Barsky district, Bar city, 39 Dimitrova street, 23000", "Vinnytsia city, R. Skaletskoho St., 17, 21018 ", " Khmelnytskyi, Volodymyrska St., 91, 29000 ", " Vinnytsia, Mykola Amosova St. (formerly Medvedev), 9, apt. 165 ", " Vinnytsia Region. , Bershad district, Bershad, Mykolaenko str., 25, 24400 ", " Kyiv, Hrushevskoho str., 1D, 01001 ", " Vinnytsia, Soborna str., 71, 21100 ", " Vinnytsia region ., Zhmerynka, Kosmonavtiv str., 97, 23100 ", " Khmelnytskyi str., Volodymyrska str., 91, 29000 ", " Kyiv, Leiptsyzka str., 15, 01015 ", " Vinnytsia region, Murovanokurilovetsky district -n, Murovani Kurylivtsi township, Komarova str., 8, 23400 ", " Vinnytsia, Bloka str., 30, 21018 ", " Vinnytsia region, Ladyzhyn str., 44A Postova str. Kyiv, Hrushevskoho St., 1D, 01001 ", " Khmelnytskyi, Volodymyrska St., 91, 29000 ", " Khmelnytskyi, Volodymyrska St., 91, 29000 ", " Khmelnytskyi, 91 Volodymyrska St. , 290 00 ", " Vinnytsia, street Pirogova, 29, 21018 ", " Vinnytsia region, Khmilnytskyi district, Khmilnyk, street Stolyarchuk, 3, 22000 "};
    private static String TypeBuild[] = new String[]{"Apartment", "Room", "House"};

    private static String InfoBuild[] = new String[]{"Territorial Directorate of the State Judicial Administration of Ukraine in Vinnytsia Oblast", "Central Western Interregional Directorate ", " Department of Social and Youth Policy of the Bershad District State Administration ", " JSC Commercial Bank PrivatBank ", " Branch of Vinnytsia Regional Directorate of PJSC State Savings Bank of Ukraine ", " Natural person - entrepreneur Mazurenko Raisa Petrovna ", " Central -Western Interregional Directorate of the Ministry of Justice ( M. Khmelnitsky) ", " Private Joint Stock Company of VF Ukraine ", " Management of the State Treasury Service of Ukraine in the Murovanokurilovetsky District of Vinnytsia Region ", " LLC Center BANK PRIVATBANK ", "Central-Western Interregional Department Minister of the Ministry of Justice (Khmelnytsky) ", " Central-Western Interregional Department of the Ministry of Justice (Khmelnytsky) ", " Central-Western Interregional Department of the Ministry of Justice (Khmelnytsky) ", " ECONOMIC COURT ADMINISTRATION"};
    private static String OwnerInfo[] = new String[]{"SPFU Regional Office in Poltava and Sumy Oblasts", "SPFU Regional Office in Kyiv", "SPFU Regional Office in Kyiv", "SPFU Regional Office in Dnipropetrovsk, Zaporizhia and Kirovohrad Oblasts", "Kharkiv Regional Office", "Donetsk and Luhansk oblasts ", " SPFU regional branch in Kharkiv, Donetsk and Luhansk oblasts ", " SPFU regional branch in Kyiv, Chernihiv and Cherkasy oblasts ", " SPFU regional branch in Kyiv ", " SPFU regional branch in Kyiv ", "SPFU regional branch in Kyiv Chernihiv and Cherkasy regions ", " SPFU regional branch in Kharkiv, Donetsk and Luhansk regions ", " SPFU regional branch in Kyiv, Chernihiv and Cherkasy regions ", " SPFU regional branch in Poltava and Sumy regions ", " Regional branch. Kyiv ", " Regional branch of the SPFU in Kyiv, Chernihiv and Cherkasy regions ", " Regional branch of the SPFU in Kyiv, Chernihiv and Cherkasy oblasts ", " SPFU regional branch in Kharkiv, Donetsk and Luhansk oblasts ", " SPFU regional branch in Kyiv ", " SPFU regional branch in Kharkiv, Donetsk and Luhansk oblasts ", " SPFU regional branch Kharkiv, Donetsk and Luhansk regions ", " Regional branch of the SPFU in Kyiv ",};
    public static String[] StartRentData = new String[]{"2017-7-7","2015-5-13","2016-8-3","2020-5-3","2019-7-5","2018-9-16","2015-5-20"};
    public static String[] FinishRentData = new String[]{"2026-7-8","2028-5-13","2027-1-5","2030-4-15","2039-5-13","2028-9-16","2028-5-20"};


    private static String RentRules[] = new String[]{"without animals, permitted for commercial use, permitted for repair", "satisfied animals, prohibition of use for commercial purposes, permitted for repair, prohibition for reorganization", "permitted animals, permitted for commercial use", "without animals, permitted for use in commercial purposes, permitted repairs, permitted alterations. ", " pets allowed, permitted for commercial purposes, permitted repairs, permitted alterations ", " no animals, permitted for commercial purposes, permitted repairs, prohibition of alterations ", " no animals, permitted commercial use, permitted repairs, permitted alterations ", " no animals, permitted repairs, permitted alterations ", " no animals, permitted for commercial use, permitted repairs, prohibition of alterations ", " no animals permitted for commercial use purposes, repair allowed ", " satisfied animals, allowed use for commercial purposes, allowed repair, allowed reconstruction ", " without persons etc., permitted use for commercial purposes, permitted repairs, permitted alteration ", " satisfied animals, prohibition of commercial use, permitted repairs, permitted alteration. ", " permitted animals, permitted use for commercial purposes, permitted repairs, prohibition of alteration.  ", "pets allowed, commercial use permitted, repairs permitted, alterations permitted.", "no animals, commercial use prohibited, repairs permitted, alterations permitted", "prohibition on restructuring "};
    private static double Cost[] = new double[]{462570.4, 20426.9, 50694.0, 14005.4, 1336.9, 11104.6, 34991.8, 5330.8, 8497.4, 2859.1, 2493.5, 1505.0, 1001.6, 1816.5, 2167.7, 639.5, 8639.8, 3166.3, 1408.3, 3740.1};


    public static String getAdres() {
        return Adres[(int) (Math.random() * 19)];
    }

    public static String getTypeBuild() {
        return TypeBuild[(int) (Math.random() * 2)];
    }

    public static String getInfoBuild() {
        return InfoBuild[(int) (Math.random() * 13)];
    }

    public static String getOwnerInfo() {
        return OwnerInfo[(int) (Math.random() * 19)];
    }

    public static String getStartRentData() {
        return StartRentData[(int) (Math.random() * 3)];
    }

    public static String getFinishRentData() {
        return FinishRentData[(int) (Math.random() * 3)];
    }

    public static String getRentRules() {
        return RentRules[(int) (Math.random() * 16)];
    }

    public static double getCost() {
        return Cost[(int) (Math.random() * 19)];
    }

}
/*"Будівлі нежитлові", "Будинки житлові", "Будинки житлові готельного типу", "Будівлі офісні", "Будівлі офісні", "Гаражне приміщення", "Гаражі підземні приміщення", "Будівлі промислові", "склад", "Будівлі нежитлові", "Будинки житлові", "Будинки житлові готельного типу", "Будівлі офісні", "Будівлі офісні", "Гаражне приміщення", "Гаражі підземні приміщення", "Будівлі промислові", "склад", "Будівлі нежитлові", "Будинки житлові"*/
