package main;

import util.StringUtil;

public class GeneratorSqlmapBefore {

    /**
     * 多个表名之间用\n隔开
     * @return
     */
    public static String getStringByTableList() {
        return
                "T_MM_APPLICATION_DETAIL\n" +
                        "T_MM_APPLICATION\n" +
                        "T_MM_PURCHASE_PRICE_HISTORY\n" +
                        "T_MM_SECTION_DETAIL\n" +
                        "T_MM_SECTION\n" +
                        "T_MM_PRIZE_DEPART_DETAIL\n" +
                        "T_MM_PRIZE_DETAILE\n" +
                        "T_MM_PRIZE\n" +
                        "T_MM_SECTION_SL\n" +
                        "T_MM_REPORT_FORM\n" +
                        "T_MM_ADD_STOCK_DETAIL\n" +
                        "T_MM_ADD_STOCK\n" +
                        "T_MM_STOCK\n" +
                        "T_MM_MATTER_CLASS\n" +
                        "T_MM_INCOME_COST_STATISTICS\n" +
                        "T_MM_INCOME_COST_DETAIL\n" +
                        "T_MM_REPORT_FORM_INFO\n" +
                        "T_MM_SECTION_SL_TEMP\n";
    }
    public static String template(String tableName, String EntityName) {
        String temp = "\t<table tableName=\""+tableName.trim()+"\" domainObjectName=\""+EntityName.trim()+"\" enableDeleteByExample=\"false\"\n" +
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