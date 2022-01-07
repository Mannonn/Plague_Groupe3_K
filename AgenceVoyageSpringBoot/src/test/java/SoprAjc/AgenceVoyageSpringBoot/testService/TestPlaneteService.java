package SoprAjc.AgenceVoyageSpringBoot.testService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import SoprAjc.AgenceVoyageSpringBoot.service.PlaneteService;



@Transactional
@Rollback(true)
@SpringBootTest
class TestPlaneteService {
	
	@Autowired
	private PlaneteService planeteService;

	@Test
	void test() {
		assertNotNull(planeteService);
	}
	
}
