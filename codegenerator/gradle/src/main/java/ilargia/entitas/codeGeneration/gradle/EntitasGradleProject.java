package ilargia.entitas.codeGeneration.gradle;


import ilargia.entitas.codeGeneration.CodeGenerator;
import ilargia.entitas.codeGeneration.config.CodeGeneratorConfig;
import ilargia.entitas.codeGeneration.interfaces.IAppDomain;
import ilargia.entitas.codeGeneration.interfaces.ICodeGeneratorDataProvider;
import ilargia.entitas.codeGeneration.interfaces.ICodeGenFilePostProcessor;
import ilargia.entitas.codeGeneration.interfaces.ICodeGenerator;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;

import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import static ilargia.entitas.codeGeneration.utils.CodeGeneratorUtil.*;

public class EntitasGradleProject implements IAppDomain {
    private static Properties prop = new Properties();
    private static InputStream input = null;    private static OutputStream output = null;
    private final Project project;
    private final JavaPluginConvention javaConvention;
    private CodeGenerationPluginExtension extension;


    public EntitasGradleProject(Project gradleProject) {
        this.project = gradleProject;
        //this.project.getPlugins().apply(JavaPlugin.class);
        javaConvention = project.getConvention().getPlugin(JavaPluginConvention.class);
        extension = project.getExtensions().findByType(CodeGenerationPluginExtension.class);
        if (extension == null) {
            extension = new CodeGenerationPluginExtension();
        }


    }





    @Override
    public String getAppRoot() {
        return project.getRootProject().toString();
    }

    @Override
    public String getAppName() {
        return project.getName();
    }

    @Override
    public String getAppDir() {
        return project.getProjectDir().getAbsolutePath();
    }

    @Override
    public List<String> getSrcDirs() {
        SourceSetContainer sourceSets = javaConvention.getSourceSets();
        SourceSet mainSourceSet = sourceSets.getByName(SourceSet.MAIN_SOURCE_SET_NAME);
        return mainSourceSet.getAllSource().getSrcDirs().stream().map(f -> {
            try {
                return f.getCanonicalPath();
            } catch (IOException e) {
                return "";
            }
        }).collect(Collectors.toList());
    }

//    @Override
//    public boolean hasProperties() {
//        return new File(getAppDir() + "/" + extension.getConfigFile()).exists();
//    }
//
//    @Override
//    public Properties loadProperties() {
//        if (hasProperties()) {
//            try {
//                EntitasGradleProject.prop.load(new FileInputStream(getAppDir() + "/" + extension.getConfigFile()));
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (EntitasGradleProject.input != null) {
//                    try {
//                        EntitasGradleProject.input.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//        return EntitasGradleProject.prop;
//    }
//
//    @Override
//    public void saveProperties(Properties properties) {
//        try {
//            properties.store(new FileOutputStream(getAppDir() + "/" + extension.getConfigFile()),
//                    "Entitas codeGeneration config file");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            if (EntitasGradleProject.output != null) {
//                try {
//                    EntitasGradleProject.output.close();
//                } catch (Exception e) {
//                    System.out.printf(e.getMessage());
//                }
//            }
//
//        }
//    }

}
