package main;

import util.StringUtil;

public class GeneratorSqlmapBefore {

    /**
     * 多个表名之间用\n隔开
     * @return
     */
    public static String getStringByTableList() {
        return
                "member_wechat_bind\n" ;

    }
    public static String template(String tableName, String EntityName) {
        String temp = "\t<table tableName=\""+tableName.trim()+"\" domainObjectName=\""+EntityName.trim()+"\" enableDeleteByExample=\"false\"\n" +
                "\t\t\t   enableUpdateByExample=\"false\" selectByExampleQueryId=\"false\"\n" +
                "\t\t\t   enableDeleteByPrimaryKey=\"false\"\n" +
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