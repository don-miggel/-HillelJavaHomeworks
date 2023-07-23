package builder;

public class GPSNavigator {
    private String route;

    public GPSNavigator(String route) {
        this.route = route;
    }

    public GPSNavigator() {
        this("No route was set up yet");
    }

    public String getRoute() {
        return route;
    }

    @Override
    public String toString() {
        return "GPSNavigator{" +
                "route='" + route + '\'' +
                '}';
    }
}
