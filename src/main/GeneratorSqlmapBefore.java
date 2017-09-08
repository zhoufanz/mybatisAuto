package main;

import util.StringUtil;

public class GeneratorSqlmapBefore {

    public static String getStringByTableList() {
        return "T_FIN_ACCOUNT\n" +
                "T_FIN_ACCOUNT_CARD\n" +
                "T_FIN_ACCOUNT_OPER_AUDIT\n" +
                "T_FIN_ACCOUNT_OPER_INFO\n" +
                "T_FIN_ACCOUNT_LIST_BAK\n" +
                "T_FIN_ACCOUNT_LIST\n" +
                "T_FIN_ACCOUNT_LIST_HISTORY\n" +
                "T_FIN_ACCOUNT_TRADE_HISTORY\n" +
                "T_FIN_ACCOUNT_OPER_HISTORY\n" +
                "T_FIN_ACCOUNT_LIST_BAK2\n" +
                "T_FIN_ACCOUNT_OPER_TEMP\n" +
                "T_FIN_ACCOUNT_TRADE_DETAIL\n" +
                "T_FIN_ACCOUNT_TRADE_TEMP\n";
    }
    public static String template(String tableName, String EntityName) {
        String temp = "\t<table tableName=\""+tableName+"\" domainObjectName=\""+EntityName+"\" enableDeleteByExample=\"false\"\n" +
                "\t\t\t   enableUpdateByExample=\"false\" selectByExampleQueryId=\"false\"\n" +
                "\t\t\t   selectByPrimaryKeyQueryId=\"false\" enableCountByExample=\"false\" enableSelectByExample=\"false\">\n" +
                "\t\t\t<property name=\"useActualColumnNames\" value=\"false\"/>\n" +
                "\t\t</table>";

        return temp;
    }


    /**
     * 启动 控制台 table 映射
     * 将table节点复制到 generatorConfig.xml结尾
     * 再启动 GeneratorSqlmap.main
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String stringByTableList = getStringByTableList();
        String[] split = stringByTableList.split("\n");
        for (int i = 0; i < split.length; i++) {
            String template = template(split[i], StringUtil.tableNameToEntityName(split[i]));
            System.out.println(template);
        }
    }
}