package com.yzb808.jar;

/**
 * Hello world!
 *
 */
public class PathGet {

	public String testPath() {
		String path = PathGet.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		return path;
	}
}
