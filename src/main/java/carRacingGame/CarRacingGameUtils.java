package carRacingGame;

import java.util.*;

import static carRacingGame.PrintView.printWinners;

public class CarRacingGameUtils {
    public Map<String, String> cars = new HashMap<>();
    public List<String> finalWinners = new ArrayList<>();
    public static Random RANDOM = new Random();
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_CONDITION = 4;
    public int currentPosition = 0;

    public Map<String, String> setupCars(String[] inputNameOfCars) {
        for (String carName : inputNameOfCars) {
            cars.put(carName, "");
        }
        return cars;
    }

    public void displayRaceProgress(int numberOfAttempts) {
        System.out.println("실행 결과");
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            moveCars();
            PrintView.printCars(cars);
            System.out.println();
        }
    }

    public void moveCars() {
        cars.forEach((carName, currentPosition) -> {
            String newPosition = moveForward(currentPosition);
            cars.put(carName, newPosition);
        });
    }


    public String moveForward(String currentPosition) {
        int randomValue = RANDOM.nextInt(RANDOM_RANGE);
        if (randomValue >= MOVE_CONDITION) {
            currentPosition += "-";
        }
        return currentPosition;
    }


    public void printWinnerName() {
        racingResult();
        String winnerNames = "";
        winnerNames = String.join(", ", finalWinners);
        printWinners(winnerNames);
    }

    public void racingResult(){
        String furthestDistance = Collections.max(cars.values());
        int furthestDistanceOfCar = furthestDistance.length();

        cars.forEach((carName, finalDistance) -> {
            int carNameDistance = finalDistance.length();
            getCurrentWinner(carName, furthestDistanceOfCar, carNameDistance);
        });

    }
    public void getCurrentWinner(String carName, int furthestDistanceOfCar, int carNameDistance) {
        if (carNameDistance >= furthestDistanceOfCar) {
            finalWinners.add(carName);
        }
    }
}
