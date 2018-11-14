package com.micheal.dts.util;

import com.micheal.dts.io.RespCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.Properties;

public class ExpCodeProperties {  
	private static final Logger log = LoggerFactory
			.getLogger(ExpCodeProperties.class);
	private static String EXPCODE_FILE = "exception_code_file";
	private static String DEFAULT_EXPCODE_FILE = "exception-code.properties";
	private static Properties properties;
	static {
		// 优先获取系统变量中的expCode指定的路劲
		String file = System.getProperty(EXPCODE_FILE);
		if (StringUtils.isBlank(file)) {
			file = DEFAULT_EXPCODE_FILE;
		}
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(resourceLoader.getResource(file));
		propertiesFactoryBean.setFileEncoding("UTF-8");
		try {
			propertiesFactoryBean.afterPropertiesSet();
			properties = propertiesFactoryBean.getObject();
		} catch (IOException e) {
			log.error("加载异常码配置文件失败");
		}
	}

	public static RespCode getRespCode(String expCode) {
		String expCodeDesc = properties.getProperty(expCode);
		RespCode result = new RespCode();
		result.setRetCode(expCode);
		if (StringUtils.isBlank(expCodeDesc)) {
			expCodeDesc = "没有找到对应的异常描述";
		}
		result.setRetMsg(expCodeDesc);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(ExpCodeProperties.getRespCode("999999"));
	}
}
