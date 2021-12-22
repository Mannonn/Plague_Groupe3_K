package test;

import javax.transaction.Transactional;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import main.InitBase;

@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class Test {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(InitBase.class).run(args);
		ctx.close();
}
}
