package test.jupiter;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import exception.PassagerException;
import service.PassagerService;

@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class) // remplace @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
class PassagerTest {

	@Autowired
	private PassagerService PassagerService;

	@Test
	@Disabled
	void testCreation() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testSuppression() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		assertThrows(PassagerException.class, () -> PassagerService.getById(null));
	}

	@Test
	@Disabled
	void testGetAll() {
		fail("Not yet implemented");
	}

}
