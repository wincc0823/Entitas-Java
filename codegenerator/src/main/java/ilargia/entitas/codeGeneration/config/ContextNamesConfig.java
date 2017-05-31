package ilargia.entitas.codeGeneration.config;


import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ContextNamesConfig extends AbstractConfigurableConfig {
    static String CONTEXTS_KEY = "Entitas.CodeGeneration.Contexts";

    @Override
    public Properties getDefaultProperties() {
        if (!properties.containsKey(CONTEXTS_KEY)) properties.setProperty(CONTEXTS_KEY, "Core");
        return properties;
    }

    public List<String> getContextNames() {
        return Pattern.compile(",")
                .splitAsStream(properties.getProperty(CONTEXTS_KEY))
                .sorted()
                .collect(Collectors.toList());
    }
}
