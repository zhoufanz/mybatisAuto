package main.ext;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by zf11 on 2017-06-04.
 * 入
 *  /**
 *  修改时间
 *
 private Date modifyTime;

 //修改人
 private String modifyUserCodeName;

 出
 //修改时间
 {name:'modifyTime',type:'string'},
 //修改人
 {name:'modifyUserCodeName',type:'string'},
 *
 *
 */
public class JavaVoToExtModel {
    public static void main(String[] args) {
        String vo = init();

        String[] lines = vo.split(";");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            String line= lines[i].trim();
            if(line==null||line.equals("")){
                continue;
            }

            try{
                int begin=line.indexOf("*",3);
                int end = line.indexOf("\n", begin);
                String comment = line.substring(begin+1,end);

                comment=comment.trim();

                int idx=comment.indexOf("/");
                while(idx>=0){
                    comment = comment.substring(idx + 1);
                    idx=comment.indexOf("/");
                }
                comment = "//" + comment;

                String att=line.substring(line.indexOf("private"));
                String[] split = att.split(" ");
                att = split[2].trim();

                if(att.indexOf("Time")>=0||att.indexOf("Date")>=0){
                    att = "{name:'" + att + "',type:'date',convert: dateConvert},";
                }else {
                    att = "{name:'" + att + "',type:'string'},";
                }

                list.add(comment);
                list.add(att);
            }catch(Exception ex){
                System.err.println("异常 "+line);
            }
        }
        for(String s:list){
            System.out.println(s);
        }
    }
    public static String init(){
        return "/**\n" +
                "     * 主键ID\n" +
                "     */\n" +
                "    private String id;\n" +
                "\n" +
                "    /**\n" +
                "     * 网点编号\n" +
                "     */\n" +
                "    private String siteCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 折扣值\n" +
                "     */\n" +
                "    private BigDecimal discount;\n" +
                "\n" +
                "    /**\n" +
                "     * 派件方式 （对应数据字典：FIN_ACCOUNT_LIST_PICK_GOODS_TYPE）\n" +
                "     */\n" +
                "    private String pickGoodsType;";
    }
}
