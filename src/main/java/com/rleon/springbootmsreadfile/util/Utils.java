package com.rleon.springbootmsreadfile.util;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Utils {

    public static String validateString(String value) {
        String msj = "";
        if (!isNumeric(value.substring(0, 1))) {
            if (!validateAlfaNumeric(value)) {
                msj = "No porque contiene caracteres no alfanuméricos";
            } else {
                msj = "Si tiene una sintanxis correcta";
            }
        } else {
            msj = "No, porque empieza con un numero";
        }
        return msj;
    }

    public static boolean validateAlfaNumeric(String value) {
        Pattern regex = Pattern.compile("^[a-zA-Z0-9_]+$");
        Matcher regexMatcher = regex.matcher(value);
        return regexMatcher.find();
    }

    public static boolean isNumeric(String val) {
        boolean numeric = true;
        try {
            Integer num = Integer.parseInt(val);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        return numeric;
    }


}
