package com.san.newreport;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

	// Generated report : /auto-base/test-output/report.html

	@Test(groups = { "test1", "Sanity" })
	public void test1() {

		System.out.println("test1");

	}

	@Test(groups = { "test2", "Sanity" })
	public void test2() {

		Assert.fail("test2 failed");

	}

	@Test(groups = { "test3", "Sanity" })
	public void test3() {

		System.out.println("test3");

	}

}
