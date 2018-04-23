package com.flowers.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flowers.test.services.TestService;

@RestController
@RequestMapping("/")
public class TestController
{
	@Autowired
	private TestService testService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/count")
    public ResponseEntity<Integer> count()
	{
        return ResponseEntity.ok(testService.count());
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "edit/{id}")
    public ResponseEntity<Post> edit(@PathVariable Long id)
	{
		Post p = testService.edit(id);
    	return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }
}