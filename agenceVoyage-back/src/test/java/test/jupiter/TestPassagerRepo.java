package test.jupiter;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import exception.PassagerException;
import model.Passager;
import repository.PassagerRepository;


@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class) // remplace @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
class PassagerRepoTest {

	@Autowired
	private PassagerRepository PassagerRepo;

	@Test
	void test() {
		assertNotNull(PassagerRepo);
	}

	@Test
	public void testInsert() {
		Passager Passager = new Passager();
		PassagerRepo.save(Passager);
		assertNotNull(Passager.getId());
		assertTrue(PassagerRepo.findById(Passager.getId()).isPresent());
	}

	@Test
	public void testPassagerException() {
		assertThrows(PassagerException.class,
				() -> PassagerRepo.findById(1L).orElseThrow(PassagerException::new));
	}

	@Test
	@Disabled("probleme avec le passager")
	public void testDataPassager() {
		Passager p = new Passager();
		PassagerRepo.save(p);
		final Passager Passager = PassagerRepo.findById(p.getId()).get();
		// @formatter:off	
		assertAll("controle des donnees du Passager inseré", 
						() -> assertEquals("perso test", Passager.getNom()));
	
		// @formatter:on
	}

	@BeforeAll // remplace BeforeClass
	public static void setup() {
		System.out.println("beforeAll");
	}

	@BeforeEach
	public void init() {
		System.out.println("test");
	}

	@AfterAll
	public static void end() {
		System.out.println("afterAll");
	}

	@AfterEach
	public void endTest() {
		System.out.println("endTest");
	}

}
