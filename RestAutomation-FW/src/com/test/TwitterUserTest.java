package com.test;

import static org.testng.AssertJUnit.assertEquals;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.RestUtil;

public class TwitterUserTest extends BaseTest {

	RestUtil util;

	@BeforeClass
	public void beforeClass() {
		util = new RestUtil();
		util.getTwitterRequest("statuses/user_timeline.json?", "rinasingh4", 2);
	}

	@Test
	public void testStatusCode() {
		assertEquals(HttpStatus.SC_OK, util.validateStatusCode());
	}

}
