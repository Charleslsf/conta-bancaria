package com.contaBancaria.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Util {

    public static String converterLocalCurrency(Double valor) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return format.format(valor);
    }
}
