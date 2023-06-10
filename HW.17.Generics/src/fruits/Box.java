package fruits;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruits;

    public Box(){
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public void addFruit(T...fruits){
        this.fruits.addAll(List.of(fruits));
    }

    public float getWeight(){
        float sum = 0.0f;
        for(Fruit fruit : fruits)
            sum += fruit.getWeight();
        return sum;
    }

    public boolean compare(Box<? extends Fruit> box){
        return getWeight() == box.getWeight();
    }

    private List<T> getFruits(){ return fruits; }

    private void emptyBox(){ fruits.clear();}

    public void merge(Box<T> otherBox){
        fruits.addAll(otherBox.getFruits());
        otherBox.emptyBox();
    }

    @Override
    public String toString() {
        if (fruits.isEmpty())
            return "Box is empty";
        // Get the type contained in the list
        String className = fruits.get(0).getClass().toString();
        // extract class name
        className = className.substring(className.lastIndexOf('.')+1);
        // make proper view for plural
        className = fruits.size() > 1 ? className.concat("s") : className;
        return "The box contains "+ fruits.size()+" "+ className.toLowerCase();
    }

}
