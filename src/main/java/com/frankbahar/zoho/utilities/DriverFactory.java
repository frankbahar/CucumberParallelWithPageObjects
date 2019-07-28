package com.frankbahar.zoho.utilities;

public class DriverFactory {
	private static String chromeDriverExePath;
	private static String geckoDriverExePath;
	private static String ieDriverExePath;
	private static String EdgeDriverExePath;
	private static String configPropertyFile;
	private static String gridPath;
	private static boolean isRemote;
	
	public static boolean getIsRemote() {
		return isRemote;
	}
	public static void setIsRemote(boolean isRemote) {
		DriverFactory.isRemote = isRemote;
	}
	public static String getChromeDriverExePath() {
		return chromeDriverExePath;
	}
	public static void setChromeDriverExePath(String chromeDriverExePath) {
		DriverFactory.chromeDriverExePath = chromeDriverExePath;
	}
	public static String getGeckoDriverExePath() {
		return geckoDriverExePath;
	}
	public static void setGeckoDriverExePath(String geckoDriverExePath) {
		DriverFactory.geckoDriverExePath = geckoDriverExePath;
	}
	public static String getIeDriverExePath() {
		return ieDriverExePath;
	}
	public static void setIeDriverExePath(String ieDriverExePath) {
		DriverFactory.ieDriverExePath = ieDriverExePath;
	}
	public static String getEdgeDriverExePath() {
		return EdgeDriverExePath;
	}
	public static void setEdgeDriverExePath(String edgeDriverExePath) {
		EdgeDriverExePath = edgeDriverExePath;
	}
	public static String getConfigPropertFile() {
		return configPropertyFile;
	}
	public static void setConfigPropertFile(String configPropertFile) {
		DriverFactory.configPropertyFile = configPropertFile;
	}
	public static String getGridPath() {
		return gridPath;
	}
	public static void setGridPath(String gridPath) {
		DriverFactory.gridPath = gridPath;
	}
	
}
