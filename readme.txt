generatorConfig.xml
编辑数据库,表
GeneratorSqlmapBefore.main 控制台打配置(非必须)

GeneratorSqlmap.main 启动
去D盘下generate_mybatisXXXXXXXXXXXXX下找代码
當前项目中代码基本不用


GeneratorSqlmap
public static final String path="/src/com/yung/couponconfig/";

generatorConfig.xml
<javaModelGenerator targetProject=".\src" targetPackage="com.yung.couponconfig.domain">
			<!-- enableSubPackages:是否让schema作为包的后缀 -->
			<property name="enableSubPackages" value="false" />
			<!-- 从数据库返回的值被清理前后的空格 -->
			<property name="trimStrings" value="true" />
		</javaModelGenerator>
        <!-- targetProject:mapper映射文件生成的位置 -->
		<sqlMapGenerator targetProject=".\src" targetPackage="com.yung.couponconfig.dao">
			<!-- enableSubPackages:是否让schema作为包的后缀 -->
			<property name="enableSubPackages" value="false" />
		</sqlMapGenerator>
		<!-- targetPackage：mapper接口生成的位置 -->
		<javaClientGenerator type="XMLMAPPER" targetPackage="com.yung.couponconfig.dao"
			targetProject=".\src">
			<!-- enableSubPackages:是否让schema作为包的后缀 -->
			<property name="enableSubPackages" value="false" />
		</javaClientGenerator>