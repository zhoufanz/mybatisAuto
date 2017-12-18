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
        return "//主键ID\n" +
                "{name:'id',type:'string'},\n" +
                "//网点编号\n" +
                "{name:'siteCode',type:'string'},\n" +
                "//折扣值\n" +
                "{name:'discount',type:'string'},\n" +
                "//派件方式 （对应数据字典：FIN_ACCOUNT_LIST_PICK_GOODS_TYPE）\n" +
                "{name:'pickGoodsType',type:'string'}";
    }
}
