package org.yejh.bootdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.yejh.bootdemo.action.ControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootDemoApplication.class)
@WebAppConfiguration
public class BootDemoApplicationTests {
    private MockMvc mvc;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new ControllerTest()).build();
    }

    @Test
    public void testHW() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hw").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string("Hello, World"));
    }

}

