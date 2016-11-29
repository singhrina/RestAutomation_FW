package com.test;

import static org.testng.AssertJUnit.assertEquals;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.RestUtil;

public class TwitterPostTest {
	RestUtil util;
	
	@BeforeClass
	public void beforeClass1() {
		util = new RestUtil();
		util.postRequest("statuses/retweet/:id.json","id:\"12345");
	
}
	@Test
	public void testStatusCode() {
		assertEquals(HttpStatus.SC_CREATED, util.validateStatusCode());
		System.out.println(util.validateStatusCode());
	}

}
