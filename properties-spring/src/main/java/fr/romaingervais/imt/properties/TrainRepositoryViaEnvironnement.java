package fr.romaingervais.imt.properties;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

@Repository
public class TrainRepositoryViaEnvironnement {

    private String url;
    private String username;
    private String password;

    public TrainRepositoryViaEnvironnement(Environment environment) {
        this.url = environment.getProperty("database.url");
        this.username = environment.getProperty("database.username");
        this.password = environment.getProperty("database.password");
    }

    public void printProperties() {
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
