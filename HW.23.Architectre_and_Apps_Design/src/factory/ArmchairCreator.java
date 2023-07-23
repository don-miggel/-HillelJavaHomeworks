package factory;

public class ArmchairCreator extends FurnitureCreator{
    public ArmchairCreator(String name) {
        super(name);
    }

    @Override
    public Furniture createFurnitureItem() {
        return new Armchair(name);
    }
}
