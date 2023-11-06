package fr.romaingervais.imt.config;

import java.util.Arrays;
import java.util.List;

public class TrainRepository {

    public static final List<String> TRAINS = Arrays.asList("8080", "8140");

    public boolean exists(String trainNumber) {
        return TRAINS.contains(trainNumber);
    }
}
