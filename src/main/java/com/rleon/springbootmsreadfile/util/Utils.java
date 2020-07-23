package com.rleon.springbootmsreadfile.util;

import lombok.extern.slf4j.Slf4j;
import java.util.regex.Pattern;

@Slf4j
public class Utils {

    public static String validateString(String value) {
        StringBuilder msj = new StringBuilder();
        if (isNumeric(value.substring(0, 1))) {
            log.info("No, porque empieza con un numero, ");
            msj.append("No, porque empieza con un numero, ");
        }
        if (!validateAlfanumeric(value)) {
            log.info("No, porque empieza con un numero, ");
            msj.append("No porque contiene caracteres no alfanuméricos, ");
        } else {
            msj.append("Si tiene una sintanxis correcta");
        }
        return msj.toString();
    }

    public static boolean validateAlfanumeric(String value) {
        return Pattern.matches("^[A-Za-z0-9]+$", value);
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
