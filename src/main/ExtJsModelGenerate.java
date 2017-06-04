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
        String vo = "    /**\n" +
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
                "     * 物品批次号\n" +
                "     */\n" +
                "    private String batchNumber;\n" +
                "\n" +
                "    /**\n" +
                "     * 申领/奖励数量\n" +
                "     */\n" +
                "    private Integer applicationNumber;\n" +
                "\n" +
                "    /**\n" +
                "     * 销售合计\n" +
                "     */\n" +
                "    private Double sqdProposeTotal;\n" +
                "\n" +
                "    /**\n" +
                "     * 采购合计\n" +
                "     */\n" +
                "    private Double sqdPurchTotal;\n" +
                "\n" +
                "    /**\n" +
                "     * 详情备注\n" +
                "     */\n" +
                "    private String detailRemark;\n" +
                "\n" +
                "    /**\n" +
                "     * 库存信息\n" +
                "     */\n" +
                "    //科目编号\n" +
                "    private String projectCode;\n" +
                "\n" +
                "    //科目名称\n" +
                "    private String projectName;\n" +
                "\n" +
                "    //父节点CODE\n" +
                "    private String regionParent;\n" +
                "\n" +
                "    //等级（一级科目：FRIST,二级科目：SECOND,三级科目:THIRD,品类：CLASS）\n" +
                "    private String regionLevel;\n" +
                "\n" +
                "    //型号\n" +
                "    private String version;\n" +
                "\n" +
                "    //单位\n" +
                "    private String unit;\n" +
                "\n" +
                "    //图号\n" +
                "    private String picturenum;\n" +
                "\n" +
                "    //建议销售价格\n" +
                "    private Double proposeCost;\n" +
                "\n" +
                "    //供应商\n" +
                "    private String supplier;\n" +
                "\n" +
                "    //所属仓库\n" +
                "    private String subWareHouse;\n" +
                "\n" +
                "    //所属仓库名称\n" +
                "    private String subWareHouseName;\n" +
                "\n" +
                "    //库存数量\n" +
                "    private Integer stockNumber;\n" +
                "\n" +
                "    //可领数量\n" +
                "    private Integer canReceiveNumber;\n" +
                "\n" +
                "    //采购单价\n" +
                "    private Double purchPrice;\n" +
                "\n" +
                "    //进库日期\n" +
                "    private Date enterTime;\n" +
                "\n" +
                "    //有效日期\n" +
                "    private Date effectiveTime;\n" +
                "\n" +
                "    //失效日期\n" +
                "    private Date invalidTime;\n" +
                "\n" +
                "    //一级科目代码\n" +
                "    private String firstProjectCode;\n" +
                "\n" +
                "    //一级科目名称\n" +
                "    private String firstProjectName;\n" +
                "\n" +
                "    //二级科目代码\n" +
                "    private String secondProjectCode;\n" +
                "\n" +
                "    //二级科目名称\n" +
                "    private String secondProjectName;\n" +
                "\n" +
                "    //三级科目代码\n" +
                "    private String threeProjectCode;\n" +
                "\n" +
                "    //三级科目名称\n" +
                "    private String threeProjectName;\n" +
                "\n" +
                "    //备注\n" +
                "    private String remark;\n" +
                "\n" +
                "    //入库人\n" +
                "    private String createUserCode;\n" +
                "\n" +
                "    //入库人\n" +
                "    private String createUserCodeName;";
        return vo;
    }
}
