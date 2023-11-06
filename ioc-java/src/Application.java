public class Application {

    public static void main(String[] args) {
        // code technique
        TrainRepository trainRepository = new TrainRepository();
        TrainService trainService = new TrainService(trainRepository);

        // code métier
        trainService.exists(args[0]);
    }
}
