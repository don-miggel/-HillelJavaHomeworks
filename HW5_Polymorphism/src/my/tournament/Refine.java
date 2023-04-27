package my.tournament;

public interface Refine {

    default String getRefinedClassName() {
        String className = getClass().getName();
        return className.substring(className.lastIndexOf('.') + 1);
    }
}
