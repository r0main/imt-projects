package fr.romaingervais.imt.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    private TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public void exists(String trainNumber) {
        boolean trainExists = trainRepository.exists(trainNumber);
        System.out.println("Train " + trainNumber + " exists ? " + trainExists);
    }
}
