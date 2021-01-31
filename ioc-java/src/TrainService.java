public class TrainService {
    private TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public boolean exists(String trainNumber) {
        return trainRepository.exists(trainNumber);
    }
}
