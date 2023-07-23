package factory;

public abstract class FurnitureCreator {

    protected String name;

    public FurnitureCreator(String name){
        this.name = name;
    }
    public abstract Furniture createFurnitureItem();
}
