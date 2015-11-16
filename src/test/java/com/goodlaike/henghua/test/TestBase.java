package com.goodlaike.henghua.test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author jail
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:spring/applicationContext.xml" })
@Rollback
@Transactional(transactionManager = "transactionManagerDefault")
public class TestBase {

}
