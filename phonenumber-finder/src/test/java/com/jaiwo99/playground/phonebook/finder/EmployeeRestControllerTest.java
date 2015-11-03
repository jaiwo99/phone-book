package com.jaiwo99.playground.phonebook.finder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author liang shi
 * @since 21.10.15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PhoneNumberFinderApplication.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class EmployeeRestControllerTest {

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Value("classpath:test-employee.json")
    Resource jsonFile;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).alwaysDo(print()).build();
    }

    @Test
    public void find_should_return_all_entries_on_no_term_exists() throws Exception {
        mockMvc.perform(get("/api/employees/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)));
    }

    @Test
    public void find_should_honor_pageable_command() throws Exception {
        mockMvc.perform(get("/api/employees/?size=5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)));
    }

    @Test
    public void find_should_return_matched_entries_on_term_exists() throws Exception {
        mockMvc.perform(get("/api/employees/?term=meyer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void find_should_return_matched_entries_on_term_substring_exists() throws Exception {
        mockMvc.perform(get("/api/employees/?term=musterman"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}