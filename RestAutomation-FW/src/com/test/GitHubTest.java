package com.test;

import static org.testng.AssertJUnit.assertEquals;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.RestUtil;

public class GitHubTest extends BaseTest {

	RestUtil util;

	@BeforeClass
	public void beforeClass() {
		util = new RestUtil();
		util.getRequest("users/whiteboxhub");
	}
	
	@Test
	public void testHeaders()
	{
		
	}

	@Test
	public void testStatusCode() {
		assertEquals(HttpStatus.SC_OK, util.validateStatusCode());
	}

	@Test
	public void testLogin() {
		assertEquals("WhiteboxHub", util.getUser().getLogin());
	}

	@Test
	public void testId() {
		assertEquals("4023110", util.getUser().getId());
	}
}
