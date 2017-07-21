package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zf11 on 2017-06-14.
 */
public class TableCompare {

    public static void main(String[] args) throws ParseException {
        String s = "Tue Jun 20 23:59:59 CST 2017";
        SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sdf2.format(sdf1.parse(s)));
    }
}
