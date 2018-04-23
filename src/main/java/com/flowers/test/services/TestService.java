package com.flowers.test.services;

import com.flowers.test.Post;

/**
 * @author gfbon
 *
 */
public interface TestService
{
	void populate(Post[] data);
	Integer count();
	Post edit(Long id);
}
