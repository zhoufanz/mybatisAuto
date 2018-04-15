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
        return "//自增主键id\n" +
                "{name:'id',type:'string'},\n" +
                "//优惠策略名称\n" +
                "{name:'name',type:'string'},\n" +
                "//状态 0:待审核，1:审核不通过，2:已撤销，3:审核通过，4:已失效\n" +
                "{name:'status',type:'string'},\n" +
                "//yyyy-dd-MM hh:mm:ss(活动开始时间)\n" +
                "{name:'beginTime',type:'date',convert: dateConvert},\n" +
                "//yyyy-dd-MM hh:mm:ss(活动结束时间)\n" +
                "{name:'endTime',type:'date',convert: dateConvert},\n" +
                "//优惠券过期时间\n" +
                "{name:'expireTime',type:'date',convert: dateConvert},\n" +
                "//预算总额\n" +
                "{name:'totalMoney',type:'string'},\n" +
                "//已返总额\n" +
                "{name:'returnMoney',type:'string'},\n" +
                "//操作人id关联core_user表主键\n" +
                "{name:'createBy',type:'string'},\n" +
                "//yyyy-dd-MM hh:mm:ss(创建时间)\n" +
                "{name:'createTime',type:'date',convert: dateConvert},\n" +
                "//审核人id关联core_user表主键\n" +
                "{name:'verifyBy',type:'string'},\n" +
                "//yyyy-dd-MM hh:mm:ss(审核时间)\n" +
                "{name:'verifyTime',type:'date',convert: dateConvert},\n" +
                "//审核备注\n" +
                "{name:'remark',type:'string'},\n" +
                "//删除标记 有效为1，无效为0\n" +
                "{name:'isValid',type:'string'},\n" +
                "//备注\n" +
                "{name:'note',type:'string'},";
    }
}
