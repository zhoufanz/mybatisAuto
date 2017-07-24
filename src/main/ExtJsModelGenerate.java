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
        String vo = " /**\n" +
                "     * id\n" +
                "     */\n" +
                "    private String id;\n" +
                "\n" +
                "    /**\n" +
                "     * 折扣类型编码\n" +
                "     */\n" +
                "    private String discountCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 折扣类型编码\n" +
                "     */\n" +
                "    private String discountCodeName;\n" +
                "\n" +
                "    /**\n" +
                "     * 业务类型:(0：全部 1：汽运 2：特快件(航空) 业务类型:(0：全部 1：汽运 2：特快件(航空) 业务类型:(0：全部 1：汽运 2：特快件(航空)\n" +
                "     */\n" +
                "    private String bizType;\n" +
                "\n" +
                "    /**\n" +
                "     * 业务类型:(0：全部 1：汽运 2：特快件(航空) 业务类型:(0：全部 1：汽运 2：特快件(航空) 业务类型:(0：全部 1：汽运 2：特快件(航空)名字\n" +
                "     */\n" +
                "    private String bizTypeName;\n" +
                "\n" +
                "    /**\n" +
                "     * 产品类型 目前分（1.便利达、2.快运件、3.物流件、4.代收点业务、5.整车业务）\n" +
                "     */\n" +
                "    private String productType;\n" +
                "    /**\n" +
                "     * 产品类型 目前分（1.便利达、2.快运件、3.物流件、4.代收点业务、5.整车业务）名字\n" +
                "     */\n" +
                "    private String productTypeName;\n" +
                "\n" +
                "    /**\n" +
                "     * 派件方式（0：全部 1：自提 2:：派送）\n" +
                "     */\n" +
                "    private String pickGoodsType;\n" +
                "    /**\n" +
                "     * 派件方式（0：全部 1：自提 2:：派送）名字\n" +
                "     */\n" +
                "    private String pickGoodsTypeName;\n" +
                "\n" +
                "\n" +
                "    /**\n" +
                "     * 客户类型 目前分(1.零散客户、2.目标客户、3.项目客户、4.大客户、5.电商钻石会员、6.物流划分客户、7.电商普通会员、8.一次性整车、9.到达分理客户、10.物流交易客户、11.联合开发客户)\n" +
                "     */\n" +
                "    private String customerType;\n" +
                "\n" +
                "    /**\n" +
                "     * 客户类型 目前分(1.零散客户、2.目标客户、3.项目客户、4.大客户、5.电商钻石会员、6.物流划分客户、7.电商普通会员、8.一次性整车、9.到达分理客户、10.物流交易客户、11.联合开发客户)名字\n" +
                "     */\n" +
                "    private String customerTypeName;\n" +
                "    /**\n" +
                "     * 货物类型 目前分（1.电子配件、2.电商、3.机械、4.食品、5.纺织、6.建材、7.化工、8.家具、9.酒水、10.医药、11.电器、12.其它、13.办公用品、14.日用）\n" +
                "     */\n" +
                "    private String goodsType;\n" +
                "    /**\n" +
                "     * 货物类型 目前分（1.电子配件、2.电商、3.机械、4.食品、5.纺织、6.建材、7.化工、8.家具、9.酒水、10.医药、11.电器、12.其它、13.办公用品、14.日用）名字\n" +
                "     */\n" +
                "    private String goodsTypeName;\n" +
                "\n" +
                "    /**\n" +
                "     * 货物名称\n" +
                "     */\n" +
                "    private String goodsName;\n" +
                "\n" +
                "    /**\n" +
                "     * 支付方式（1：现金 2：到付 3：月结 4：返款到付 5：预付款 6：回单付）\n" +
                "     */\n" +
                "    private String paymentMethod;\n" +
                "    /**\n" +
                "     * 支付方式（1：现金 2：到付 3：月结 4：返款到付 5：预付款 6：回单付）名字\n" +
                "     */\n" +
                "    private String paymentMethodName;\n" +
                "\n" +
                "    /**\n" +
                "     * 开始重量\n" +
                "     */\n" +
                "    private Integer weightBegin;\n" +
                "\n" +
                "    /**\n" +
                "     * 结束重量\n" +
                "     */\n" +
                "    private Integer weightEng;\n" +
                "\n" +
                "    /**\n" +
                "     * 折扣值\n" +
                "     */\n" +
                "    private Double discountValue;\n" +
                "\n" +
                "    /**\n" +
                "     * 备注\n" +
                "     */\n" +
                "    private String remarks;\n" +
                "\n" +
                "    /**\n" +
                "     * 创建时间\n" +
                "     */\n" +
                "    private Date createDate;\n" +
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
                "     * 修改时间\n" +
                "     */\n" +
                "    private Date modifyDate;\n" +
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
                "     * 启用时间\n" +
                "     */\n" +
                "    private Date startDate;\n" +
                "\n" +
                "    /**\n" +
                "     * 截止时间\n" +
                "     */\n" +
                "    private Date endDate;\n" +
                "\n" +
                "    /**\n" +
                "     * 是否 1：启用 0:禁用\n" +
                "     */\n" +
                "    private Short blflag;\n" +
                "\n" +
                "\n" +
                "    /**\n" +
                "     * 活动分类主表外键ID\n" +
                "     */\n" +
                "    private String classificationId;";
        return vo;
    }
}
