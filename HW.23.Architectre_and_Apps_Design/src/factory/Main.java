package factory;

public class Main {
    public static void main(String[] args) {

        Furniture sofa = new SofaCreator("Black Leather").createFurnitureItem();
        sofa.printFurnitureType();
        Furniture armchair = new ArmchairCreator("Brown Swivel Textile").createFurnitureItem();
        armchair.printFurnitureType();
        Furniture cupboard = new CupboardCreator("Two meter high light brown pantry").createFurnitureItem();
        cupboard.printFurnitureType();


    }

}
