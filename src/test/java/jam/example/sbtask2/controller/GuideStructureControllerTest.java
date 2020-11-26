package jam.example.sbtask2.controller;

import jam.example.sbtask2.config.ConstantJsonTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GuideStructureControllerTest extends ConstantJsonTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @Order(1)
    void createTypeTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .put("/db/createType")
                .contentType(MediaType.APPLICATION_JSON).content(put_type))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void createGuideTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .put("/db/createGuide")
                .contentType(MediaType.APPLICATION_JSON).content(put_guide))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void addFieldTest() throws Exception  {
        mvc.perform(MockMvcRequestBuilders
                .put("/db/createField")
                .contentType(MediaType.APPLICATION_JSON).content(put_field))
                .andDo(print())
                .andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders
                .put("/db/createField")
                .contentType(MediaType.APPLICATION_JSON).content(put_field2))
                .andDo(print())
                .andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders
                .put("/db/createField")
                .contentType(MediaType.APPLICATION_JSON).content(put_field3))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    @Order(4)
    void renameFieldTest() throws Exception  {
        mvc.perform(MockMvcRequestBuilders
                .post("/db/renameField")
                .contentType(MediaType.APPLICATION_JSON).content(post_field))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @Order(5)
    void dropGuideTest() throws Exception  {
        mvc.perform(MockMvcRequestBuilders
                .delete("/db/dropGuide")
                .contentType(MediaType.APPLICATION_JSON).content(drop_guide))
                .andDo(print())
                .andExpect(status().isOk());
    }
}