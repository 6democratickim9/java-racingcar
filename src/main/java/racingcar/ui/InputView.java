package racingcar.ui;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_NAME_DELIMITER = ",";

    public InputView() {

    }

    private void printNumberOfAttempt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public List<String> inputNamesOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputString = scanner.next();
        return Arrays.asList(getCarNamesSplit(inputString));
    }

    public int inputNumberOfAttempt() {
        printNumberOfAttempt();
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("정수 타입이 아닙니다!" + e);
        }
    }

    private String[] getCarNamesSplit(String nameOfCars) {
        return nameOfCars.split(CAR_NAME_DELIMITER);
    }

}
