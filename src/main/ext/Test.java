package main.ext;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zf11 on 2017-08-23.
 */
public class Test {
    public static void main(String[] args) {
        String[] ss = {"dsfdfds"};
        List<String> strings = Arrays.asList(ss);
        System.out.println(listToString(strings));
    }
    private static String listToString(List<String> list){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < list.size(); i++) {

            if (i != list.size() - 1) {
                sb.append("'"+list.get(i) + "',");
            }else{
                sb.append("'"+list.get(i)+"'");
            }
        }
        String s = sb.toString();
        int i = s.indexOf("'", 0);
        return s.substring(i+1,s.length()-1);

    }
}
