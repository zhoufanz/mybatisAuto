package util;



import java.io.*;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.FreeMakerUtil;
import util.StringUtil;

import static java.awt.SystemColor.info;


public class ContinueGenerate {

	//指定生成service,controller的模板路径
	private static String ftlPath="/ftl1_mysql_for_mybatis";
	
	//输出路径    第三方的的发生大幅度的十分反对反对
	private static String[] generateTargetPath=null;
	static{
		generateTargetPath=new String[]{
			"D:\\generate_mybatisXXXXXXXXXXXXX\\service\\",
			"D:\\generate_mybatisXXXXXXXXXXXXX\\service\\impl\\",
			"D:\\generate_mybatisXXXXXXXXXXXXX\\controller\\",
			"D:\\generate_mybatisXXXXXXXXXXXXX\\dao\\",
			"D:\\generate_mybatisXXXXXXXXXXXXX\\dao\\impl\\",
			"D:\\generate_mybatisXXXXXXXXXXXXX\\newEntityWithColumn\\",
			"D:\\generate_mybatisXXXXXXXXXXXXX\\vo\\",
			"D:\\generate_mybatisXXXXXXXXXXXXX\\oldEntityWithNoColumn\\"
		};
		for (int i = 0; i < generateTargetPath.length; i++) {
			File file=new File(generateTargetPath[i]);
			if (!file.exists()) {
				file.mkdirs();
			}
		}
	}
	
	//生成service接口的模板,包名,类后缀
	private static String[] serviceTemp={
		"service.ftl",
		"org.java.service",
		"Service"
	};
	//生成serviceImpl接口实现的模板,包名,类后缀
	private static String[] serviceImplTemp={
		"serviceImpl.ftl",
		"org.java.service.impl",
		"Service"
	};
	//生成controller控制类的模板,包名,类后缀
	private static String[] controllerTemp={
		"controller.ftl",
		"org.java.controller",
		"Controller"
	};
	private static String[] daoTemp={
			"dao.ftl",
			"org.java.dao",
			"Dao"
	};
	private static String[] daoImplTemp={
			"daoImpl.ftl",
			"org.java.dao.impl",
			"Dao"
	};
	
	private static FreeMakerUtil freeMakerUtil = new FreeMakerUtil();
	
	/**
	 * 
	 * @param templateName 模版名称
	 * @param packageName 包名
	 * @param entity 实体类名
	 * @param outFileFullPath 文件名(全路径)
	 */
	public static void create(String templateName,
			String packageName, String entity, String outFileFullPath) {
		
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("package", packageName);
		templateData.put("entity", entity);
		templateData.put("lowerentity", entity.substring(0,1).toLowerCase()+entity.substring(1));
		freeMakerUtil.generateFile(ftlPath, templateName, templateData, outFileFullPath);
	}
	
