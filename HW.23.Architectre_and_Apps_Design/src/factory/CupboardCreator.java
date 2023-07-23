package factory;

public class CupboardCreator extends FurnitureCreator{
    public CupboardCreator(String name) {
        super(name);
    }

    @Override
    public Furniture createFurnitureItem() {
        return new Cupboard(name);
    }
}
