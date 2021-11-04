package fr.romaingervais.imt.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("fr.romaingervais.imt.aop")
@EnableAspectJAutoProxy
public class ApplicationConfig {

}