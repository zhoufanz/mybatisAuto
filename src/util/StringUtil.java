package util;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    /**
     * 获得大驼峰字符
     *
     * @param source
     * @return
     */
    public static String makeBigHump(String source) {
        //将首字母大写
        source = source.substring(0, 1).toUpperCase() + source.substring(1);
        //循环排除_并将其后大写
        int underIndex;
        while ((underIndex = source.indexOf("_")) >= 0) {
            String begin = source.substring(0, underIndex);
            String upper = source.substring(underIndex + 1, underIndex + 2).toUpperCase();
            String end = source.substring(underIndex + 2);
            source = begin + upper + end;
        }
        return source;
    }

    /**
     * 获得大驼峰字符2
     *
     * @param source
     * @return
     */
    public static String makeBigHump2(String source) {
        //将首字母大写
        source = source.substring(0, 1).toUpperCase() + source.substring(1);
        if (source.indexOf("_") < 0) {
            return source;
        }
        String[] strArr = source.split("_");
        StringBuffer sb = new StringBuffer();
        for (String string : strArr) {
            String change = string.substring(0, 1).toUpperCase() + string.substring(1);
            sb.append(change);
        }
        return sb.toString();
    }

    /**
     * 将指定文件夹中的非Example的类名输出为分割字符窜 "a","b"..
     *
     * @param path
     * @return
     */
    public static String getDirectoryClassNameString(String path) {
        File directoryFile = new File(path);
        try {
            File[] files = directoryFile.listFiles();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                fileName = fileName.substring(0, fileName.lastIndexOf("."));
                //实体类
                if (fileName.indexOf("Example") < 0) {
                    sb.append("\"" + StringUtil.makeBigHump2(fileName) + "\",");
                }
            }
            return sb.toString().substring(0, sb.toString().length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将指定文件夹中的非Example的类名输出为List<String>
     *
     * @param path
     * @return
     */
    public static List<String> getDirectoryClassNameListString(String path) {
        List<String> classNames = new ArrayList<String>();
        File directoryFile = new File(path);
        try {
            File[] files = directoryFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                int index = fileName.lastIndexOf("Entity");
                if (index == -1) {
                    throw new Exception("实体后缀必须为Entity");
                }
                fileName = fileName.substring(0, index);
                //实体类
                if (fileName.indexOf("Example") < 0) {
                    classNames.add(fileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classNames;
    }



    /**
     * 驼峰写法 返回 _x_
     *
     * @param bigHum
     * @return
     */
    public static final char UNDERLINE = '_';

    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String underlineToCamel2(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        StringBuilder sb = new StringBuilder(param);
        Matcher mc = Pattern.compile("_").matcher(param);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            //String.valueOf(Character.toUpperCase(sb.charAt(position)));
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }
//
    public static String tableNameToEntityName(String tableName) {
        if (tableName.toUpperCase().indexOf("T_") == 0) {
            tableName = tableName.substring(2);
        }else if(tableName.toUpperCase().indexOf("TB_") == 0){
            tableName = tableName.substring(3);
        }
        int length = tableName.length();
        String s = tableName.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(i==0){
                sb.append(s.substring(0, 1).toUpperCase());
                continue;
            }

            String substring = s.substring(i, i + 1);
            if (substring.equals("_")){
                sb.append(s.substring(i + 1, i+2).toUpperCase());
                i+=1;
            }else{
                sb.append(substring);
            }

        }
        return sb.toString().trim()+"Entity";
    }
    public static void main(String[] args) {
        System.out.println(tableNameToEntityName("T_FIN_BIll"));
        System.out.println(tableNameToEntityName("FIN_BIll"));
    }
}
