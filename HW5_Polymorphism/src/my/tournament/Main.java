package my.tournament;

public class Main {

    public static void main(String[] args) {

        Participant[] participants = new Participant[]{new Cat("Fido"), new Person("John"),
                new Robot("Sirius")};
        Obstacle[] obstacles = new Obstacle[]{new Treadmill(15), new Wall(0.8),
                new Treadmill(23), new Wall(1.2), new Treadmill(35), new Wall(1.6)};

        for (Participant p : participants) {
            for (Obstacle o : obstacles) {
                // determine if a participant is eligible to overcome a hurdle, true if eligible
                if (p.getCurrentParticipantStatus())
                    o.overcome(p);
            }
        }
    }
}
