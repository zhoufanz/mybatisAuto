package util;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

public class StringUtil {

	/**
	 * 获得大驼峰字符
	 * @param source
	 * @return
	 */
	public static String makeBigHump(String source) {
		//将首字母大写
		source=source.substring(0,1).toUpperCase()+source.substring(1);
		//循环排除_并将其后大写
		int underIndex;
		while ((underIndex=source.indexOf("_"))>=0) {
			String begin=source.substring(0,underIndex);
			String upper=source.substring(underIndex+1,underIndex+2).toUpperCase();
			String end=source.substring(underIndex+2);
			source=begin+upper+end;
		}
		return source;
	}
	/**
	 * 获得大驼峰字符2
	 * @param source
	 * @return
	 */
	public static String makeBigHump2(String source) {
		//将首字母大写
		source=source.substring(0,1).toUpperCase()+source.substring(1);
		if (source.indexOf("_")<0) {
			return source;
		}
		String[] strArr=source.split("_");
		StringBuffer sb=new StringBuffer();
		for (String string : strArr) {
			String change=string.substring(0,1).toUpperCase()+string.substring(1);
			sb.append(change);
		}
		return sb.toString();
	}
	/**
	 * 将指定文件夹中的非Example的类名输出为分割字符窜 "a","b"..
	 * @param path
	 * @return
	 */
	public static String getDirectoryClassNameString(String path){
		File directoryFile=new File(path);
		try {
			File[] files=directoryFile.listFiles();
			StringBuffer sb=new StringBuffer();
			for (int i = 0; i < files.length; i++) {
				String fileName=files[i].getName();
				fileName=fileName.substring(0,fileName.lastIndexOf("."));
				//实体类
				if (fileName.indexOf("Example")<0) {
					sb.append("\""+StringUtil.makeBigHump2(fileName)+"\",");
				}
			}
			return sb.toString().substring(0,sb.toString().length()-1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 将指定文件夹中的非Example的类名输出为List<String>
	 * @param path
	 * @return
	 */
	public static List<String> getDirectoryClassNameListString(String path){
		List<String> classNames=new ArrayList<String>();
		File directoryFile=new File(path);
		try {
			File[] files=directoryFile.listFiles();
			for (int i = 0; i < files.length; i++) {
				String fileName=files[i].getName();
				fileName=fileName.substring(0,fileName.lastIndexOf("Entity"));
				//实体类
				if (fileName.indexOf("Example")<0) {
					classNames.add(fileName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classNames;
	}
	public static void main(String[] args) {
		/*System.out.println(makeBigHump("dfsds_dsf_dfsd"));
		System.out.println(makeBigHump2("dfsds_dsf_dfsd"))*/;
		//System.out.println(getStringArr("F:\\eclipse-jee-luna\\mybatisAuto2\\src\\org\\java\\entity"));
	}
}
