package factory;

public class SofaCreator extends FurnitureCreator{
    public SofaCreator(String name) {
        super(name);
    }

    @Override
    public Furniture createFurnitureItem() {
        return new Sofa(name);
    }
}
