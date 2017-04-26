package util;



import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.FreeMakerUtil;
import util.StringUtil;


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
			"D:\\generate_mybatisXXXXXXXXXXXXX\\dao\\impl\\"
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
	
	//基于已经生成的实体类继续生成service,serviceImpl,和controller
	public static void continueGenerate(String entityPath) {
		List<String> models=StringUtil.getDirectoryClassNameListString(entityPath);
		for (String entity : models) {
			create(serviceTemp[0], serviceTemp[1], entity,generateTargetPath[0]+"I"+entity+serviceTemp[2]+".java");
			create(serviceImplTemp[0], serviceImplTemp[1], entity,generateTargetPath[1]+entity+serviceImplTemp[2]+".java");
			create(controllerTemp[0], controllerTemp[1], entity,generateTargetPath[2]+entity+controllerTemp[2]+".java");
			create(daoTemp[0], daoTemp[1], entity,generateTargetPath[3]+"I"+entity+daoTemp[2]+".java");
			create(daoImplTemp[0], daoImplTemp[1], entity,generateTargetPath[4]+entity+daoImplTemp[2]+".xml");
		}
	}
}