	//基于已经生成的实体类继续生成service,serviceImpl,和controller dao
	public static void continueGenerate(String entityPath) {
		List<String> models=StringUtil.getDirectoryClassNameListString(entityPath);
		for (String entity : models) {
			create(serviceTemp[0], serviceTemp[1], entity,generateTargetPath[0]+"I"+entity+serviceTemp[2]+".java");
			create(serviceImplTemp[0], serviceImplTemp[1], entity,generateTargetPath[1]+entity+serviceImplTemp[2]+".java");
			create(controllerTemp[0], controllerTemp[1], entity,generateTargetPath[2]+entity+controllerTemp[2]+".java");
			create(daoTemp[0], daoTemp[1], entity,generateTargetPath[3]+"I"+entity+daoTemp[2]+".java");
			create(daoImplTemp[0], daoImplTemp[1], entity,generateTargetPath[4]+"I"+entity+daoImplTemp[2]+".xml");
		}
	}
	//基于已经生成的实体类继续生成 newEntityWithColumn
	public static void continueGenerateNewEntity(String entityPath) {
		File directoryFile=new File(entityPath);
		try {
			File[] files=directoryFile.listFiles();
			for (int i = 0; i < files.length; i++) {
				try {
					String fileName = files[i].getName();

					//根据xml文件获取column
					String prePath = files[i].getPath().substring(0, files[i].getPath().indexOf("entity"));
					prePath = prePath + "dao\\" + fileName.substring(0, fileName.indexOf(".")) + "Mapper.xml";
					Map<String, String> map = getColumnMapWithXml(prePath);

					int index = fileName.lastIndexOf("Entity");
					if (index == -1) {
						throw new Exception("实体后缀必须为Entity");
					}

					//处理file
					File file = files[i];
					BufferedReader bre = new BufferedReader(new FileReader(file));

					StringBuilder sb = new StringBuilder();
					String line = null;
					while ((line = bre.readLine()) != null) {

						//字段列
						//从第二个空格截到;
						// private Short blLockFlag;
						if(line.indexOf("class")!=-1){
							String substring = file.getName().substring(0, file.getName().indexOf("."));

							String tableName="T"+StringUtil.camelToUnderline(substring).toUpperCase();
							int i2 = tableName.lastIndexOf("_");
							tableName = tableName.substring(0, i2);
							sb.append("@Table(value = \""+tableName+"\", dynamicInsert = true, dynamicUpdate = true)");

							String classLine=null;
							int i1 = line.indexOf("{");
							String s = line.substring(0, i1) + " implements Serializable {";
							sb.append("\n");
							sb.append(s);
							sb.append("\n");
							sb.append("\n");
							sb.append("    private static final long serialVersionUID = -8177101062986808601L;");
							sb.append("\n");
							sb.append("\n");
							continue;

						}

						if (line.indexOf("private ") != -1) {
							//空格数量
							int number = line.indexOf("private");

							String copyLine = new String(line);
							copyLine = copyLine.trim();
							String filed = null;
							try {
								filed = copyLine.substring(copyLine.indexOf(" ", "private ".length() + 2), copyLine.indexOf(";"));
							} catch (Exception ex) {
								System.out.println(line);
							}
							for (int j = 0; j < number; j++) {
								sb.append(" ");
							}
							String column = map.get(filed.trim());

							//根据xml文件获取column
							sb.append("@Column(" + column + ")" + "\n");
						}
						sb.append(line + "\n");
					}

					//生成新文件
					File newFile = new File(generateTargetPath[5] + "\\" + file.getName());
					newFile.createNewFile();

					FileWriter fileWriter = new FileWriter(newFile, true);
					fileWriter.write(sb.toString());

					fileWriter.flush();

					fileWriter.close();
					bre.close();

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static Map<String,String> getColumnMapWithXml(String path) throws IOException {
		File file = new File(path);
		BufferedReader bre = new BufferedReader(new FileReader(file));

		StringBuilder sb = new StringBuilder();
		String line = null;
		boolean flag=false;
		boolean first=true;
		Map<String, String> map = new HashMap<>();
		while ((line = bre.readLine()) != null) {
			if(line.indexOf("resultMap")!=-1){
				flag=true;
				if (first){
					first=false;
					continue;
				}else{
					break;
				}
			}
			if(line.indexOf("//resultMap")!=-1){
				flag=false;
				break;
			}
			if (flag){
				try {
					line = line.trim();
					int begin =line.indexOf("\"")+1;
					int end = line.indexOf("\"",begin);
					String value = line.substring(begin, end);

					line=line.substring(end+2+"property=".length()+1);
					String key = line.substring(0, line.indexOf("\""));
					map.put(key, "\""+value+"\"");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
		return map;
	}

	//基于已经生成的实体类继续生成 vo
	public static void continueGenerateVo(String entityPath) {
		File directoryFile=new File(entityPath);
		try {
			File[] files=directoryFile.listFiles();
			for (int i = 0; i < files.length; i++) {
				try {
					String fileName = files[i].getName();

					int index = fileName.lastIndexOf("Entity");
					if (index == -1) {
						throw new Exception("实体后缀必须为Entity");
					}

					//处理file
					File file = files[i];
					BufferedReader bre = new BufferedReader(new FileReader(file));

					StringBuilder sb = new StringBuilder();
					String line = null;
					while ((line = bre.readLine()) != null) {

						if(line.indexOf("class")!=-1){
							String classLine=null;
							int i1 = line.indexOf("{");
							String s = line.substring(0, i1) + " implements Serializable {";
							int entity = s.lastIndexOf("Entity");
							String s1 = s.substring(0, entity) + "Vo" + s.substring(entity + "Entity".length() + 1);
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
					String voFileName=null;
					int begin=file.getName().indexOf("Entity");
					voFileName = file.getName().substring(0,begin) + "Vo.java";
					File newFile = new File(generateTargetPath[6] + "\\" + voFileName);
					newFile.createNewFile();

					FileWriter fileWriter = new FileWriter(newFile, true);
					fileWriter.write(sb.toString());

					fileWriter.flush();

					fileWriter.close();
					bre.close();

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//基于已经生成的实体类继续生成 entity
	public static void continueGenerateEntity(String entityPath) {
		File directoryFile=new File(entityPath);
		try {
			File[] files=directoryFile.listFiles();
			for (int i = 0; i < files.length; i++) {
				try {
					String fileName = files[i].getName();

					int index = fileName.lastIndexOf("Entity");
					if (index == -1) {
						throw new Exception("实体后缀必须为Entity");
					}

					//处理file
					File file = files[i];
					BufferedReader bre = new BufferedReader(new FileReader(file));

					StringBuilder sb = new StringBuilder();
					String line = null;
					while ((line = bre.readLine()) != null) {
						if(line.indexOf("class")!=-1){
							String classLine=null;
							int i1 = line.indexOf("{");
							String s = line.substring(0, i1) + " implements Serializable {";
							sb.append("\n");
							sb.append(s);
							sb.append("\n");
							sb.append("\n");
							sb.append("    private static final long serialVersionUID = -8177101062986808601L;");
							sb.append("\n");
							sb.append("\n");
							continue;

						}
						sb.append(line + "\n");
					}

					File newFile = new File(generateTargetPath[7] + "\\" + file.getName());
					newFile.createNewFile();

					FileWriter fileWriter = new FileWriter(newFile, true);
					fileWriter.write(sb.toString());

					fileWriter.flush();

					fileWriter.close();
					bre.close();

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
