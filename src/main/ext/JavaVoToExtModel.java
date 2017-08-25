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
                    att = "{name:'" + att + "',type:'date',convert: dateConvert},";
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
                "     * 运单号\n" +
                "     */\n" +
                "    private String billNo;\n" +
                "\n" +
                "    /**\n" +
                "     * 录单人编号\n" +
                "     */\n" +
                "    private String recordEmployeeCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 发货网点\n" +
                "     */\n" +
                "    private String sendSiteCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 寄件日期\n" +
                "     */\n" +
                "    private Date accountTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 客户名称\n" +
                "     */\n" +
                "    private String customerCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 支付类型\n" +
                "     */\n" +
                "    private String payType;\n" +
                "\n" +
                "    /**\n" +
                "     * 签收：1签收 ，0 没有签收\n" +
                "     */\n" +
                "    private Short signFlag;\n" +
                "\n" +
                "    /**\n" +
                "     * 签收人\n" +
                "     */\n" +
                "    private String signEmployeeCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 签收日期\n" +
                "     */\n" +
                "    private Date signTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 签收网点编号\n" +
                "     */\n" +
                "    private String signSiteCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 业务员\n" +
                "     */\n" +
                "    private String salesEmployeeCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 取件员\n" +
                "     */\n" +
                "    private String takePartEmployeeCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 派件员\n" +
                "     */\n" +
                "    private String dispatchEmployeeCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 寄件人\n" +
                "     */\n" +
                "    private String sendUserCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 承运公司\n" +
                "     */\n" +
                "    private String carrierCompany;\n" +
                "\n" +
                "    /**\n" +
                "     * 预付款\n" +
                "     */\n" +
                "    private BigDecimal advancePayment;\n" +
                "\n" +
                "    /**\n" +
                "     * 返款\n" +
                "     */\n" +
                "    private BigDecimal rebates;\n" +
                "\n" +
                "    /**\n" +
                "     * 到付款\n" +
                "     */\n" +
                "    private BigDecimal payment;\n" +
                "\n" +
                "    /**\n" +
                "     * 总金额\n" +
                "     */\n" +
                "    private BigDecimal totalAmount;\n" +
                "\n" +
                "    /**\n" +
                "     * 派送时间\n" +
                "     */\n" +
                "    private Date dispatchTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 派送网点\n" +
                "     */\n" +
                "    private String dispatchSiteCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 产品类型\n" +
                "     */\n" +
                "    private String productCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 客户类型\n" +
                "     */\n" +
                "    private String customerType;\n" +
                "\n" +
                "    /**\n" +
                "     * 货物当前位置\n" +
                "     */\n" +
                "    private String goodsCurrentPosition;\n" +
                "\n" +
                "    /**\n" +
                "     * 货物当前位置分公司\n" +
                "     */\n" +
                "    private String goodsCurrentPositionBranch;\n" +
                "\n" +
                "    /**\n" +
                "     * 利润\n" +
                "     */\n" +
                "    private BigDecimal profits;\n" +
                "\n" +
                "    /**\n" +
                "     * 签收录入人\n" +
                "     */\n" +
                "    private String signInEmployeeCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 群人\n" +
                "     */\n" +
                "    private String groupUser;\n" +
                "\n" +
                "    /**\n" +
                "     * 创建时间\n" +
                "     */\n" +
                "    private Date createTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 备注\n" +
                "     */\n" +
                "    private String remark;\n" +
                "\n" +
                "    /**\n" +
                "     * 目的地\n" +
                "     */\n" +
                "    private String destination;\n" +
                "\n" +
                "    /**\n" +
                "     * j件数\n" +
                "     */\n" +
                "    private BigDecimal pieceNumber;\n" +
                "\n" +
                "    /**\n" +
                "     * 重量\n" +
                "     */\n" +
                "    private BigDecimal settlementWeight;\n" +
                "\n" +
                "    /**\n" +
                "     * 体积\n" +
                "     */\n" +
                "    private BigDecimal cube;\n" +
                "\n" +
                "    /**\n" +
                "     * 货物名称\n" +
                "     */\n" +
                "    private String goodsName;\n" +
                "\n" +
                "    /**\n" +
                "     * 基本费用\n" +
                "     */\n" +
                "    private BigDecimal freight;\n" +
                "\n" +
                "    /**\n" +
                "     * 保价费\n" +
                "     */\n" +
                "    private BigDecimal insurance;\n" +
                "\n" +
                "    /**\n" +
                "     * 综合服务费\n" +
                "     */\n" +
                "    private BigDecimal goodsPayment;\n" +
                "\n" +
                "    /**\n" +
                "     * 代收货款\n" +
                "     */\n" +
                "    private BigDecimal documentFee;\n" +
                "\n" +
                "    /**\n" +
                "     * 收货地址\n" +
                "     */\n" +
                "    private String takeGoodsAddress;\n";
    }
}
