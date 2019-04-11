package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Data {

    public static String DevolveData() {
        Date hoje = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        return sdf.format(hoje);
    }
}
