import objectes.*;

import java.util.ArrayList;

public class zooController {
    public static void main(String[] args) {

        ArrayList<Animal> animals = zooModel.getAnimals();

        zooModel.iniDades(animals);

        for (Animal a : animals){
            a.moure();
            System.out.println(a);
        }

    }
}