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
                }else if (dataIndex.indexOf("Date")>=0){
                    sb.append(",renderer: Ext.util.Format.dateRenderer('Y-m-d')");
                }
                sb.append("},\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static String init(){
        String columns="//id\n" +
                "{name:'id',type:'string'},\n" +
                "//折扣类型编码\n" +
                "{name:'discountCode',type:'string'},\n" +
                "//折扣类型编码\n" +
                "{name:'discountCodeName',type:'string'},\n" +
                "//业务类型:(0：全部 1：汽运 2：特快件(航空) 业务类型:(0：全部 1：汽运 2：特快件(航空) 业务类型:(0：全部 1：汽运 2：特快件(航空)\n" +
                "{name:'bizType',type:'string'},\n" +
                "//业务类型:(0：全部 1：汽运 2：特快件(航空) 业务类型:(0：全部 1：汽运 2：特快件(航空) 业务类型:(0：全部 1：汽运 2：特快件(航空)名字\n" +
                "{name:'bizTypeName',type:'string'},\n" +
                "//产品类型 目前分（1.便利达、2.快运件、3.物流件、4.代收点业务、5.整车业务）\n" +
                "{name:'productType',type:'string'},\n" +
                "//产品类型 目前分（1.便利达、2.快运件、3.物流件、4.代收点业务、5.整车业务）名字\n" +
                "{name:'productTypeName',type:'string'},\n" +
                "//派件方式（0：全部 1：自提 2:：派送）\n" +
                "{name:'pickGoodsType',type:'string'},\n" +
                "//派件方式（0：全部 1：自提 2:：派送）名字\n" +
                "{name:'pickGoodsTypeName',type:'string'},\n" +
                "//客户类型 目前分(1.零散客户、2.目标客户、3.项目客户、4.大客户、5.电商钻石会员、6.物流划分客户、7.电商普通会员、8.一次性整车、9.到达分理客户、10.物流交易客户、11.联合开发客户)\n" +
                "{name:'customerType',type:'string'},\n" +
                "//客户类型 目前分(1.零散客户、2.目标客户、3.项目客户、4.大客户、5.电商钻石会员、6.物流划分客户、7.电商普通会员、8.一次性整车、9.到达分理客户、10.物流交易客户、11.联合开发客户)名字\n" +
                "{name:'customerTypeName',type:'string'},\n" +
                "//货物类型 目前分（1.电子配件、2.电商、3.机械、4.食品、5.纺织、6.建材、7.化工、8.家具、9.酒水、10.医药、11.电器、12.其它、13.办公用品、14.日用）\n" +
                "{name:'goodsType',type:'string'},\n" +
                "//货物类型 目前分（1.电子配件、2.电商、3.机械、4.食品、5.纺织、6.建材、7.化工、8.家具、9.酒水、10.医药、11.电器、12.其它、13.办公用品、14.日用）名字\n" +
                "{name:'goodsTypeName',type:'string'},\n" +
                "//货物名称\n" +
                "{name:'goodsName',type:'string'},\n" +
                "//支付方式（1：现金 2：到付 3：月结 4：返款到付 5：预付款 6：回单付）\n" +
                "{name:'paymentMethod',type:'string'},\n" +
                "//支付方式（1：现金 2：到付 3：月结 4：返款到付 5：预付款 6：回单付）名字\n" +
                "{name:'paymentMethodName',type:'string'},\n" +
                "//开始重量\n" +
                "{name:'weightBegin',type:'string'},\n" +
                "//结束重量\n" +
                "{name:'weightEng',type:'string'},\n" +
                "//折扣值\n" +
                "{name:'discountValue',type:'string'},\n" +
                "//备注\n" +
                "{name:'remarks',type:'string'},\n" +
                "//创建时间\n" +
                "{name:'createDate',type:'string'},\n" +
                "//创建人\n" +
                "{name:'createUserCode',type:'string'},\n" +
                "//创建人名字\n" +
                "{name:'createUserCodeName',type:'string'},\n" +
                "//修改时间\n" +
                "{name:'modifyDate',type:'string'},\n" +
                "//修改人\n" +
                "{name:'modifyUserCode',type:'string'},\n" +
                "//修改人名字\n" +
                "{name:'modifyUserCodeName',type:'string'},\n" +
                "//启用时间\n" +
                "{name:'startDate',type:'string'},\n" +
                "//截止时间\n" +
                "{name:'endDate',type:'string'},\n" +
                "//是否 1：启用 0:禁用\n" +
                "{name:'blflag',type:'string'},\n" +
                "//活动分类主表外键ID\n" +
                "{name:'classificationId',type:'string'},";
        return columns;
    }
}
