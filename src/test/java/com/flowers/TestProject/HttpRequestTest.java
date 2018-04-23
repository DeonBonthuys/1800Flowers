package com.flowers.TestProject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.flowers.test.Application;
import com.flowers.test.Post;

/**
 * @author gfbon
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
public class HttpRequestTest
{
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testTemplate;
	
	@Test
	public void returnsRecordCount() throws Exception
	{
		assertThat(this.testTemplate.getForObject("http://localhost:" + this.port + "/count", Integer.class)).isInstanceOf(Number.class);
	}
	
	@Test
	public void editReturnsModifiedObject() throws Exception
	{
		assertThat(this.testTemplate.getForObject("http://localhost:" + this.port + "/edit/" + 4, Post.class).getBody()).contains("1800");
	}
}
