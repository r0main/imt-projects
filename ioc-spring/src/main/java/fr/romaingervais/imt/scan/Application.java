package fr.romaingervais.imt.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // code technique
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        TrainService trainService = applicationContext.getBean(TrainService.class);

        // code métier
        boolean isExists = trainService.exists(args[0]);
        System.out.println("Train " + args[0] + " exists ? " + isExists);
    }
}
