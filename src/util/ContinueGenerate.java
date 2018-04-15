package util;


import main.GeneratorSqlmap;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContinueGenerate {

    //指定生成service,controller的模板路径
    private static String ftlPath = "/ftl1_mysql_for_mybatis";
    private static boolean isQuery=false;

    //输出路径    第三方的的发生大幅度的十分反对反对
    private static String[] generateTargetPath = null;

    static {
        generateTargetPath = new String[]{
                "D:\\generate_mybatisXXXXXXXXXXXXX\\service\\",
                "D:\\generate_mybatisXXXXXXXXXXXXX\\service\\impl\\",
                "D:\\generate_mybatisXXXXXXXXXXXXX\\controller\\",
                "D:\\generate_mybatisXXXXXXXXXXXXX\\dto\\",
                "D:\\generate_mybatisXXXXXXXXXXXXX\\mapperJava\\",
                "D:\\generate_mybatisXXXXXXXXXXXXX\\mapperXml\\",
                "D:\\generate_mybatisXXXXXXXXXXXXX\\domain\\",
                "D:\\generate_mybatisXXXXXXXXXXXXX\\serviceTest\\"

        };
        for (int i = 0; i < generateTargetPath.length; i++) {
            File file = new File(generateTargetPath[i]);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    //生成service接口的模板,包名,类后缀
    private static String[] serviceTemp = {
            "service.ftl",
            "org.java.service",
            "Service"
    };
    //生成serviceImpl接口实现的模板,包名,类后缀
    private static String[] serviceImplTemp = {
            "serviceImpl.ftl",
            "org.java.service.impl",
            "ServiceImpl"
    };
    private static String[] serviceImplTempBase = {
            "serviceImplBase.ftl",
            "org.java.service.base.impl",
            "Service"
    };
    //生成controller控制类的模板,包名,类后缀
    private static String[] controllerTemp = {
            "controller.ftl",
            "org.java.controller",
            "Controller"
    };
    private static String[] daoTemp = {
            "dao.ftl",
            "org.java.dao",
            "Dao"
    };
    private static String[] daoImplTemp = {
            "daoImpl.ftl",
            "org.java.dao.impl",
            "Dao"
    };
    private static String[] serviceTestTemp = {
            "serviceImplTest.ftl",
            "org.java.dao",
            "ServiceImplTest"
    };

    private static FreeMakerUtil freeMakerUtil = new FreeMakerUtil();

    /**
     * @param templateName    模版名称
     * @param packageName     包名
     * @param entity          实体类名
     * @param outFileFullPath 文件名(全路径)
     */
    public static void create(String templateName,
                              String packageName, String entity, String outFileFullPath) {

        Map<String, Object> templateData = new HashMap<String, Object>();
        templateData.put("package", packageName);
        templateData.put("entity", entity);
        templateData.put("lowerentity", entity.substring(0, 1).toLowerCase() + entity.substring(1));
        freeMakerUtil.generateFile(ftlPath, templateName, templateData, outFileFullPath);
    }

    //基于已经生成的实体类继续生成service,serviceImpl,和controller dao
    public static void continueGenerate(String entityPath) {
        List<String> models = StringUtil.getDirectoryClassNameListString(entityPath);
        for (String entity : models) {
            if(GeneratorSqlmap.isQuery){
                create("query/service.ftl", serviceTemp[1], entity, generateTargetPath[0] + "" + entity + serviceTemp[2] + ".java");
                create("query/serviceImpl.ftl", serviceImplTemp[1], entity, generateTargetPath[1] + entity + serviceImplTemp[2] + ".java");
                create(controllerTemp[0], controllerTemp[1], entity, generateTargetPath[2] + entity + controllerTemp[2] + ".java");
                create("query/serviceImplTest.ftl", serviceTestTemp[1], entity, generateTargetPath[7] + "" + entity + serviceTestTemp[2] + ".java");
            }else {
                create(serviceTemp[0], serviceTemp[1], entity, generateTargetPath[0] + "" + entity + serviceTemp[2] + ".java");
                create(serviceImplTemp[0], serviceImplTemp[1], entity, generateTargetPath[1] + entity + serviceImplTemp[2] + ".java");
                create(controllerTemp[0], controllerTemp[1], entity, generateTargetPath[2] + entity + controllerTemp[2] + ".java");
                create(serviceTestTemp[0], serviceTestTemp[1], entity, generateTargetPath[7] + "" + entity + serviceTestTemp[2] + ".java");
//            create(daoImplTemp[0], daoImplTemp[1], entity, generateTargetPath[4] + "" + entity + daoImplTemp[2] + ".xml");
//            create(serviceImplTempBase[0], serviceImplTempBase[1], entity, generateTargetPath[8] + entity + serviceImplTempBase[2] + ".java");
            }

        }
    }

    //基于已经生成的实体类继续生成 newEntityWithColumn
    public static void continueGenerateNewMapperJava(String entityPath) {
        File directoryFile = new File(entityPath);
        try {
            File[] files = directoryFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                try {
                    String fileName = files[i].getName();

                    if(!fileName.contains(".java")){
                        continue;
                    }

                    File file = files[i];
                    BufferedReader bre = new BufferedReader(new FileReader(file));

                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    int ab=-1;
                    List<String> list = new ArrayList<>();
                    int lineCount=0;
                    while ((line = bre.readLine()) != null) {
                        if(line.indexOf("package ")!=-1){
                            continue;
                        }

                        if(GeneratorSqlmap.isQuery==false) {
                            if (line.contains("insert(") || line.contains("updateByPrimaryKey(") || line.contains("*")) {
                                continue;
                            }
                        }else{
                            if (line.contains("insert(")||line.contains("updateByPrimaryKey(")||line.contains("*")||line.contains("insertSelective")||line.contains("updateByPrimaryKeySelective")){
                                continue;
                            }
                            if (line.trim().length()==0) {
                                lineCount++;
                            }else{
                                lineCount=0;
                            }
                            if (lineCount==2){
                                lineCount=0;
                                continue;
                            }
                        }
                        list.add(line+"\n");
                    }
                    for (String s : list) {
                        sb.append(s);
                    }

                    //生成新文件
                    File newFile = new File(generateTargetPath[4] + "\\" + file.getName());
                    newFile.createNewFile();

                    FileWriter fileWriter = new FileWriter(newFile, true);
                    fileWriter.write(sb.toString());

                    fileWriter.flush();

                    fileWriter.close();
                    bre.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    //基于已经生成的实体类继续生成 vo
    public static void continueGenerateDTO(String entityPath) {
        File directoryFile = new File(entityPath);
        try {
            File[] files = directoryFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                try {
                    String fileName = files[i].getName();

                    int index = fileName.lastIndexOf("Entity");
                    if (index == -1) {
//                        throw new Exception("实体后缀必须为Entity");
                    }

                    //处理file
                    File file = files[i];
                    BufferedReader bre = new BufferedReader(new FileReader(file));

                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = bre.readLine()) != null) {
                        if(line.indexOf("package ")!=-1){
                            continue;
                        }

                        if (line.indexOf(" class ") != -1) {
                            sb.append(
                                    "import java.io.Serializable;\n\n");


                            String classLine = null;
                            int i1 = line.indexOf("{");
                            String s = line.substring(0, i1) + " implements Serializable {";
                            int entity = s.lastIndexOf("  implements");
                            String s1 = s.substring(0, entity) + "DTO" + " implements Serializable {";
                            sb.append("\n");
                            sb.append(s1);
                            sb.append("\n");
                            sb.append("\n");
                            sb.append("    private static final long serialVersionUID = -8177101062986808601L;");
                            sb.append("\n");
                            sb.append("\n");
                            continue;

                        }

                        sb.append(line + "\n");
                    }

                    //生成新文件
                    String voFileName = null;
                    int begin = file.getName().indexOf(".java");
                    voFileName = file.getName().substring(0, begin) + "DTO.java";
                    File newFile = new File(generateTargetPath[3] + "\\" + voFileName);
                    newFile.createNewFile();

                    FileWriter fileWriter = new FileWriter(newFile, true);
                    fileWriter.write(sb.toString());

                    fileWriter.flush();

                    fileWriter.close();
                    bre.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    //基于已经生成的实体类继续生成 vo
    public static void continueGenerateEntity(String entityPath) {
        File directoryFile = new File(entityPath);
        try {
            File[] files = directoryFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                try {
                    String fileName = files[i].getName();

                    int index = fileName.lastIndexOf("Entity");
                    if (index == -1) {
//                        throw new Exception("实体后缀必须为Entity");
                    }

                    //处理file
                    File file = files[i];
                    BufferedReader bre = new BufferedReader(new FileReader(file));

                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = bre.readLine()) != null) {

                        if(line.indexOf("package ")!=-1){
                            continue;
                        }

                        if (line.indexOf(" class ") != -1) {
                            sb.append(
                                    "import java.io.Serializable;\n\n");


                            String classLine = null;
                            int i1 = line.indexOf("{");
                            String s = line.substring(0, i1) + " implements Serializable {";
                            int entity = s.lastIndexOf("  implements");
                            String s1 = s.substring(0, entity) + "" + " implements Serializable {";
                            sb.append("\n");
                            sb.append(s1);
                            sb.append("\n");
                            sb.append("\n");
                            sb.append("    private static final long serialVersionUID = -8177101062986808601L;");
                            sb.append("\n");
                            sb.append("\n");
                            continue;

                        }

                        sb.append(line + "\n");
                    }

                    //生成新文件
                    String voFileName = null;
                    int begin = file.getName().indexOf(".java");
                    voFileName = file.getName().substring(0, begin) + ".java";
                    File newFile = new File(generateTargetPath[6] + "\\" + voFileName);
                    newFile.createNewFile();

                    FileWriter fileWriter = new FileWriter(newFile, true);
                    fileWriter.write(sb.toString());

                    fileWriter.flush();

                    fileWriter.close();
                    bre.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    //基于已经生成的实体类继续生成 entity
    public static void continueGenerateNewMapperXml(String entityPath) {
        File directoryFile = new File(entityPath);
        try {
            File[] files = directoryFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                try {
                    String fileName = files[i].getName();

                    if (!fileName.contains(".xml")) {
                        continue;


                    }
                    //处理file
                    File file = files[i];
                    BufferedReader bre = new BufferedReader(new FileReader(file));

                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    List<String> list = new ArrayList<>();
                    boolean flag=false;
                    boolean nextNotNeedN=true;
                    boolean isInsert=false;
                    boolean updateByPrimaryKey=false;
                    int updateCount=0;
                    int insertCount=0;
                    while ((line = bre.readLine()) != null) {

                        if (line.contains("<insert id=\"insert\"")) {
                            flag=true;
                            continue;
                        }
                        if (line.contains("</insert>")){
                            insertCount++;
                            flag = false;
                            if (insertCount == 1) {
                                continue;
                            }

                        }

                        if (line.contains("update id=\"updateByPrimaryKey\"")) {
                            flag=true;
                            continue;
                        }
                        if (line.contains("</update>")){
                            updateCount++;
                            flag = false;
                            if (updateCount==2){
                                continue;
                            }

                        }




                        if (!flag) {
                            if (line.contains("!= null\" >")) {
                                String key=null;
                                String beginStr = "<if test=\"";
                                int begin = line.indexOf(beginStr);
                                key= line.substring(begin + beginStr.length());

                                String endStr = " != null\" >";
                                int end = line.indexOf(endStr);
                                key = line.substring(begin+beginStr.length(), end);
                                String keyEnd=" and "+key+" !=''";
                                if(!line.contains("Time != null")&&!line.contains("Date != null")) {
                                    line = line.substring(0, line.indexOf("\" >")) + keyEnd + "\" >";
                                }

                            }

                            if (GeneratorSqlmap.isQuery){
                                if (line.contains("<insert id=\"insertSelective\"")){
                                    insertSelectiveStart=true;
                                    continue;
                                }
                                if(insertSelectiveStart&&line.contains("</insert>")){
                                    insertSelectiveStart=false;
                                    continue;
                                }
                                if(insertSelectiveStart){
                                    continue;
                                }

                                if (line.contains("<update id=\"updateByPrimaryKeySelective\"")){
                                    updateByPrimaryKeySelective=true;
                                    continue;
                                }
                                if(updateByPrimaryKeySelective&&line.contains("</update>")){
                                    updateByPrimaryKeySelective=false;
                                    continue;
                                }
                                if(updateByPrimaryKeySelective){
                                    continue;
                                }

                            }

                            if (line.contains("<if test")) {
                                sb.append(line);
                                nextNotNeedN=true;
                            } else if (nextNotNeedN == true) {
                                nextNotNeedN=false;
                                sb.append(line.trim());
                            }else if (line.contains("</if>")){
                                sb.append(line.trim() + "\n");
                            }else{
                                sb.append(line + "\n");
                            }
                        }

                    }

                    File newFile = new File(generateTargetPath[5] + "\\" + file.getName());
                    newFile.createNewFile();

                    FileWriter fileWriter = new FileWriter(newFile, true);
                    fileWriter.write(sb.toString());

                    fileWriter.flush();

                    fileWriter.close();
                    bre.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private static boolean insertSelectiveStart=false;
    private static boolean updateByPrimaryKeySelective=false;

}
