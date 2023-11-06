public class TrainService {
    private TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public void exists(String trainNumber) {
        boolean trainExists = trainRepository.exists(trainNumber);
        System.out.println("Train " + trainNumber + " exists ? " + trainExists);
    }
}
