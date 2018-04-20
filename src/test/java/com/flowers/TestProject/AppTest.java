package com.flowers.TestProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.flowers.test.Application;
import com.flowers.test.TestController;


/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class AppTest {
	
	@Autowired
	private TestController controller;
    
	@Test
    public void contextLoads() throws Exception
	{
		assertThat(controller).isNotNull();
    }
}
