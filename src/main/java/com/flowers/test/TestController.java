package com.flowers.test;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

	public Post[] posts;
	
	@Autowired
	/**
	 * 
	 */
	public TestController()
	{
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.GET, value = "/count")
    public CountResponse count() {
    	
    	HashSet<Long> uniqueIds = new HashSet<Long>();
    	
    	if (this.posts != null)
    	{
    		for (Post p : this.posts)
    			uniqueIds.add(p.getUserId());
    	}
    	
        return new CountResponse(uniqueIds.size());
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "edit/{id}")
    public ResponseEntity<Post> edit(@PathVariable Long id) {
    	
    	if (this.posts != null)
    	{
    		for (Post p : this.posts)
    		{
    			if (p.getId().equals(id))
    			{
    				p.setTitle("1800Flowers");
    				p.setBody("1800Flowers");
    				return ResponseEntity.ok(p);
    			}
    		}
    	}
    	
        return ResponseEntity.notFound().build();
    }
    
    private class CountResponse {
    	private Integer uniqueIds;
    	
    	public CountResponse(Integer uniqueIds)
    	{
    		this.uniqueIds = uniqueIds;
    	}

		public Integer getUniqueIds()
		{
			return uniqueIds;
		}

		public void setUniqueIds(Integer uniqueIds)
		{
			this.uniqueIds = uniqueIds;
		}
    }
}