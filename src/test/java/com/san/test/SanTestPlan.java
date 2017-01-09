package com.san.test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auto.base.controller.TestPlan;
import com.auto.base.controller.TestRetryAnalyzer;
import com.auto.base.service.ReadingServiceEndPointsProperties;
import com.auto.base.util.SpireCsvUtil;
import com.auto.base.util.internal.entity.SpireTestObject;

/**
 * @author Santosh C
 *
 */
@Test(groups = { "SANITY" }, retryAnalyzer = TestRetryAnalyzer.class)
public class SanTestPlan extends TestPlan {

	String SERVICE_ENDPOINT_URL = null;

	final static String DATAPROVIDER_NAME = "SAN";
	final static String CSV_DIR = "./src/test/java/com/san/test/";
	final static String CSV_FILENAME = "San_TestData.csv";
	final static String CSV_PATH = CSV_DIR + CSV_FILENAME;

	@DataProvider(name = DATAPROVIDER_NAME)
	public static Iterator<Object[]> getCandidateInfo(Method method) {
		Iterator<Object[]> objectsFromCsv = null;
		try {
			String fileName = CSV_PATH;
			LinkedHashMap<String, Class<?>> entityClazzMap = new LinkedHashMap<String, Class<?>>();
			LinkedHashMap<String, String> methodFilter = new LinkedHashMap<String, String>();
			methodFilter.put(SpireTestObject.TEST_TITLE, method.getName());
			entityClazzMap.put("SpireTestObject", SpireTestObject.class);
			objectsFromCsv = SpireCsvUtil.getObjectsFromCsv(SanTestPlan.class, entityClazzMap, fileName, null,
					methodFilter);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectsFromCsv;
	}

	/**
	 * Read csv
	 * 
	 * @param testObject
	 */
	@Test(groups = { "readCSV1", "Sanity" }, dataProvider = DATAPROVIDER_NAME)
	public void readCSV1(SpireTestObject testObject) {

		System.out.println("csv: " + testObject.getTestTitle());

	}

	/**
	 * Read csv2
	 * 
	 * @param testObject
	 */
	@Test(groups = { "readCSV2", "Sanity" }, dataProvider = DATAPROVIDER_NAME)
	public void readCSV2(SpireTestObject testObject) {

		System.out.println("csv: " + testObject.getTestTitle());

	}

	/**
	 * Read csv3
	 * 
	 * @param testObject
	 */
	@Test(groups = { "readCSV3", "Sanity" }, dataProvider = DATAPROVIDER_NAME)
	public void readCSV3(SpireTestObject testObject) {

		Assert.fail("Failed !!");
	}

	public static void main(String[] args) {

		String value = new ReadingServiceEndPointsProperties().getServiceEndPoint("");
		System.out.println("Property: " + value);

	}

}
