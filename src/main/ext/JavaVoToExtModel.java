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
                "     * id\n" +
                "     */\n" +
                "    @Id\n" +
                "\t@Column(\"ID\")\n" +
                "    private String id;\n" +
                "\n" +
                "    /**\n" +
                "     * 网点编号\n" +
                "     */\n" +
                "    @Column(\"SITE_CODE\")\n" +
                "    private String siteCode;\n" +
                "\n" +
                "    /**\n" +
                "     * 是否高德打点(1是/0否)\n" +
                "     */\n" +
                "    @Column(\"BL_GOULD\")\n" +
                "    private Integer blGould;\n" +
                "\n" +
                "    /**\n" +
                "     * 纬度\n" +
                "     */\n" +
                "    @Column(\"LATITUDE\")\n" +
                "    private String latitude;\n" +
                "\n" +
                "    /**\n" +
                "     * 经度\n" +
                "     */\n" +
                "    @Column(\"LONGITUDE\")\n" +
                "    private String longitude;\n" +
                "\n" +
                "    /**\n" +
                "     * 创建时间\n" +
                "     */\n" +
                "    @Column(\"CREATE_TIME\")\n" +
                "    private Date createTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 创建人编号\n" +
                "     */\n" +
                "    @Column(\"CREATE_USER_CODE\")\n" +
                "    private String createUserCode;\n" +
                "    /**\n" +
                "     * 创建人名称\n" +
                "     */\n" +
                "    @Column(\"CREATE_USER_NAME\")\n" +
                "    private String createUserName;\n" +
                "\n" +
                "    /**\n" +
                "     * 修改时间\n" +
                "     */\n" +
                "    @Column(\"MODIFY_TIME\")\n" +
                "    private Date modifyTime;\n" +
                "\n" +
                "    /**\n" +
                "     * 修改人编号\n" +
                "     */\n" +
                "    @Column(\"MODIFY_USER_CODE\")\n" +
                "    private String modifyUserCode;\n" +
                "    /**\n" +
                "     * 修改人名称\n" +
                "     */\n" +
                "    @Column(\"MODIFY_USER_NAME\")\n" +
                "    private String modifyUserName;\n" +
                "    /**\n" +
                "     * 网点简称\n" +
                "     */\n" +
                "    private String siteNameShort;\n" +
                "    /**\n" +
                "     * 网点类型\n" +
                "     */\n" +
                "    private Integer siteKind;";
    }
}
