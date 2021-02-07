package fr.romaingervais.imt.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        TrainRepository trainsRepository = applicationContext.getBean(TrainRepository.class);

        trainsRepository.printProperties();
    }
}
