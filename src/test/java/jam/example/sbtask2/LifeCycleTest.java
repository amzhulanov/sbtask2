package jam.example.sbtask2;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.entity.Guide;
import jam.example.sbtask2.entity.Type;
import jam.example.sbtask2.entity.Vallue;
import jam.example.sbtask2.service.FieldService;
import jam.example.sbtask2.service.GuideService;
import jam.example.sbtask2.service.VallueService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class LifeCycleTest {

    private static final String VAL = "item1";
    private static final String VAL2 = "item2";
    private static final String NAME_GUIDE = "Guide1";
    private static final String NAME_FIELD = "Column1";
    private static final String NAME_FIELD2 = "Column2";
    private static final String NAME_FIELD3 = "Column3";
    private static final String TYPE = "String";

    private final VallueService vallueService;
    private final GuideService guideService;
    private final FieldService fieldService;

    @Autowired
    LifeCycleTest(VallueService vallueService, GuideService guideService, FieldService fieldService) {
        this.vallueService = vallueService;
        this.guideService = guideService;
        this.fieldService = fieldService;
    }

    @Test
    void lifeCycleTest() {
        Guide guide =guideService.addGuide(NAME_GUIDE);
        Type type=new Type(TYPE);
        fieldService.addField(new Field(guide, NAME_FIELD, type));
        fieldService.addField(new Field(guide, NAME_FIELD2, type));
        fieldService.addField(new Field(guide, NAME_FIELD3, type));
        vallueService.addVallue(new Vallue(fieldService.findFieldByName(guide, NAME_FIELD), VAL));
        vallueService.addVallue(new Vallue(fieldService.findFieldByName(guide, NAME_FIELD), VAL2));
        vallueService.addVallue(new Vallue(fieldService.findFieldByName(guide, NAME_FIELD2), VAL2));
        vallueService.addVallue(new Vallue(fieldService.findFieldByName(guide, NAME_FIELD2), VAL2));
        vallueService.addVallue(new Vallue(fieldService.findFieldByName(guide, NAME_FIELD3), "tttttt"));
        vallueService.addVallue(new Vallue(fieldService.findFieldByName(guide, NAME_FIELD3), "vvvvv"));
        List<Vallue> vallues=new ArrayList<>();
        vallues= vallueService.findAllByVallues(guide.getName(),
                fieldService.findFieldByName(guide, NAME_FIELD),
                fieldService.findFieldByName(guide, NAME_FIELD2),
                VAL, VAL2);

        vallues.forEach(n-> System.out.println("n="+n.toString()));
    }
}
