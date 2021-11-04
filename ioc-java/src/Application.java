public class Application {

    public static void main(String[] args) {
        // code technique
        TrainRepository trainRepository = new TrainRepository();
        TrainService trainService = new TrainService(trainRepository);

        // code métier
        boolean isExists = trainService.exists(args[0]);
        System.out.println("Train " + args[0] + " exists ? " + isExists);
    }
}
