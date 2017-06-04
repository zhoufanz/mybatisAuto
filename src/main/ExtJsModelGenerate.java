package main;


import java.text.MessageFormat;
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

            if(att.indexOf("Time")>=0){
                att = "{name:'" + att + "',type:'string',convert: dateConvert},";
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
        String vo = " /**\n" +
                "     * 主键\n" +
                "     */\n" +
                "    private String id;\n" +
                "\n" +
                "    /**\n" +
                "     * 申请单号\n" +
                "     */\n" +
                "    private String applicationCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 申请类型(MM_MDA.门店物料申请,MM_FGSA.分公司物料申请,MM_JL.物料奖励)\n" +
                "     */\n" +
                "    private String applicationType;\n" +
                "\n" +
                "    /**\n" +
                "     * 申请状态(MM_ZCZ.暂存中,MM_DFF.待发放,MM_YCX.已撤销,MM_YTH.已退回,MM_YTH.已退货,MM_YFH.已发放,MM_YQS.已签收)\n" +
                "     */\n" +
                "    private String applicationState;\n" +
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
                "     * 销售合计\n" +
                "     */\n" +
                "    private Double proposeTotal;\n" +
                "\n" +
                "    /**\n" +
                "     * 采购合计\n" +
                "     */\n" +
                "    private Double purchTotal;\n" +
                "\n" +
                "    /**\n" +
                "     * 申请网点（部门）\n" +
                "     */\n" +
                "    private String sqSiteCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 申请人(选择器)\n" +
                "     */\n" +
                "    private String sqUserCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 申请时间\n" +
                "     */\n" +
                "    private Date applicationTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 申请备注\n" +
                "     */\n" +
                "    private String applicationRemark;\n" +
                "\n" +
                "    /**\n" +
                "     * 撤销人\n" +
                "     */\n" +
                "    private String cancelUserCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 撤销时间\n" +
                "     */\n" +
                "    private Date cancelTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 撤销原因\n" +
                "     */\n" +
                "    private String cancelRemark;\n" +
                "\n" +
                "    /**\n" +
                "     * 退回人\n" +
                "     */\n" +
                "    private String backUserCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 退回时间\n" +
                "     */\n" +
                "    private Date backTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 退回原因\n" +
                "     */\n" +
                "    private String backRemark;\n" +
                "\n" +
                "    /**\n" +
                "     * 发放人\n" +
                "     */\n" +
                "    private String provideUserCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 发放时间\n" +
                "     */\n" +
                "    private Date provideTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 运单号\n" +
                "     */\n" +
                "    private String billNum;\n" +
                "\n" +
                "    /**\n" +
                "     * 是否含号段(0,否,1,是)\n" +
                "     */\n" +
                "    private Integer numFlag;\n" +
                "\n" +
                "    /**\n" +
                "     * 物流公司\n" +
                "     */\n" +
                "    private String logCompany;\n" +
                "\n" +
                "    /**\n" +
                "     * 录运单号人\n" +
                "     */\n" +
                "    private String billUserCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 录运单号时间\n" +
                "     */\n" +
                "    private Date billTime;\n" +
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
                "    /**\n" +
                "     * 申请类型名称(MM_MDA.门店物料申请,MM_FGSA.分公司物料申请,MM_JL.物料奖励)\n" +
                "     */\n" +
                "    private String applicationTypeName;\n" +
                "    /**\n" +
                "     * 申请状态名称(MM_ZCZ.暂存中,MM_DFF.待发放,MM_YCX.已撤销,MM_YTH.已退回,MM_YTH.已退货,MM_YFH.已发放,MM_YQS.已签收)\n" +
                "     */\n" +
                "    private String applicationStateName;\n" +
                "\n" +
                "    /**\n" +
                "     * 申请人(选择器)\n" +
                "     */\n" +
                "    private String sqUserCodeName;\n" +
                "    /**\n" +
                "     * 撤销人名称\n" +
                "     */\n" +
                "    private String cancelUserCodeName;\n" +
                "    /**\n" +
                "     * 退回人名称\n" +
                "     */\n" +
                "    private String backUserCodeName;\n" +
                "    /**\n" +
                "     * 发放人名称\n" +
                "     */\n" +
                "    private String provideUserCodeName;\n" +
                "    /**\n" +
                "     * 录运单号人名称\n" +
                "     */\n" +
                "    private String billUserCodeName;\n" +
                "    /**\n" +
                "     * 创建人名称\n" +
                "     */\n" +
                "    private String createUserCodeName;\n" +
                "    /**\n" +
                "     * 修改人名称\n" +
                "     */\n" +
                "    private String modifyUserCodeName;\n" +
                "    /**\n" +
                "     * 申请网点名称（部门）\n" +
                "     */\n" +
                "    private String sqSiteCodeName;\n" +
                "    /**\n" +
                "     * 申请时间开始\n" +
                "     */\n" +
                "    private Date applicationTimeStart;\n" +
                "    /**\n" +
                "     * 申请时间结束\n" +
                "     */\n" +
                "    private Date applicationTimeEnd;\n" +
                "    /**\n" +
                "     * 发放/出库时间开始\n" +
                "     */\n" +
                "    private Date provideTimeStart;\n" +
                "    /**\n" +
                "     * 发放/出库时间结束\n" +
                "     */\n" +
                "    private Date provideTimeEnd;";
        return vo;
    }
}
