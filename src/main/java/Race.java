public class Race {
    private final static int RACE_TIME = 24;

    public String leader;
    private int leadersDistance;

    public void checkLeader(Car newCar) {
        int newCarDistance = RACE_TIME * newCar.speed;

        if (newCarDistance > leadersDistance) {
            leader = newCar.name;
            leadersDistance = newCarDistance;
        }
    }
}
