package fr.romaingervais.imt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    TrainService getTrainService(TrainRepository trainRepository) {
        return new TrainService(trainRepository);
    }

    @Bean
    TrainRepository getTrainRepository() {
        return new TrainRepository();
    }
}
