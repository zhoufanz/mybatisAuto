package main;

/**
 * Created by zf11 on 2017-06-04.
 *
 * in
 *
 * //采购合计
 {name:'jlPurchTotal',type:'string'},
 //销售合计
 {name:'jlProposeTotal',type:'string'},
 //品类数量
 {name:'categoryNumber',type:'string'},

 out

 {
 text: '总数量',
 align: 'center',
 dataIndex: 'totalNumber'
 }, {
 text: '入库状态',
 dataIndex: 'storageStateName',
 align: 'center'
 },
 */
public class ExtJsGridColumnGenerate {

    public static void main(String[] args) {
        String[] columns=init().split("\n");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < columns.length; i++) {


            String line=columns[i];
            line=line.trim();

            if(i%2==0) {
                sb.append("{");

                String comment = line.substring(2);
                sb.append(" text: '"+comment+"',");
                sb.append("align: 'center',");
            }else{
                int begin = "name:'".length();
                int end = line.indexOf("'", begin + 1);
                String dataIndex = line.substring(begin+1, end);

                sb.append("dataIndex: '"+dataIndex+"'");
                if (dataIndex.indexOf("Time")>=0){
                    sb.append(",renderer: Ext.util.Format.dateRenderer('Y-m-d')");
                }
                sb.append("},\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static String init(){
        String columns="//主键\n" +
                "{name:'id',type:'string'},\n" +
                "//申请单号\n" +
                "{name:'applicationCode',type:'string'},\n" +
                "//物品批次号\n" +
                "{name:'batchNumber',type:'string'},\n" +
                "//奖励数量\n" +
                "{name:'applicationNumber',type:'string'},\n" +
                "//销售合计\n" +
                "{name:'sqdProposeTotal',type:'string'},\n" +
                "//采购合计\n" +
                "{name:'sqdPurchTotal',type:'string'},\n" +
                "//详情备注\n" +
                "{name:'detailRemark',type:'string'},\n" +
                "//库存信息\n" +
                "{name:'projectCode',type:'string'},\n" +
                "//科目名称\n" +
                "{name:'projectName',type:'string'},\n" +
                "//父节点CODE\n" +
                "{name:'regionParent',type:'string'},\n" +
                "//等级（一级科目：FRIST,二级科目：SECOND,三级科目:THIRD,品类：CLASS）\n" +
                "{name:'regionLevel',type:'string'},\n" +
                "//型号\n" +
                "{name:'version',type:'string'},\n" +
                "//单位\n" +
                "{name:'unit',type:'string'},\n" +
                "//图号\n" +
                "{name:'picturenum',type:'string'},\n" +
                "//建议销售价格\n" +
                "{name:'proposeCost',type:'string'},\n" +
                "//供应商\n" +
                "{name:'supplier',type:'string'},\n" +
                "//所属仓库\n" +
                "{name:'subWareHouse',type:'string'},\n" +
                "//所属仓库名称\n" +
                "{name:'subWareHouseName',type:'string'},\n" +
                "//库存数量\n" +
                "{name:'stockNumber',type:'string'},\n" +
                "//可领数量\n" +
                "{name:'canReceiveNumber',type:'string'},\n" +
                "//采购单价\n" +
                "{name:'purchPrice',type:'string'},\n" +
                "//进库日期\n" +
                "{name:'enterTime',type:'date',convert: dateConvert},\n" +
                "//有效日期\n" +
                "{name:'effectiveTime',type:'date',convert: dateConvert},\n" +
                "//失效日期\n" +
                "{name:'invalidTime',type:'date',convert: dateConvert},\n" +
                "//一级科目代码\n" +
                "{name:'firstProjectCode',type:'string'},\n" +
                "//一级科目名称\n" +
                "{name:'firstProjectName',type:'string'},\n" +
                "//二级科目代码\n" +
                "{name:'secondProjectCode',type:'string'},\n" +
                "//二级科目名称\n" +
                "{name:'secondProjectName',type:'string'},\n" +
                "//三级科目代码\n" +
                "{name:'threeProjectCode',type:'string'},\n" +
                "//三级科目名称\n" +
                "{name:'threeProjectName',type:'string'},\n" +
                "//备注\n" +
                "{name:'remark',type:'string'},\n" +
                "//入库人\n" +
                "{name:'createUserCode',type:'string'},\n" +
                "//入库人\n" +
                "{name:'createUserCodeName',type:'string'},";
        return columns;
    }
}
