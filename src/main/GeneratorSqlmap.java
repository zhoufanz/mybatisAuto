package main;

import org.apache.commons.io.FileUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import util.ContinueGenerate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {

	/**
	 * 第一步生成的文件路径
	 */
	private static final String FIRST_COMPLITE_CODE_PATH ="/src/com/zf/";

	/**
	 * 第一步生成的entity的绝对路径
	 */
	private static final String FIRST_COMPLITE_CODE_ENTITY_PATH =
			new File(System.getProperty("user.dir"), FIRST_COMPLITE_CODE_PATH + "domain").getAbsolutePath();

	/**
	 * 第一步生成的mapper的绝对路径
	 */
	private static final String FIRST_COMPLITE_CODE_MAPPER_PATH =
			new File(System.getProperty("user.dir"), FIRST_COMPLITE_CODE_PATH + "dao").getAbsolutePath();

	/**
	 * 主配置文件路径
	 */
	private static final String GENERATOR_CONFIG_XML_PATH = "generatorConfig.xml";

	/**
	 * 第二步使用的文件模板主路径
	 */
	public static String SECOND_FTL_PARENT_PATH = "/ftl1_mysql_for_mybatis";

	/**
	 * 第二步是否只生成查询文件
	 */
	public static boolean SECOND_IS_QUERY=false;

	//第二步输出父路径
	public static String SECOND_GENERATE_TARGET_PARENT_PATH = "D:\\generate_mybatisXXXXXXXXXXXXX\\";
	public static String[] SECOND_GENERATE_TARGET_PATH = null;

	static {
		SECOND_GENERATE_TARGET_PATH = new String[]{
				SECOND_GENERATE_TARGET_PARENT_PATH+"service"+"\\",
				SECOND_GENERATE_TARGET_PARENT_PATH+"service\\impl"+"\\",
				SECOND_GENERATE_TARGET_PARENT_PATH+"controller"+"\\",
				SECOND_GENERATE_TARGET_PARENT_PATH+"dto"+"\\",
				SECOND_GENERATE_TARGET_PARENT_PATH+"mapperJava"+"\\",
				SECOND_GENERATE_TARGET_PARENT_PATH+"mapperXml"+"\\",
				SECOND_GENERATE_TARGET_PARENT_PATH+"domain"+"\\",
				SECOND_GENERATE_TARGET_PARENT_PATH+"serviceTest"+"\\"
		};
		//不存在 则新建文件夹
		for (String path : SECOND_GENERATE_TARGET_PATH) {
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
		}
		//清空文件夹
		for (String path : SECOND_GENERATE_TARGET_PATH) {
			File file = new File(path);
			File[] files = file.listFiles();
			if (files == null || files.length == 0) {
				continue;
			}
			for (File f : files) {
				if (f.isDirectory()) {
					continue;
				}
				f.delete();
			}
		}
	}

	//生成
	public void generator() throws Exception {
		//错误信息
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//配置文件
		File configFile = new File(GENERATOR_CONFIG_XML_PATH);
		//配置文件解析器
		ConfigurationParser cp = new ConfigurationParser(warnings);
		//解析获得配置
		Configuration config = cp.parseConfiguration(configFile);
		//壳方法支持
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);

		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		//生成
		myBatisGenerator.generate(null);
	}



	/**
	 * 生成 前 将D盘下generate_mybatisXXXXXXXXXXXXX下 文件全部删除
	 * 将当前项目下 org文件下文件全部删除
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		try {
			//初步生成dao,实体
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator();
			System.out.println("dao,entity ok了");

			//根据实体的文件夹目录继续生成11
			ContinueGenerate.continueGenerate(FIRST_COMPLITE_CODE_ENTITY_PATH);

			//继续生成vo
			ContinueGenerate.continueGenerateDTO(FIRST_COMPLITE_CODE_ENTITY_PATH);
			ContinueGenerate.continueGenerateEntity(FIRST_COMPLITE_CODE_ENTITY_PATH);

			//生成newEntityWithColumn
			ContinueGenerate.continueGenerateNewMapperJava(FIRST_COMPLITE_CODE_MAPPER_PATH);
			//生成没有column的entity
			ContinueGenerate.continueGenerateNewMapperXml(FIRST_COMPLITE_CODE_MAPPER_PATH);

			System.out.println("service,controller,dao,newEntityWithColumn ,dto,entity ok了");
			System.out.println("去D盘下generate_mybatisXXXXXXXXXXXXX下找代码.txt");
			System.err.println("如果发现文件少了，基本都是因为配的数据源中没有相关的表");

			FileUtils.deleteDirectory(new File(FIRST_COMPLITE_CODE_ENTITY_PATH));
			FileUtils.deleteDirectory(new File(FIRST_COMPLITE_CODE_MAPPER_PATH));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}