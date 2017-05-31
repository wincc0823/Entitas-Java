package ilargia.entitas.codeGeneration.dataProviders.components;

import ilargia.entitas.api.IComponent;
import ilargia.entitas.codeGeneration.config.AbstractConfigurableConfig;
import ilargia.entitas.codeGeneration.config.CodeGeneratorConfig;
import ilargia.entitas.codeGeneration.data.SourceDataFile;
import ilargia.entitas.codeGeneration.dataProviders.components.providers.*;
import ilargia.entitas.codeGeneration.interfaces.ICodeDataProvider;
import ilargia.entitas.codeGeneration.interfaces.IConfigurable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComponentDataProvider extends AbstractConfigurableConfig implements ICodeDataProvider<Object, SourceDataFile> {

    List<SourceDataFile> _sources;
    List<IComponentDataProvider> _dataProviders;
    private CodeGeneratorConfig _codeGeneratorConfig;
    //    private AssembliesConfig _assembliesConfig = new AssembliesConfig();
    private ContextsDataProvider _contextsComponentDataProvider = new ContextsDataProvider();


    public ComponentDataProvider(List<SourceDataFile> sources) {
        this(sources, getComponentDataProviders());
    }

    protected ComponentDataProvider(List<SourceDataFile> sources, List<IComponentDataProvider> dataProviders) {
        _sources = sources;
        _dataProviders = dataProviders;
        _codeGeneratorConfig = new CodeGeneratorConfig();
    }

    public static Map<String, String> propertiesToMap(Properties props) {
        HashMap<String, String> hm = new HashMap<String, String>();
        Enumeration<Object> e = props.keys();
        while (e.hasMoreElements()) {
            String s = (String) e.nextElement();
            hm.put(s, props.getProperty(s));
        }
        return hm;
    }

    static List<IComponentDataProvider> getComponentDataProviders() {
        return new ArrayList<IComponentDataProvider>() {{
            add(new ComponentTypeDataProvider());
            add(new MemberDataProvider());
            add(new ConstructorDataProvider());
            add(new EnumsDataProvider());
            add(new ContextsDataProvider());
            add(new GenericsDataProvider());
            add(new IsUniqueDataProvider());
            add(new ShouldGenerateComponentDataProvider());
            add(new ShouldGenerateMethodsDataProvider());

        }};
    }

    @Override
    public String getName() {
        return "Component";
    }

    @Override
    public Integer gePriority() {
        return 0;
    }

    @Override
    public boolean isEnableByDefault() {
        return true;
    }

    @Override
    public boolean runInDryMode() {
        return true;
    }

    @Override
    public Properties getDefaultProperties() {
        _codeGeneratorConfig.configure(properties);
        return _dataProviders.stream()
                .filter(p -> p instanceof IConfigurable)
                .map(p -> (IConfigurable) p)
                .map(p -> p.getDefaultProperties())
                .reduce(properties, (a, b) -> {
                    a.putAll(propertiesToMap(b));
                    return a;
                });

    }

    @Override
    public void configure(Properties properties) {
        super.configure(properties);
        _codeGeneratorConfig.configure(properties);
        _dataProviders.stream()
                .filter(p -> p instanceof IConfigurable)
                .map(p -> (IConfigurable) p)
                .forEach(p -> p.configure(properties));

        // _contextsComponentDataProvider.configure(properties);
    }

    @Override
    public List<SourceDataFile> getData() {

        List<SourceDataFile> dataFromComponents = _sources.stream()
                .filter(s -> s.getFileContent().hasInterface(IComponent.class))
                .filter(s -> !s.getFileContent().isAbstract())
                .map(s -> createDataForComponent(s))
                .collect(Collectors.toList());

        List<SourceDataFile> dataFromNonComponents = _sources.stream()
                .filter(s -> !s.getFileContent().hasInterface(IComponent.class))
                .filter(s -> hasContexts(s))
                .map(s -> createDataForComponent(s))
                .collect(Collectors.toList());

        List<String> generatedComponentsLookup = dataFromNonComponents.stream()
                .map(data -> data.getFileContent().getCanonicalName())
                .collect(Collectors.toList());

        return Stream.concat(dataFromComponents.stream()
                        .filter(data -> !generatedComponentsLookup.contains(data.getFileContent().getCanonicalName())),
                dataFromNonComponents.stream())
                .sorted((a, b) -> a.getFileName().compareTo(b.getFileName()))
                .collect(Collectors.toList());


    }

    private boolean hasContexts(SourceDataFile sourceData) {
        return _contextsComponentDataProvider.extractContextNames(sourceData.getFileContent()).size() != 0;
    }

    private SourceDataFile createDataForComponent(SourceDataFile data) {
        for (IComponentDataProvider dataProvider : _dataProviders) {
            dataProvider.provide(data);
        }
        return data;
    }

    List<String> getComponentNames(SourceDataFile data) {
        if (data.getFileContent().hasAnnotation("CustomComponentName")) {
            return Arrays.asList(data.getFileContent().getAnnotation("CustomComponentName").getStringArrayValue("componentNames"));

        } else {
            return new ArrayList<>();
        }

    }
}
