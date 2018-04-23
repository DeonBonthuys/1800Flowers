package com.flowers.test.services;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.flowers.test.Post;

/**
 * @author gfbon
 *
 */
@Service
public class TestServiceImpl implements TestService
{
	public Post[] posts;
	
	@Override
	public void populate(Post[] data)
	{
		this.posts = data;
	}
	
	@Override
	public Integer count()
	{
		HashSet<Long> uniqueIds = new HashSet<Long>();
    	
    	if (this.posts != null)
    	{
    		for (Post p : this.posts)
    			uniqueIds.add(p.getUserId());
    	}
    	
		return uniqueIds.size();
	}

	@Override
	public Post edit(Long id)
	{
		if (this.posts != null)
    	{
    		for (Post p : this.posts)
    		{
    			if (p.getId().equals(id))
    			{
    				p.setTitle("1800Flowers");
    				p.setBody("1800Flowers");
    				return p;
    			}
    		}
    	}
		return null;
	}

}
