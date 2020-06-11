package pl.gregorymartin.testspringbootexerciseakademiaspringhw;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class ApiSpec {

    @Autowired
    MockMvc mockMvc;

    @Test
    void get_people()throws Exception {
        mockMvc.perform(get("/people/{limit}",2))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }
    @Test
    void get_people_with_selected_item()throws Exception {
        mockMvc.perform(get("/people/{limit}",3))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", Is.is("Jan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].surname", Is.is("Nowak")));
    }

    @Test
    void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello"));
    }
}
