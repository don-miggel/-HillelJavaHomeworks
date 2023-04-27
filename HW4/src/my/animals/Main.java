package my.animals;

public class Main {
    public static void main(String[] args) {
        Animal fido = new Cat("Fido");
        Animal petty = new Cat("Petty");
        Animal spike = new Dog("Spike");
        Animal pluto = new Dog("Pluto");
        Animal bobik = new Dog("Bobik");


        spike.run(250);
        fido.run(189);
        pluto.swim(11);
        pluto.swim(10);
        bobik.run(501);
        bobik.run(499);
        petty.swim(5);
        petty.run(201);
        petty.run(125);
        Animal.getAnimalCount();
        Cat.getCatCount();
        Dog.getDogCount();
    }

}
