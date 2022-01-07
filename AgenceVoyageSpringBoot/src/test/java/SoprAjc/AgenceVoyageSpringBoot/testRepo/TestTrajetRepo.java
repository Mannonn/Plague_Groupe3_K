package SoprAjc.AgenceVoyageSpringBoot.testRepo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import SoprAjc.AgenceVoyageSpringBoot.repository.TrajetRepository;

@Transactional
@Rollback(true)
@SpringBootTest
class TestTrajetRepo {

	@Autowired
	private TrajetRepository trajetRepo;

	@Test
	void test() {
		assertNotNull(trajetRepo);
	}

}