package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import main.InitBase;


class Test {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(InitBase.class).run(args);
		ctx.close();
}
}
