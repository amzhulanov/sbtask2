package jam.example.sbtask2.service;

import jam.example.sbtask2.entity.Field;
import jam.example.sbtask2.entity.Guide;
import jam.example.sbtask2.entity.Type;
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
class FieldServiceTest {
    private final FieldService fieldService;
    private Field field;

    @Autowired
    FieldServiceTest(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @Test
    void addColumn() {


        field = fieldService.addField(new Field(new Guide("Guide1"), "column2", new Type("String")));
        assertThat(field.getGuide().getName()).isEqualTo("Guide1");
    }


}