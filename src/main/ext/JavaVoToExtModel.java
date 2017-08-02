package main.ext;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by zf11 on 2017-06-04.
 * 入
 *  /**
 *  修改时间
 *
 private Date modifyTime;

 //修改人
 private String modifyUserCodeName;

 出
 //修改时间
 {name:'modifyTime',type:'string'},
 //修改人
 {name:'modifyUserCodeName',type:'string'},
 *
 *
 */
public class JavaVoToExtModel {
    public static void main(String[] args) {
        String vo = init();

        String[] lines = vo.split(";");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String line= lines[i].trim();

            int begin=line.indexOf("*",3);
            int end = line.indexOf("\n", begin);
            String comment = line.substring(begin+1,end);

            comment=comment.trim();

            int idx=comment.indexOf("/");
            while(idx>=0){
                comment = comment.substring(idx + 1);
                idx=comment.indexOf("/");
            }
            comment = "//" + comment;

            String att=line.substring(line.indexOf("private"));
            String[] split = att.split(" ");
            att = split[2].trim();

            if(att.indexOf("Time")>=0||att.indexOf("Date")>=0){
                att = "{name:'" + att + "',type:'date',convert: dateConvert},";
            }else {
                att = "{name:'" + att + "',type:'string'},";
            }

            list.add(comment);
            list.add(att);
        }
        for(String s:list){
            System.out.println(s);
        }
    }
    public static String init(){
        return "/**\n" +
                "     * 审核iD\n" +
                "     */\n" +
                "    private String id;\n" +
                "\n" +
                "    /**\n" +
                "     * 价格条目编码\n" +
                "     */\n" +
                "    private String priceItemCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 产品类型编码\n" +
                "     */\n" +
                "    private String productCode;\n" +
                "    /**\n" +
                "     * 产品类型编码名字\n" +
                "     */\n" +
                "    private String productCodeName;\n" +
                "\n" +
                "    /**\n" +
                "     * 业务类型:(0：全部 1：汽运 2：特快件(航空)\n" +
                "     */\n" +
                "    private String bizType;\n" +
                "    /**\n" +
                "     * 业务类型:(0：全部 1：汽运 2：特快件(航空)名字\n" +
                "     */\n" +
                "    private String bizTypeName;\n" +
                "\n" +
                "    /**\n" +
                "     * 货物属性 （0：普通件 1：易碎品 2：贵重物品）\n" +
                "     */\n" +
                "    private String goodsMode;\n" +
                "\n" +
                "    /**\n" +
                "     * 货物属性 （0：普通件 1：易碎品 2：贵重物品）名字\n" +
                "     */\n" +
                "    private String goodsModeName;\n" +
                "\n" +
                "\n" +
                "    /**\n" +
                "     * 开始时间\n" +
                "     */\n" +
                "    private Date startDate;\n" +
                "\n" +
                "    /**\n" +
                "     * 结束时间\n" +
                "     */\n" +
                "    private Date endDate;\n" +
                "\n" +
                "    /**\n" +
                "     * 创建人\n" +
                "     */\n" +
                "    private String createUserCode;\n" +
                "    /**\n" +
                "     * 创建人名字\n" +
                "     */\n" +
                "    private String createUserCodeName;\n" +
                "\n" +
                "    /**\n" +
                "     * 创建时间\n" +
                "     */\n" +
                "    private Date createDate;\n" +
                "\n" +
                "    /**\n" +
                "     * 修改人\n" +
                "     */\n" +
                "    private String modifyUserCode;\n" +
                "    /**\n" +
                "     * 修改人名字\n" +
                "     */\n" +
                "    private String modifyUserCodeName;\n" +
                "\n" +
                "    /**\n" +
                "     * 修改时间\n" +
                "     */\n" +
                "    private Date modifyDate;\n" +
                "\n" +
                "    /**\n" +
                "     * 备注\n" +
                "     */\n" +
                "    private String remarks;\n" +
                "\n" +
                "\n" +
                "    /**\n" +
                "     * 报价分类主表外键ID\n" +
                "     */\n" +
                "    private String priceId;\n" +
                "    /**\n" +
                "     * 发货区域集合\n" +
                "     */\n" +
                "    private List<String> addressSendCodeList;\n" +
                "\n" +
                "    /**\n" +
                "     * 收货区域编码集合\n" +
                "     */\n" +
                "    private List<String> addressEndCodeList;\n" +
                "\n" +
                "    /**\n" +
                "     * 发货区域\n" +
                "     */\n" +
                "    private String addressSendCodeName;\n" +
                "\n" +
                "    /**\n" +
                "     * 收货区域编码\n" +
                "     */\n" +
                "    private String addressEndCodeName;";
    }
}
