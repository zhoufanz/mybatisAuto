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


		另外建议 调用mybatis之前
		/**
             * 过滤map空值
             * @param map
             * @return
             */
            public static Map<String,Object> filterEmptyValueForMap(Map<String,Object> map){
                Map<String, Object> target = new HashMap<>();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        if (StringUtils.isNotEmpty(entry.getValue().toString())) {
                            target.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                return target;
            }