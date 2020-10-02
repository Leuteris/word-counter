package gr.xe.challenge.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Utils {

    public static BigDecimal parseMoney(String amount) {
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
        try {
            return new BigDecimal(nf.parse(amount).toString());
        } catch (ParseException e) {///
            System.out.println("Error Can not parse the amount" + e);///
            return null;
        }
    }
}///111
//333
//
//7
//
,,,
//
//
//