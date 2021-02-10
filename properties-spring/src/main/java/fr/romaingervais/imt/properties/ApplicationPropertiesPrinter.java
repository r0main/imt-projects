package fr.romaingervais.imt.properties;

import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public class ApplicationPropertiesPrinter {

    private Environment environment;

    public ApplicationPropertiesPrinter(Environment environment) {
        this.environment = environment;
    }

    public void printProperties() {
        for(Iterator it = ((AbstractEnvironment) environment).getPropertySources().iterator(); it.hasNext(); ) {
            PropertySource propertySource = (PropertySource) it.next();
            for( String propertyName : ((MapPropertySource) propertySource).getPropertyNames()){
                System.out.println(propertyName + " = " + environment.getProperty(propertyName));
            }
        }
    }
}
