package factory;

public abstract class Furniture {

    private String name;

    public Furniture(String name){
        this.name = name;
    }
    public void printFurnitureType(){
        String className = this.getClass().getName();
        className = className.substring(className.lastIndexOf('.')+1);
        System.out.println("This item is "+this.getFurnitureName()+ " "+className);
    };

    private String getFurnitureName(){
        return name;
    };
}
