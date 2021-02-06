package fr.romaingervais.imt.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        TrainService trainService = applicationContext.getBean(TrainService.class);
        TrainService trainService2 = applicationContext.getBean(TrainService.class);

        System.out.println("Is same instance  ? " + (trainService == trainService2));
    }
}
