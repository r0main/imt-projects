package fr.romaingervais.imt.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TrainRepository {

    private String url;
    private String username;
    private String password;

    public TrainRepository(
            @Value("${database.url}") String url,
            @Value("${database.username}") String username,
            @Value("${database.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void printProperties() {
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
