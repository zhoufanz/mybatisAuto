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
    public static String init(){
        return "    /**\n" +
                "     * 自增主键id\n" +
                "     */\n" +
                "    private Integer id;\n" +
                "\n" +
                "    /**\n" +
                "     * 优惠策略名称\n" +
                "     */\n" +
                "    private String name;\n" +
                "\n" +
                "    /**\n" +
                "     * 状态 0:待审核，1:审核不通过，2:已撤销，3:审核通过，4:已失效\n" +
                "     */\n" +
                "    private Integer status;\n" +
                "\n" +
                "    /**\n" +
                "     * yyyy-dd-MM hh:mm:ss(活动开始时间)\n" +
                "     */\n" +
                "    private Date beginTime;\n" +
                "\n" +
                "    /**\n" +
                "     * yyyy-dd-MM hh:mm:ss(活动结束时间)\n" +
                "     */\n" +
                "    private Date endTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 优惠券过期时间\n" +
                "     */\n" +
                "    private Date expireTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 预算总额\n" +
                "     */\n" +
                "    private BigDecimal totalMoney;\n" +
                "\n" +
                "    /**\n" +
                "     * 已返总额\n" +
                "     */\n" +
                "    private BigDecimal returnMoney;\n" +
                "\n" +
                "    /**\n" +
                "     * 操作人id关联core_user表主键\n" +
                "     */\n" +
                "    private Integer createBy;\n" +
                "\n" +
                "    /**\n" +
                "     * yyyy-dd-MM hh:mm:ss(创建时间)\n" +
                "     */\n" +
                "    private Date createTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 审核人id关联core_user表主键\n" +
                "     */\n" +
                "    private Integer verifyBy;\n" +
                "\n" +
                "    /**\n" +
                "     * yyyy-dd-MM hh:mm:ss(审核时间)\n" +
                "     */\n" +
                "    private Date verifyTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 审核备注\n" +
                "     */\n" +
                "    private String remark;\n" +
                "\n" +
                "    /**\n" +
                "     * 删除标记 有效为1，无效为0\n" +
                "     */\n" +
                "    private Integer isValid;\n" +
                "\n" +
                "    /**\n" +
                "     * 备注\n" +
                "     */\n" +
                "    private String note;\n";
    }
}
