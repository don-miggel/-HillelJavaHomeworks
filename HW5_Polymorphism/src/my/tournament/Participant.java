package my.tournament;

import java.util.Random;

public class Participant implements Refine {

    private final String name;
    private boolean furtherCompetition;
    private double performanceResult;

    public Participant(String name) {
        this.name = name;
        furtherCompetition = true;
        performanceResult = 0.0;
    }

    public String getName() {
        return name;
    }

    public boolean getCurrentParticipantStatus() {
        return furtherCompetition;
    }

    public void markAsOut(Obstacle o) {

        double distance = (o instanceof Treadmill) ? ((Treadmill) o).getLength() : ((Wall) o).getHeight();
        System.out.println("A participant [" + getName() + "] has not overcome and obstacle ["
                + o.getRefinedClassName() + "] at the distance [" + distance + "] meters. Has passed ["
                + performanceResult + "] meters.");
        furtherCompetition = false;
    }

    public double run(Obstacle o) {
        performanceResult = getPerformance(o);
        System.out.println("A participant " + getRefinedClassName() + " " + getName() + " has run "
                + performanceResult + " meters.");
        return performanceResult;
    }

    public double jump(Obstacle o) {
        performanceResult = getPerformance(o);
        System.out.println("A participant " + getRefinedClassName() + " " + getName() + " has jumped "
                + performanceResult + " meters high");
        return performanceResult;
    }

    // In order to determine if a participant has overcome an obstacle or not
    // we need to know its length for Treadmill or height for a Wall
    // We generate a random performance value  based on the size of the obstacle
    // We take an obstacle as a parameter, determine type and make a cast to
    //get an appropriate value.
    private double getPerformance(Obstacle o) {
        Random rnd = new Random();
        double performance = 0.0;
        if (o instanceof Treadmill)
            performance = Math.round(Math.random() * ((Treadmill) o).getLength() * 3 * 100.0) / 100.0;
        if (o instanceof Wall)
            performance = Math.round(Math.random() * ((Wall) o).getHeight() * 3 * 100.0) / 100.0;
        return performance;
    }

    @Override
    public String toString() {

        return getRefinedClassName() +
                "{name='" + name + '\'' +
                '}';
    }
}
