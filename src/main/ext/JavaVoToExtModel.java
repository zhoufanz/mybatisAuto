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
            if(line==null||line.equals("")){
                continue;
            }

            try{
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
                    att = "{name:'" + att + "',type:'date',convert : function (value) {return Ext.Date.format (new Date (value), \"Y-m-d\")}},";
                }else {
                    att = "{name:'" + att + "',type:'string'},";
                }

                list.add(comment);
                list.add(att);
            }catch(Exception ex){
                System.err.println("异常 "+line);
            }
        }
        for(String s:list){
            System.out.println(s);
        }
    }

    /**
     * 注意 注释中不能有分号 ;
     * @return
     */
    public static String init(){
        return "/**\n" +
                "     * 自增主键id\n" +
                "     */\n" +
                "    private Integer id;\n" +
                "\n" +
                "    /**\n" +
                "     * 用户主键\n" +
                "     */\n" +
                "    private Integer userId;\n" +
                "\n" +
                "    /**\n" +
                "     * 返券时用户城市ID\n" +
                "     */\n" +
                "    private Integer cityId;\n" +
                "\n" +
                "    /**\n" +
                "     * 策略id\n" +
                "     */\n" +
                "    private Integer strategyId;\n" +
                "\n" +
                "    /**\n" +
                "     * 云柜平台订单号\n" +
                "     */\n" +
                "    private String outTradeNo;\n" +
                "\n" +
                "    /**\n" +
                "     * 返券类型  1 充值返券 2 客服人工返券\n" +
                "     */\n" +
                "    private Integer type;\n" +
                "\n" +
                "    /**\n" +
                "     * 金额\n" +
                "     */\n" +
                "    private BigDecimal money;\n" +
                "\n" +
                "    /**\n" +
                "     * 已使用金额\n" +
                "     */\n" +
                "    private BigDecimal usedMoney;\n" +
                "\n" +
                "    /**\n" +
                "     * 优惠券过期时间\n" +
                "     */\n" +
                "    private Date expireTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 创建时间/返券时间\n" +
                "     */\n" +
                "    private Date createTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 删除标记 is_valid 有效为1 无效为0\n" +
                "     */\n" +
                "    private Integer isValid;\n" +
                "\n" +
                "    /**\n" +
                "     * 备注\n" +
                "     */\n" +
                "    private String note;\n" +
                "\n" +
                "    /**\n" +
                "     * 活動名稱\n" +
                "     */\n" +
                "    private String strategyName;\n" +
                "\n" +
                "    /**\n" +
                "     * 充值账号\n" +
                "     */\n" +
                "    private String loginName;\n" +
                "\n" +
                "    /**\n" +
                "     * 返劵状态\n" +
                "     */\n" +
                "    private String statusName;";
    }
}
