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
        return "   items: [{\n" +
                "                                xtype: 'radio',\n" +
                "                                boxLabel: '账单号',\n" +
                "                                name: 'code',\n" +
                "                                inputValue: '0',\n" +
                "                                checked: true\n" +
                "                            }, {\n" +
                "                                xtype: 'textarea',\n" +
                "                                name: 'billCodeList',\n" +
                "                                height: 130,\n" +
                "                                width: 220\n" +
                "                            }]\n" +
                "                        }, {\n" +
                "                            xtype: 'fieldset',\n" +
                "                            title: '账单时间',\n" +
                "                            defaults: {\n" +
                "                                labelWidth: 80,\n" +
                "                                width: 300\n" +
                "                            },\n" +
                "                            items: [\n" +
                "                                {\n" +
                "                                    xtype: 'datetimefield_date97',\n" +
                "                                    name: 'beginDate',\n" +
                "                                    id: 'monthlyPairBillingStatement_beginDate',\n" +
                "                                    fieldLabel: '开始时间',\n" +
                "                                    format: 'Y-m-d H:i:s',\n" +
                "                                    dateConfig: {\n" +
                "                                        el: 'monthlyPairBillingStatement_beginDate-inputEl',\n" +
                "                                        dateFmt: 'yyyy-MM-dd HH:mi:ss'\n" +
                "                                    },\n" +
                "                                    editable: true,\n" +
                "                                    allowBlank: false,\n" +
                "                                    time: true,\n" +
                "                                    value: fosp.monthlyPairBillingStatement.formatDefaultDate(true, fosp.monthlyPairBillingStatement.FORMAT_TIME),\n" +
                "                                    dateRange: {\n" +
                "                                        begin: 'monthlyPairBillingStatement_beginDate',\n" +
                "                                        end: 'monthlyPairBillingStatement_endDate'\n" +
                "                                    },\n" +
                "                                    vtype: 'monthlyPairBillingStatement_dateRange'\n" +
                "                                }, {\n" +
                "                                    xtype: 'datetimefield_date97',\n" +
                "                                    id: 'monthlyPairBillingStatement_endDate',\n" +
                "                                    name: 'endDate',\n" +
                "                                    fieldLabel: '结束时间',\n" +
                "                                    format: 'Y-m-d H:i:s',\n" +
                "                                    dateConfig: {\n" +
                "                                        el: 'monthlyPairBillingStatement_endDate-inputEl',\n" +
                "                                        dateFmt: 'yyyy-MM-dd HH:mi:ss'\n" +
                "                                    },\n" +
                "                                    editable: true,\n" +
                "                                    allowBlank: false,\n" +
                "                                    time: true,\n" +
                "                                    value: fosp.monthlyPairBillingStatement.formatDefaultDate(false, fosp.monthlyPairBillingStatement.FORMAT_TIME),\n" +
                "                                    dateRange: {\n" +
                "                                        begin: 'monthlyPairBillingStatement_beginDate',\n" +
                "                                        end: 'monthlyPairBillingStatement_endDate'\n" +
                "                                    },\n" +
                "                                    vtype: 'monthlyPairBillingStatement_dateRange'\n" +
                "                                }]\n" +
                "                        }, {\n" +
                "                            xtype: 'fieldcontainer',\n" +
                "                            items: [{\n" +
                "                                xtype: 'commonSiteSelector',\n" +
                "                                name: 'sendCode',\n" +
                "                                fieldLabel: '所属站点'\n" +
                "                            }, {\n" +
                "                                xtype: \"commonCustomerSelector\",\n" +
                "                                name: 'customerCode',\n" +
                "                                fieldLabel: '客户编号'\n" +
                "                            }, {\n" +
                "                                xtype: 'textfield',\n" +
                "                                name: 'customerName',\n" +
                "                                fieldLabel: '客户名称'\n" +
                "                            }]\n" +
                "                        }, {\n" +
                "                            xtype: 'fieldcontainer',\n" +
                "                            items: [{\n" +
                "                                name: 'bizType',\n" +
                "                                fieldLabel: '状态',\n" +
                "                                labelWidth: 60,\n" +
                "                                xtype: \"dictcombo\",\n" +
                "                                dictType: 'BIZ_TYPE',\n" +
                "                                editable: false,\n" +
                "                                anyRecords: [{'valueCode': '', 'valueName': '全部'}],\n" +
                "                            }, {";
    }
}
