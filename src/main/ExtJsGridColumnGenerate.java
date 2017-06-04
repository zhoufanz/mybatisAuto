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
                sb.append("},\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static String init(){
        String columns="                        //主键\n" +
                "                        {name:'id',type:'string'},\n" +
                "//奖励单号\n" +
                "                        {name:'prizeCode',type:'string'},\n" +
                "//奖励名称\n" +
                "                        {name:'prizeName',type:'string'},\n" +
                "//奖励状态（MM_P_ZCZ.暂存中,MM_P_YTJ.已提交)\n" +
                "                        {name:'prizeFlag',type:'string'},\n" +
                "//采购合计\n" +
                "                        {name:'jlPurchTotal',type:'string'},\n" +
                "//销售合计\n" +
                "                        {name:'jlProposeTotal',type:'string'},\n" +
                "//品类数量\n" +
                "                        {name:'categoryNumber',type:'string'},\n" +
                "//总数量\n" +
                "                        {name:'totalNumber',type:'string'},\n" +
                "//奖励部门数量\n" +
                "                        {name:'prizeSiteCodeCount',type:'string'},\n" +
                "//操作人(选择器)\n" +
                "                        {name:'inputUserCode',type:'string'},\n" +
                "//操作时间\n" +
                "                        {name:'inputTime',type:'string'},\n" +
                "//摘要\n" +
                "                        {name:'prizeRemark',type:'string'},\n" +
                "//创建人\n" +
                "                        {name:'createUserCode',type:'string'},\n" +
                "//创建时间\n" +
                "                        {name:'createTime',type:'string'},\n" +
                "//修改人\n" +
                "                        {name:'modifyUserCode',type:'string'},\n" +
                "//修改时间\n" +
                "                        {name:'modifyTime',type:'string'},\n" +
                "//修改人\n" +
                "                        {name:'modifyUserCodeName',type:'string'},\n" +
                "//创建人\n" +
                "                        {name:'createUserCodeName',type:'string'},\n" +
                "//操作人名称\n" +
                "                        {name:'inputUserCodeName',type:'string'},\n" +
                "//操作时间起\n" +
                "                        {name:'inputTimeStart',type:'string'},\n" +
                "//操作时间止\n" +
                "                        {name:'inputTimeEnd',type:'string'},\n" +
                "//奖励状态名称\n" +
                "                        {name:'prizeFlagName',type:'string'}";
        return columns;
    }
}
