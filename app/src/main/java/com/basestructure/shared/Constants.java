package com.basestructure.shared;

/**
 * Created by innofied on 29/3/18.
 */

public class Constants {
    public static String PHPSESSID = "";
    public static String EASTER_EGG_API_URL = "";
    public static boolean EASTER_EGG_ENABLE = false;
    public static String PRODUCTION_API_URL = "";
    public static String DEVELOPMENT_API_URL = "";


    public static String getAPIURL () {
        if(EASTER_EGG_ENABLE)
            return EASTER_EGG_API_URL;
        else
            return PRODUCTION_API_URL;
    }

}
