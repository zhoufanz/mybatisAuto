package main;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import util.ContinueGenerate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {

	//生成
	public void generator() throws Exception {
		//错误信息
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//配置文件
		File configFile = new File("generatorConfig.xml");
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

	public static final String path="/src/com/yung/coupon/";


	//获得已经生成的实体类文件夹路径
	private static String getEntityPath() {
		return new File(System.getProperty("user.dir"), path+"domain").getAbsolutePath();
	}

	private static String getMapperPath1() {
		return new File(System.getProperty("user.dir"), path+"dao").getAbsolutePath();
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
			ContinueGenerate.continueGenerate(getEntityPath());


			//继续生成vo
			ContinueGenerate.continueGenerateVo(getEntityPath());

			//生成newEntityWithColumn
			ContinueGenerate.continueGenerateNewMapperJava(getMapperPath1());
			//生成没有column的entity
			ContinueGenerate.continueGenerateNewMapperXml(getMapperPath1());

			System.out.println("service,controller,dao,newEntityWithColumn ,dto,entity ok了");
			System.out.println("去D盘下generate_mybatisXXXXXXXXXXXXX下找代码.txt");
			System.err.println("如果发现文件少了，基本都是因为配的数据源中没有相关的表");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}