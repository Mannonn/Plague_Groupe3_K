package testRepo;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import repository.ActiviteRepository;


@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class TestActiviteRepo {
	
	@Autowired
	private ActiviteRepository activiteRepo;

	@Test
	void test() {
		assertNotNull(activiteRepo);
	}
	
	

}
