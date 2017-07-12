package com.wefine.app.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {
	@Resource
    private ArticleRepository repository;

    @Test
    public void testIfExisted() {
        long count = repository.exists("title", "ca");
        Assert.assertEquals(0, count);
    }

}
