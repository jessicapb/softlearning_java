package com.core.checks;

//import java.util.Set;

public class Check {
    //Buit set
    public static Boolean isNull(String s){
        return s == null ? true:false;
    }

    //Longitud del set
    public static int minLenght(String s, int length){
        if(Check.isNull(s)){
            return -1;
        }
        return s.trim().length() >= length ? 0 : -3;
    }

    // public static int minLenghtSet(Set <String> set, int length){
    //     return set.trim().length() >= length ? 0: -3;
    // }

    //Negatiu set
    public static int isNegative (int n){
        if(n <= 0){
            return -1;
        }else{
            return 0;
        }
    }

    public static int isNegativef(double s){
        if(s <= 0){
            return -1;
        }else{
            return 0;
        }
    }

    //Identificador dels set (errors) dels fitxers del Stakeholders o Product
    public static String getErrorMessage(int e){
        switch (e) {
            case 0: return "Done, ";
            case -1: return "El camp està buit, ";
            case -2: return "El camp ha de ser més llarg, ";
            case -3: return "No pot ser negatiu o 0, ";
            default: return "Unknown error, ";
        }
    }
}
