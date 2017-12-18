package main.ext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf11 on 2017-06-04.
 * 入
 *        {
 name: 'prizeName',
 fieldLabel: '奖励名称',
 readOnly: true
 }, {
 name: 'prizeCode',
 fieldLabel: '奖励单号',
 readOnly: true
 }
 *
 * 出
 *   var p_prizeName = queryForm.getForm().findField('prizeName').getValue();
 var p_prizeCode = queryForm.getForm().findField('prizeCode').getValue();
 var p_inputUserCode = queryForm.getForm().findField('inputUserCode').getValue();
 var p_prizeFlag = queryForm.getForm().findField('prizeFlag').getValue();
 var p_inputTimeStart = queryForm.getForm().findField('inputTimeStart').getValue();
 var p_inputTimeEnd = queryForm.getForm().findField('inputTimeEnd').getValue();
 Ext.apply(operation, {
 params: {
 'q_str_firstProjectCode': p_prizeName,
 'q_str_secondProjectCode': p_prizeCode,
 'q_str_threeProjectCode': p_inputUserCode,
 'q_str_projectCode': p_projectCodeClass,
 'q_str_projectName': p_projectName,
 'q_str_subWareHouse': p_subWareHouse
 }
 });
 */
public class FormItemsToStoreParams{

    public static void main(String[] args) {
        String items=init();

        items = items.trim();
        String[] split = items.split("\n");

        List<String> params = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String line=split[i];
            line = line.trim();

            if (line.indexOf("name")>=0){

                int begin=line.indexOf("'");
                int end = line.indexOf("'", begin+1);
                String name = line.substring(begin+1, end);

                params.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String param:params){
            sb.append("var p_" + param + " = queryForm.getForm().findField('" + param + "').getValue();\n");
        }
        sb.append("Ext.apply(operation, {\n");
        sb.append("    params: {\n");

        for(String param:params){
            sb.append("    'q_str_"+param+"': p_"+param+",\n");
        }

        sb.append("    }\n");
        sb.append("});\n");
        System.out.println(sb.toString());

    }
    public static String init(){
        return " {\n" +
                "                                name: 'id',\n" +
                "                                fieldLabel: 'id'\n" +
                "                            },\n" +
                "                            {\n" +
                "                                xtype : \"commonSiteSelector\",\n" +
                "                                name : 'q_str_sendSiteCode',\n" +
                "                                columnWidth:0.2,\n" +
                "                                allowBlank: false,\n" +
                "                                fieldLabel : '网点编号'\n" +
                "                            },\n" +
                "                            {\n" +
                "                                xtype: 'dictcombo',\n" +
                "                                name: 'pickGoodsType',\n" +
                "                                dictType: 'FIN_ACCOUNT_LIST_PICK_GOODS_TYPE',\n" +
                "                                fieldLabel: '派件方式',\n" +
                "                                allowBlank: true,\n" +
                "                                editable: false,\n" +
                "                                anyRecords:[{'valueCode':'','valueName':'全部'}],\n" +
                "                                validateOnBlur: true\n" +
                "                            }";
    }
}
