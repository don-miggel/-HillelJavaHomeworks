package my.tournament;

public class Wall implements Obstacle {

    private final double height;

    public Wall(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void overcome(Participant p) {
        // get a performance value of a participant, if it is higher or equal to a height, obstacle is overcome
        if (p.jump(this) >= height) {
            System.out.println("A participant [" + p.getName() + "] has overcome an obstacle [" +
                    getRefinedClassName() + "] at the distance [" + height + "] meters");

        } else
            // mark participant as out of competition otherwise
            p.markAsOut(this);
    }
}
