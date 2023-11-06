package fr.romaingervais.imt.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // code technique
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        TrainService trainService = applicationContext.getBean(TrainService.class);

        // code métier
        trainService.exists(args[0]);
    }
}
