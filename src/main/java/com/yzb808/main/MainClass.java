package com.yzb808.main;

import org.apache.commons.lang.StringUtils;

public class MainClass {

	/*
	 * 获取当前应用的ClassPath资源
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("enter main");
		// 获取引入类所属依赖包路径
		System.out.println("dependency import:" + StringUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	}
}
