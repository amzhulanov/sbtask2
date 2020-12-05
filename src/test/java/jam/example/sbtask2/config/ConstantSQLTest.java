package jam.example.sbtask2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:service_test.properties")
public class ConstantSQLTest {

    @Value("${guide.val}")
    public String val;

    @Value("${guide.val2}")
    public String val2;

    @Value("${guide.val3}")
    public String val3;

    @Value("${guide.val4}")
    public String val4;

    @Value("${guide.name_guide}")
    public String nameGuide;

    @Value("${guide.name_guide2}")
    public String nameGuide2;

    @Value("${guide.name_field}")
    public String nameField;

    @Value("${guide.name_field2}")
    public String nameField2;

    @Value("${guide.name_field3}")
    public String nameField3;

    @Value("${guide.type.Str}")
    public String typeDataStr;

    @Value("${guide.type.Int}")
    public String typeDataInt;

    @Value("${guide.type.Bln}")
    public String typeDataBln;

}
