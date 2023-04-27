package my.tournament;

public class Treadmill implements Obstacle {

    private final double length;

    public Treadmill(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public void overcome(Participant p) {
        // get a performance value of a participant, if it is equal to a length, this obstacle is overcome

        if (p.run(this) >= length) {
            System.out.println("A participant [" + p.getName() + "] has overcome an obstacle [" +
                    getRefinedClassName() + "] at the distance [" + length + "] meters");

        } else
            // mark participant as out of competition otherwise
            p.markAsOut(this);
    }
}
