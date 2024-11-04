package com.core.checks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpreReg {
    // Expressió regular ISBN del llibre
    public static int checkISBN(String ISBN){
        Pattern pattern = Pattern.compile("/^97[7-8]{1}[0-9]{10}$");
        Matcher matcher = pattern.matcher( ISBN);
        int matches = 0;
        if(matcher.matches()){
            matches++;
        }
        return  matches;
    }

    //https://www.baeldung.com/regular-expressions-java
}
