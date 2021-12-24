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
import service.ReservationService;


@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class TestReservationService {
	
	@Autowired
	private ReservationService reservationService;

	@Test
	void test() {
		assertNotNull(reservationService);
	}
	
}
