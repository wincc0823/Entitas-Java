package com.ilargia.games.entitas.codeGeneration.dataProviders.components.providers;

import com.ilargia.games.entitas.codeGeneration.data.SourceDataFile;
import com.ilargia.games.entitas.codeGeneration.data.MemberData;

import java.util.List;
import java.util.stream.Collectors;


public class MemberDataProvider implements IComponentDataProvider {

    public static String COMPONENT_MEMBER_INFOS = "component_memberInfos";

    @Override
    public void provide(SourceDataFile data) {
        List<MemberData> memberDatas = data.source.getFields().stream()
                .filter(field -> field.isPublic())
                .map(field -> new MemberData(field.getType(), field.getName(), field.getAnnotation("generateIndex")))
                .collect(Collectors.toList());

        setMemberData(data, memberDatas);
    }

    public static List<MemberData> getMemberData(SourceDataFile data) {
        return (List<MemberData>) data.get(COMPONENT_MEMBER_INFOS);
    }

    public static void setMemberData(SourceDataFile data, List<MemberData> memberInfos) {
        data.put(COMPONENT_MEMBER_INFOS, memberInfos);
    }
}