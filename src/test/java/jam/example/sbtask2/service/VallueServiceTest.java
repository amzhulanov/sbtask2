package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Guide;
import jam.example.sbtask2.entity.Vallue;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class VallueServiceTest {
    private static final String VAL="item1";
    private static final String NAME_GUIDE="Guide1";
    private static final String NAME_FIELD="Column2";

    private final VallueService vallueService;
    private final GuideService guideService;
    private final FieldService fieldService;

    @Autowired
    VallueServiceTest(VallueService vallueService, GuideService guideService, FieldService fieldService) {
        this.vallueService = vallueService;
        this.guideService = guideService;
        this.fieldService = fieldService;
    }

    @Test
    void addValue() {
        Guide guide=guideService.findGuideByName(NAME_GUIDE);
        assertThat(vallueService.addVallue(new Vallue(fieldService.findFieldByName(guide,NAME_FIELD),VAL))).isNotNull();
    }

}