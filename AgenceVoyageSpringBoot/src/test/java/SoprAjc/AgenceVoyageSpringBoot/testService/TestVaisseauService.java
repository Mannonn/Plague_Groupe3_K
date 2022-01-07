package SoprAjc.AgenceVoyageSpringBoot.testService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import SoprAjc.AgenceVoyageSpringBoot.service.VaisseauService;

@Transactional
@Rollback(true)
@SpringBootTest
class TestVaisseauService {

	@Autowired
	private VaisseauService vaisseauService;

	@Test
	void test() {
		assertNotNull(vaisseauService);
	}

}
