package jam.example.sbtask2.service;

import jam.example.sbtask2.config.ConstantSQLTest;
import jam.example.sbtask2.entity.Type;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class TypeServiceTest extends ConstantSQLTest {
private final TypeService typeService;

    @Autowired
    TypeServiceTest(TypeService typeService) {
        this.typeService = typeService;
    }

    @Test
    void addType() {
        assertThat(typeService.findType(typeDataStr) == null);
        Long id=typeService.addType(new Type(typeDataStr)).getId();
        assertThat(id).isGreaterThan(0L);
        assertThat(typeService.addType(new Type(typeDataStr)).getId()).isEqualTo(id);
    }

}