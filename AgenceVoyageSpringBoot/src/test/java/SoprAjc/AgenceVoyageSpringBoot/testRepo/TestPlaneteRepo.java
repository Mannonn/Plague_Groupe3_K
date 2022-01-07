package SoprAjc.AgenceVoyageSpringBoot.testRepo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import SoprAjc.AgenceVoyageSpringBoot.repository.PlaneteRepository;

@Transactional
@Rollback(true)
@SpringBootTest
class TestPlaneteRepo {

	@Autowired
	private PlaneteRepository planeteRepo;

	@Test
	void test() {
		assertNotNull(planeteRepo);
	}

}