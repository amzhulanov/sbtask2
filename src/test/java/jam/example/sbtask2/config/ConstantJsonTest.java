package jam.example.sbtask2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component
@PropertySource("classpath:json_test.properties")
public class ConstantJsonTest {

    @Value("${controllers.data.put.json}")
    public String put_json;

    @Value("${controllers.structure.put.type}")
    public String put_type;

    @Value("${controllers.structure.put.guide}")
    public String put_guide;

    @Value("${controllers.structure.put.field}")
    public String put_field;

    @Value("${controllers.structure.put.field2}")
    public String put_field2;

    @Value("${controllers.structure.put.field3}")
    public String put_field3;

    @Value("${controllers.structure.post.field}")
    public String post_field;

    @Value("${controllers.structure.drop.field}")
    public String drop_field;

    @Value("${controllers.structure.drop.guide}")
    public String drop_guide;

}
