package main.ext;

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
public class ModelFieldsToGridColumn {

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
                    sb.append(",renderer: Ext.util.Format.dateRenderer('Y-m-d H:i:s')");
                }else if (dataIndex.indexOf("Date")>=0){
                    sb.append(",renderer: Ext.util.Format.dateRenderer('Y-m-d H:i:s')");
                }
                sb.append("},\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static String init(){
        return "//审核iD\n" +
                "{name:'id',type:'string'},\n" +
                "//价格条目编码\n" +
                "{name:'priceItemCode',type:'string'},\n" +
                "//产品类型编码\n" +
                "{name:'productCode',type:'string'},\n" +
                "//产品类型编码名字\n" +
                "{name:'productCodeName',type:'string'},\n" +
                "//业务类型:(0：全部 1：汽运 2：特快件(航空)\n" +
                "{name:'bizType',type:'string'},\n" +
                "//业务类型:(0：全部 1：汽运 2：特快件(航空)名字\n" +
                "{name:'bizTypeName',type:'string'},\n" +
                "//货物属性 （0：普通件 1：易碎品 2：贵重物品）\n" +
                "{name:'goodsMode',type:'string'},\n" +
                "//货物属性 （0：普通件 1：易碎品 2：贵重物品）名字\n" +
                "{name:'goodsModeName',type:'string'},\n" +
                "//开始时间\n" +
                "{name:'startDate',type:'date',convert: dateConvert},\n" +
                "//结束时间\n" +
                "{name:'endDate',type:'date',convert: dateConvert},\n" +
                "//创建人\n" +
                "{name:'createUserCode',type:'string'},\n" +
                "//创建人名字\n" +
                "{name:'createUserCodeName',type:'string'},\n" +
                "//创建时间\n" +
                "{name:'createDate',type:'date',convert: dateConvert},\n" +
                "//修改人\n" +
                "{name:'modifyUserCode',type:'string'},\n" +
                "//修改人名字\n" +
                "{name:'modifyUserCodeName',type:'string'},\n" +
                "//修改时间\n" +
                "{name:'modifyDate',type:'date',convert: dateConvert},\n" +
                "//备注\n" +
                "{name:'remarks',type:'string'},\n" +
                "//报价分类主表外键ID\n" +
                "{name:'priceId',type:'string'},\n" +
                "//发货区域集合\n" +
                "{name:'addressSendCodeList',type:'string'},\n" +
                "//收货区域编码集合\n" +
                "{name:'addressEndCodeList',type:'string'},\n" +
                "//发货区域\n" +
                "{name:'addressSendCodeName',type:'string'},\n" +
                "//收货区域编码\n" +
                "{name:'addressEndCodeName',type:'string'},";
    }
}
