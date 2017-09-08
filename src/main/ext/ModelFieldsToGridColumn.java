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
        return "//运单号\n" +
                "{name:'billNo',type:'string'},\n" +
                "//录单人编号\n" +
                "{name:'recordEmployeeCode',type:'string'},\n" +
                "//发货网点\n" +
                "{name:'sendSiteCode',type:'string'},\n" +
                "//寄件日期\n" +
                "{name:'accountTime',type:'date',convert: dateConvert},\n" +
                "//客户名称\n" +
                "{name:'customerCode',type:'string'},\n" +
                "//支付类型\n" +
                "{name:'payType',type:'string'},\n" +
                "//签收：1签收 ，0 没有签收\n" +
                "{name:'signFlag',type:'string'},\n" +
                "//签收人\n" +
                "{name:'signEmployeeCode',type:'string'},\n" +
                "//签收日期\n" +
                "{name:'signTime',type:'date',convert: dateConvert},\n" +
                "//签收网点编号\n" +
                "{name:'signSiteCode',type:'string'},\n" +
                "//业务员\n" +
                "{name:'salesEmployeeCode',type:'string'},\n" +
                "//取件员\n" +
                "{name:'takePartEmployeeCode',type:'string'},\n" +
                "//派件员\n" +
                "{name:'dispatchEmployeeCode',type:'string'},\n" +
                "//寄件人\n" +
                "{name:'sendUserCode',type:'string'},\n" +
                "//承运公司\n" +
                "{name:'carrierCompany',type:'string'},\n" +
                "//预付款\n" +
                "{name:'advancePayment',type:'string'},\n" +
                "//返款\n" +
                "{name:'rebates',type:'string'},\n" +
                "//到付款\n" +
                "{name:'payment',type:'string'},\n" +
                "//总金额\n" +
                "{name:'totalAmount',type:'string'},\n" +
                "//派送时间\n" +
                "{name:'dispatchTime',type:'date',convert: dateConvert},\n" +
                "//派送网点\n" +
                "{name:'dispatchSiteCode',type:'string'},\n" +
                "//产品类型\n" +
                "{name:'productCode',type:'string'},\n" +
                "//客户类型\n" +
                "{name:'customerType',type:'string'},\n" +
                "//货物当前位置\n" +
                "{name:'goodsCurrentPosition',type:'string'},\n" +
                "//货物当前位置分公司\n" +
                "{name:'goodsCurrentPositionBranch',type:'string'},\n" +
                "//利润\n" +
                "{name:'profits',type:'string'},\n" +
                "//签收录入人\n" +
                "{name:'signInEmployeeCode',type:'string'},\n" +
                "//群人\n" +
                "{name:'groupUser',type:'string'},\n" +
                "//创建时间\n" +
                "{name:'createTime',type:'date',convert: dateConvert},\n" +
                "//备注\n" +
                "{name:'remark',type:'string'},\n";
    }
}
