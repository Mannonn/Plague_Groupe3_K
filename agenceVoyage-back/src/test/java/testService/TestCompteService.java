package testService;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import service.CompteService;


@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class TestCompteService {
	
	@Autowired
	private CompteService compteService;

	@Test
	void test() {
		assertNotNull(compteService);
	}
	
}
