package main;

import util.StringUtil;

public class GeneratorSqlmapBefore {

    //生成

    public static void main(String[] args) throws Exception {
        String stringByTableList = getStringByTableList();
        String[] split = stringByTableList.split("\n");
        for (int i = 0; i < split.length; i++) {
            String template = template(split[i], StringUtil.tableNameToEntityName(split[i]));
            System.out.println(template);
        }
    }

    public static String getStringByTableList() {
        return "T_FIN_ACCOUNT\n" +
                "T_FIN_ACCOUNT_LIST\n" +
                "T_FIN_ACCOUNT_LIST_HISTORY\n" +
                "T_FIN_ACCOUNT_TRADE_HISTORY\n" +
                "T_FIN_ACCOUNT_TRADE_TEMP\n";
    }
//	<table tableName="{0}" domainObjectName="{1}" enableDeleteByExample="false"
    public static String template(String tableName, String EntityName) {
        String temp = "\t<table tableName=\""+tableName+"\" domainObjectName=\""+EntityName+"\" enableDeleteByExample=\"false\"\n" +
                "\t\t\t   enableUpdateByExample=\"false\" selectByExampleQueryId=\"false\"\n" +
                "\t\t\t   selectByPrimaryKeyQueryId=\"false\" enableCountByExample=\"false\" enableSelectByExample=\"false\">\n" +
                "\t\t\t<property name=\"useActualColumnNames\" value=\"false\"/>\n" +
                "\t\t</table>";

        return temp;
    }
}