package com.sendlime.client.common;

import java.util.regex.Pattern;

public class Utils {
    public static void toValidator(String to) {
        if (!Pattern.compile("^8801[3-9]\\d{8}$").matcher(to).matches()) {
            throw new IllegalStateException("Invalid to provided");
        }
    }
}
