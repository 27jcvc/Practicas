import objectes.*;

import java.util.ArrayList;

///  Todo lo que no sean objetos, debe ir con static
public class zooModel {
    protected static  ArrayList<Animal> animals = new ArrayList<>();

    public static ArrayList<Animal> getAnimals() {
        return animals;
    }



    public static void iniDades(ArrayList<Animal> animals){
// Peces (Peix)
        animals.add(new Peix("Dory", 1));
        animals.add(new Peix("Bruce", 15));
        animals.add(new Peix("Bubbles", 3));

// Mamíferos (Mamifer)
        animals.add(new Mamifer("Simba", 4));
        animals.add(new Mamifer("Bambi", 2));
        animals.add(new Mamifer("Dumbo", 1));
        animals.add(new Mamifer("Baloo", 10));

// Pájaros (Ocell)
        animals.add(new Ocell("Iago", 35)); // ¡Los loros viven mucho!
        animals.add(new Ocell("Hedwig", 6));
        animals.add(new Ocell("Scuttle", 4));
    }

}
