package main;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zf11 on 2017-06-04.
 */
public class ExtJsModelGenerate {
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
            att = "{name:'" + att + "',type:'string'},";

            list.add(comment);
            list.add(att);
        }
        for(String s:list){
            System.out.println(s);
        }
    }
    public static String init(){
        String vo = "/**\n" +
                "     * 主键\n" +
                "     */\n" +
                "    private String id;\n" +
                "\n" +
                "    /**\n" +
                "     * 奖励单号\n" +
                "     */\n" +
                "    private String prizeCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 奖励名称\n" +
                "     */\n" +
                "    private String prizeName;\n" +
                "\n" +
                "    /**\n" +
                "     * 奖励状态（MM_P_ZCZ.暂存中,MM_P_YTJ.已提交)\n" +
                "     */\n" +
                "    private String prizeFlag;\n" +
                "\n" +
                "    /**\n" +
                "     * 采购合计\n" +
                "     */\n" +
                "    private Double jlPurchTotal;\n" +
                "\n" +
                "    /**\n" +
                "     * 销售合计\n" +
                "     */\n" +
                "    private Double jlProposeTotal;\n" +
                "\n" +
                "    /**\n" +
                "     * 品类数量\n" +
                "     */\n" +
                "    private Integer categoryNumber;\n" +
                "\n" +
                "    /**\n" +
                "     * 总数量\n" +
                "     */\n" +
                "    private Integer totalNumber;\n" +
                "\n" +
                "    /**\n" +
                "     * 奖励部门数量\n" +
                "     */\n" +
                "    private Integer prizeSiteCodeCount;\n" +
                "\n" +
                "    /**\n" +
                "     * 操作人(选择器)\n" +
                "     */\n" +
                "    private String inputUserCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 操作时间\n" +
                "     */\n" +
                "    private Date inputTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 摘要\n" +
                "     */\n" +
                "    private String prizeRemark;\n" +
                "\n" +
                "    /**\n" +
                "     * 创建人\n" +
                "     */\n" +
                "    private String createUserCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 创建时间\n" +
                "     */\n" +
                "    private Date createTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 修改人\n" +
                "     */\n" +
                "    private String modifyUserCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 修改时间\n" +
                "     */\n" +
                "    private Date modifyTime;\n" +
                "\n" +
                "   //修改人\n" +
                "    private String modifyUserCodeName;\n" +
                "    //创建人\n" +
                "    private String createUserCodeName;\n" +
                "    //操作人名称\n" +
                "    private String inputUserCodeName;\n" +
                "    //操作时间起\n" +
                "    private Date inputTimeStart;\n" +
                "    //操作时间止\n" +
                "    private Date inputTimeEnd;\n" +
                "    //奖励状态名称\n" +
                "    private String prizeFlagName;";
        return vo;
    }
}
