package fr.romaingervais.imt.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class TrainService {

    private TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public void exists(String trainNumber) {
        boolean trainExists = trainRepository.exists(trainNumber);
        System.out.println("Train " + trainNumber + " exists ? " + trainExists);
    }}
