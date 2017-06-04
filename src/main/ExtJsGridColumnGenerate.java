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
                "//申请类型(MM_MDA.门店物料申请,MM_FGSA.分公司物料申请,MM_JL.物料奖励)\n" +
                "{name:'applicationType',type:'string'},\n" +
                "//申请状态(MM_ZCZ.暂存中,MM_DFF.待发放,MM_YCX.已撤销,MM_YTH.已退回,MM_YTH.已退货,MM_YFH.已发放,MM_YQS.已签收)\n" +
                "{name:'applicationState',type:'string'},\n" +
                "//品类数量\n" +
                "{name:'categoryNumber',type:'string'},\n" +
                "//总数量\n" +
                "{name:'totalNumber',type:'string'},\n" +
                "//销售合计\n" +
                "{name:'proposeTotal',type:'string'},\n" +
                "//采购合计\n" +
                "{name:'purchTotal',type:'string'},\n" +
                "//申请网点（部门）\n" +
                "{name:'sqSiteCode',type:'string'},\n" +
                "//申请人(选择器)\n" +
                "{name:'sqUserCode',type:'string'},\n" +
                "//申请时间\n" +
                "{name:'applicationTime',type:'string',convert: dateConvert},\n" +
                "//申请备注\n" +
                "{name:'applicationRemark',type:'string'},\n" +
                "//撤销人\n" +
                "{name:'cancelUserCode',type:'string'},\n" +
                "//撤销时间\n" +
                "{name:'cancelTime',type:'string',convert: dateConvert},\n" +
                "//撤销原因\n" +
                "{name:'cancelRemark',type:'string'},\n" +
                "//退回人\n" +
                "{name:'backUserCode',type:'string'},\n" +
                "//退回时间\n" +
                "{name:'backTime',type:'string',convert: dateConvert},\n" +
                "//退回原因\n" +
                "{name:'backRemark',type:'string'},\n" +
                "//发放人\n" +
                "{name:'provideUserCode',type:'string'},\n" +
                "//发放时间\n" +
                "{name:'provideTime',type:'string',convert: dateConvert},\n" +
                "//运单号\n" +
                "{name:'billNum',type:'string'},\n" +
                "//是否含号段(0,否,1,是)\n" +
                "{name:'numFlag',type:'string'},\n" +
                "//物流公司\n" +
                "{name:'logCompany',type:'string'},\n" +
                "//录运单号人\n" +
                "{name:'billUserCode',type:'string'},\n" +
                "//录运单号时间\n" +
                "{name:'billTime',type:'string',convert: dateConvert},\n" +
                "//创建人\n" +
                "{name:'createUserCode',type:'string'},\n" +
                "//创建时间\n" +
                "{name:'createTime',type:'string',convert: dateConvert},\n" +
                "//修改人\n" +
                "{name:'modifyUserCode',type:'string'},\n" +
                "//修改时间\n" +
                "{name:'modifyTime',type:'string',convert: dateConvert},\n" +
                "//申请类型名称(MM_MDA.门店物料申请,MM_FGSA.分公司物料申请,MM_JL.物料奖励)\n" +
                "{name:'applicationTypeName',type:'string'},\n" +
                "//申请状态名称(MM_ZCZ.暂存中,MM_DFF.待发放,MM_YCX.已撤销,MM_YTH.已退回,MM_YTH.已退货,MM_YFH.已发放,MM_YQS.已签收)\n" +
                "{name:'applicationStateName',type:'string'},\n" +
                "//申请人(选择器)\n" +
                "{name:'sqUserCodeName',type:'string'},\n" +
                "//撤销人名称\n" +
                "{name:'cancelUserCodeName',type:'string'},\n" +
                "//退回人名称\n" +
                "{name:'backUserCodeName',type:'string'},\n" +
                "//发放人名称\n" +
                "{name:'provideUserCodeName',type:'string'},\n" +
                "//录运单号人名称\n" +
                "{name:'billUserCodeName',type:'string'},\n" +
                "//创建人名称\n" +
                "{name:'createUserCodeName',type:'string'},\n" +
                "//修改人名称\n" +
                "{name:'modifyUserCodeName',type:'string'},\n" +
                "//申请网点名称（部门）\n" +
                "{name:'sqSiteCodeName',type:'string'},\n" +
                "//申请时间开始\n" +
                "{name:'applicationTimeStart',type:'string',convert: dateConvert},\n" +
                "//申请时间结束\n" +
                "{name:'applicationTimeEnd',type:'string',convert: dateConvert},\n" +
                "//出库时间开始\n" +
                "{name:'provideTimeStart',type:'string',convert: dateConvert},\n" +
                "//出库时间结束\n" +
                "{name:'provideTimeEnd',type:'string',convert: dateConvert},";
        return columns;
    }
}
