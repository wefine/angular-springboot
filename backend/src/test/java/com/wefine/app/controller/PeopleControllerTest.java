package com.wefine.app.controller;

import com.alibaba.fastjson.JSON;
import com.wefine.app.entity.People;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleControllerTest {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllPeople() throws Exception {

        String response = mvc.perform(get("/api/people")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<People> peopleList = JSON.parseArray(response, People.class);

        Assert.assertNotNull(peopleList);
    }

    @Test
    public void testCreatePeople() throws Exception {
        People p = new People();
        p.setAge(20);
        p.setName("fenian");

        String json = JSON.toJSONString(p);

        mvc.perform(post("/api/people")
            .contentType(contentType)
            .content(json))
            .andExpect(status().isCreated());
    }

    @Test
    public void testDelete() throws Exception {
        String response = mvc.perform(get("/api/people")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<People> peopleList = JSON.parseArray(response, People.class);

        peopleList.forEach(people -> {
            try {
                log.info(JSON.toJSONString(people));

                mvc.perform(delete("/api/people/" + people.getId()))
                        .andExpect(status().isOk());
            } catch (Exception e) {
                log.error("Failed to delete!", e);
            }
        });
    }

}
