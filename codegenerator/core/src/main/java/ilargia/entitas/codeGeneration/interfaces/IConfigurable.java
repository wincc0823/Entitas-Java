package ilargia.entitas.codeGeneration.interfaces;


import java.util.Properties;

public interface IConfigurable {

    Properties defaultProperties();

    void setProperties(Properties properties);

}
