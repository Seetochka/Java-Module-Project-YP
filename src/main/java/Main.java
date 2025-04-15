import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int CARS_COUNT = 3;
    private static final int MAX_SPEED = 250;
    private static final int MIN_SPEED = 0;

    public static void main(String[] args) {
        Race race = new Race();

        for (int i = 1; i <= CARS_COUNT; i++) {
            String carName = getCarName(i);
            int carSpeed = getCarSpeed(i);

            Car newCar = new Car(carName, carSpeed);
            race.checkLeader(newCar);
        }

        System.out.println("Самая быстрая машина: " + race.leader);
    }

    private static String getCarName(int i) {
        String carName;

        while (true) {
            System.out.println("— Введите название машины №" + i + ": ");
            carName = scanner.nextLine().trim();
            if (carName.isEmpty()) {
                System.out.println("— Неправильное название: название машины не может быть пустым");
            } else {
                break;
            }
        }

        return carName;
    }

    private static int getCarSpeed(int i) {
        String carSpeedStr;
        int carSpeed;

        while (true) {
            System.out.println("— Введите скорость машины №" + i + ": ");
            carSpeedStr = scanner.nextLine().trim();

            if (!carSpeedStr.matches("-?\\d+")) {
                System.out.println("— Неправильная скорость: скорость должна быть целым числом");
            } else {
                carSpeed = Integer.parseInt(carSpeedStr);

                if (carSpeed < MIN_SPEED) {
                    System.out.println("— Неправильная скорость: скорость должна быть не меньше 0");
                } else if (carSpeed > MAX_SPEED) {
                    System.out.println("— Неправильная скорость: скорость должна быть не больше 250");
                } else {
                    break;
                }
            }
        }

        return carSpeed;
    }
}
