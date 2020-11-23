package jam.example.sbtask2.service;

import jam.example.sbtask2.config.ConstantSQLTest;
import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.entity.Guide;
import jam.example.sbtask2.entity.Type;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class LifeCycleServicesTest extends ConstantSQLTest {

    private final VallueService vallueService;
    private final GuideService guideService;
    private final FieldService fieldService;
    private final TypeService typeService;

    @Autowired
    LifeCycleServicesTest(VallueService vallueService, GuideService guideService, FieldService fieldService, TypeService typeService) {
        this.vallueService = vallueService;
        this.guideService = guideService;
        this.fieldService = fieldService;
        this.typeService = typeService;
    }

    @Test
    void cycleActions() {
        Map<String, String> vallueList = new HashMap<>();

        Guide guide = guideService.addGuide(nameGuide);
        Type type = typeService.addType(typeData);
        Field field = new Field(guide, nameField, type);
        Field field2 = new Field(guide, nameField2, type);
        Field field3 = new Field(guide, nameField3, type);
        fieldService.addField(field);
        fieldService.addField(field2);
        fieldService.addField(field3);
        vallueList.put(nameField, val);
        vallueList.put(nameField2, val2);
        vallueService.addVallue(nameGuide, vallueList);
        vallueList.clear();
        vallueList.put(nameField, val3);
        vallueList.put(nameField2, val4);
        vallueService.addVallue(nameGuide, vallueList);
        assertThat(vallueService.findAllByVallues(nameGuide, nameField, nameField2,val,val2).size()).isSameAs(1);
        vallueService.editVallue(nameGuide,nameField2,val3,val2);
        vallueService.deleteVallue(nameGuide,nameField2,val3);
        guideService.deleteGuide(nameGuide);
    }

}