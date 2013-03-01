package cz.sutak.game.server.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/WEB-INF/context/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
@Transactional// extend the transactions to whole tests in order to rollback the tests
public abstract class AbstractServiceTest {
	
	public AbstractServiceTest() {
	}
}
