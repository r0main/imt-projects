package fr.romaingervais.imt.scan;

import org.springframework.stereotype.Repository;

@Repository
public class TrainRepository {
    public boolean exists(String trainNumber) {
        return trainNumber.equals("8140");
    }
}
