package com.upload;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.upload.starter.FileUploaderAppApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=FileUploaderAppApplication.class)
@Ignore
public class FileUploaderAppApplicationTest {

	protected TestRestTemplate restTemplate = new TestRestTemplate();

	protected MockMvc mockMvc;
	
	protected String base_url = "http://localhost:8080";
	
	@Autowired
    private WebApplicationContext wac;
	
	@org.junit.Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

}
