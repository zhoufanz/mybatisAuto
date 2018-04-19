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
                "//用户主键\n" +
                "{name:'userId',type:'string'},\n" +
                "//返券时用户城市ID\n" +
                "{name:'cityId',type:'string'},\n" +
                "//策略id\n" +
                "{name:'strategyId',type:'string'},\n" +
                "//云柜平台订单号\n" +
                "{name:'outTradeNo',type:'string'},\n" +
                "//返券类型  1 充值返券 2 客服人工返券\n" +
                "{name:'type',type:'string'},\n" +
                "//金额\n" +
                "{name:'money',type:'string'},\n" +
                "//已使用金额\n" +
                "{name:'usedMoney',type:'string'},\n" +
                "//优惠券过期时间\n" +
                "{name:'expireTime',type:'date',convert : function (value) {return Ext.Date.format (new Date (value), \"Y-m-d\")}},\n" +
                "//返券时间\n" +
                "{name:'createTime',type:'date',convert : function (value) {return Ext.Date.format (new Date (value), \"Y-m-d\")}},\n" +
                "//删除标记 is_valid 有效为1 无效为0\n" +
                "{name:'isValid',type:'string'},\n" +
                "//备注\n" +
                "{name:'note',type:'string'},\n" +
                "//活動名稱\n" +
                "{name:'strategyName',type:'string'},\n" +
                "//充值账号\n" +
                "{name:'loginName',type:'string'},\n" +
                "//返劵状态\n" +
                "{name:'statusName',type:'string'},";
    }
}
