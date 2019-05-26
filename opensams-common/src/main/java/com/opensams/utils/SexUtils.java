package com.opensams.utils;

/**
 * @author Kevin Leung
 */
public class SexUtils {

    private static String maleDbExp = "male";

    private static String femaleDbExp = "female";

    private static String maleFrontExp = "男";

    private static String femaleFrontExp = "女";


    public static String transformToDbExp(String sex) {
        if (maleFrontExp.equals(sex)) {

            return maleDbExp;

        } else if (femaleFrontExp.equals(sex)) {

            return femaleDbExp;

        }

        return "";
    }

    public static String transformToFrontExp(String sex) {
        if (maleDbExp.equals(sex)) {

            return maleFrontExp;

        } else if (femaleDbExp.equals(sex)) {

            return femaleFrontExp;

        }

        return "";
    }

}
