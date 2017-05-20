package com.ilargia.games.entitas.codeGeneration.config;


import java.util.Properties;

public class TargetDirectoryConfig extends AbstractConfigurableConfig {
    static String TARGET_DIRECTORY_KEY = "Entitas.CodeGeneration.Plugins.TargetDirectory";

    @Override
    public Properties getDefaultProperties() {
        properties.setProperty(TARGET_DIRECTORY_KEY, "./generated");
        return properties;
    }

    public String targetDirectory() {
        return properties.getProperty(TARGET_DIRECTORY_KEY);
    }

}