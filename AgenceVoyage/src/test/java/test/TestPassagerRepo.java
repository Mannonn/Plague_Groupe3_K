package test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import model.Passager;
import repository.PassagerRepository;

public class TestPassagerRepo {

	private static AnnotationConfigApplicationContext ctx;
	private PassagerRepository PassagerRepo;

	@BeforeClass
	public static void methodeExecutee1FoisAvantLesTests() {
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@AfterClass
	public static void execution1FoisApresLesTests() {
		ctx.close();
	}

	@Before
	public void execution1FoisAvantCHAQUETest() {
		PassagerRepo = ctx.getBean(PassagerRepository.class);
	}

	@After
	public void execution1FoisApresChaqueTest() {

	}

	@Test
	public void personneRepositoryOk() {
		assertNotNull(PassagerRepo);
	}

	@Test
	public void testFindByIdWithQuetesAndInventaire() {
		Passager Passager = (model.Passager) PassagerRepo.findAll();
		assertNotNull(Passager.getId());
		assertNotNull(Passager.getNom());
		assertNotNull(Passager.getPrenom());
	}

}
