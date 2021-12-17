package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import model.Planete;
import model.TypePlanete;
import model.Vaisseau;
import repository.PlaneteRepository;
import repository.VaisseauRepository;

public class AppVoyage {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PlaneteRepository planeteRepo = ctx.getBean(PlaneteRepository.class);
		VaisseauRepository vaisseauRepo = ctx.getBean(VaisseauRepository.class);
		
		vaisseauRepo.findAll();
		PlaneteRepo.findAll();
		System.out.println(vaisseauRepo);
	}

}
