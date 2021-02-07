package fr.romaingervais.imt.properties;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("fr.romaingervais.imt.properties")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

}
