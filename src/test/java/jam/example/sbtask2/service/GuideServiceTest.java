package jam.example.sbtask2.service;

import jam.example.sbtask2.config.ConstantSQLTest;
import jam.example.sbtask2.entity.Guide;
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
class GuideServiceTest extends ConstantSQLTest {

    private final GuideService guideService;

    @Autowired
    GuideServiceTest(GuideService guideService) {
        this.guideService = guideService;
    }

    @Test
    void addGuide() {
        assertThat(guideService.findGuideByName(nameGuide)==null);
        Long id=guideService.addGuide(new Guide(nameGuide)).getId();
        assertThat(id).isGreaterThan(0L);
        assertThat(guideService.addGuide(new Guide(nameGuide)).getId()).isEqualTo(id);
    }

    @Test
    void findGuideByName() {
        assertThat(guideService.findGuideByName("Guide1")).isNotNull();
    }
}