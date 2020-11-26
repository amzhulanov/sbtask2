package jam.example.sbtask2.controller;

import jam.example.sbtask2.config.ConstantJsonTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GuideDataControllerTest extends ConstantJsonTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void addVallueTest() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                .put("/data/person")
                .contentType(MediaType.APPLICATION_JSON).content(put_json))
                .andDo(print())
                .andExpect(status().isOk());
    }
}