package fr.romaingervais.imt.config;

public class TrainRepository {
    public boolean exists(String trainNumber) {
        return trainNumber.equals("8140");
    }
}
