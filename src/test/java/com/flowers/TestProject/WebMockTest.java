package com.flowers.TestProject;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.flowers.test.TestController;
import com.flowers.test.services.TestService;

/**
 * @author gfbon
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
@ContextConfiguration(classes = TestController.class)
public class WebMockTest
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TestService testService;
	
	@Test
	public void shouldReturnCount() throws Exception
	{
		when(testService.count()).thenReturn(10);
		
		this.mockMvc.perform(get("/count"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(content().string("10"));
	}
}
