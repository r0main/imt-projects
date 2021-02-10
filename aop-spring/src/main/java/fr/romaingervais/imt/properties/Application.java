package fr.romaingervais.imt.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Calculator calculator = applicationContext.getBean(Calculator.class);

        System.out.println(calculator.add(1,2));
        System.out.println(calculator.substract(1,3));
    }
}
