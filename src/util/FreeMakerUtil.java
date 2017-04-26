package util;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMakerUtil {
	
	/**
	 * 获得模版
	 * @param ftlPath 模版路径
	 * @param templateName 模版名称
	 * @return
	 */
	public Template getTemplate(String ftlPath,String templateName) {
		try {
			Configuration cfg = new Configuration();
			cfg.setClassForTemplateLoading(this.getClass(), ftlPath);
			Template template = cfg.getTemplate(templateName);
			return template;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据参数,模版,生成文件
	 * @param ftlName 模版路径
	 * @param templateName 模版名称
	 * @param templateData 参数
	 * @param outFileFullPath 输出文件全名
	 */
	public void generateFile(String ftlPath,String templateName, Map<String, Object> templateData, String outFileFullPath) {

		FileWriter out = null;
		try {
			//创建输出文件
			out = new FileWriter(new File(outFileFullPath));
			//获得模版
			Template temp = this.getTemplate(ftlPath,templateName);
			//往模版填充参数并输出到输出文件
			temp.process(templateData, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
