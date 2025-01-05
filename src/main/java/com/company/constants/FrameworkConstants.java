package com.company.constants;

public final class FrameworkConstants {
    private FrameworkConstants(){}
    private final static String projectPath = System.getProperty("user.dir");
    private final static String propertiesFilePath = projectPath+"//globalproperties.properties";
    private final static String errorScreenshotPath = projectPath + "//src//reports//error.png";

    private final static int explicitWaitTime = 10;
    public static String getProjectPath(){
        return projectPath;
    }
    public static String getPropertiesFilePath(){
        return propertiesFilePath;
    }
    public static String getErrorScreenshotPath(){
        return errorScreenshotPath;
    }
    public static int getExplicitWaitTime(){
        return explicitWaitTime;
    }
}
