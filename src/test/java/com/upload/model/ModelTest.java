package com.upload.model;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class ModelTest {
	@Test
	 public void testBeans() {
	  BeanTester beanTester = new BeanTester();
	  beanTester.testBean(FileId.class);
	  beanTester.testBean(FileModel.class);
	  beanTester.testBean(FileStream.class);
	 }
}
