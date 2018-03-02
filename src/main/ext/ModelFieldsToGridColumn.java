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
        return "        //id\n" +
                "        {name:'id',type:'string'},\n" +
                "//网点编号\n" +
                "        {name:'siteCode',type:'string'},\n" +
                "//0否)\n" +
                "        {name:'blGould',type:'string'},\n" +
                "//纬度\n" +
                "        {name:'latitude',type:'string'},\n" +
                "//经度\n" +
                "        {name:'longitude',type:'string'},\n" +
                "//创建时间\n" +
                "        {name:'createTime',type:'date',convert: dateConvert},\n" +
                "//创建人编号\n" +
                "        {name:'createUserCode',type:'string'},\n" +
                "//创建人名称\n" +
                "        {name:'createUserName',type:'string'},\n" +
                "//修改时间\n" +
                "        {name:'modifyTime',type:'date',convert: dateConvert},\n" +
                "//修改人编号\n" +
                "        {name:'modifyUserCode',type:'string'},\n" +
                "//修改人名称\n" +
                "        {name:'modifyUserName',type:'string'},\n" +
                "//网点简称\n" +
                "        {name:'siteNameShort',type:'string'},\n" +
                "//网点类型\n" +
                "        {name:'siteKind',type:'string'}";
    }
}
