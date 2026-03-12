package objectes;

public class Peix extends Animal{
    public Peix(String nom, int anys) {
        super(nom, anys);
    }

    @Override
    public void moure() {
        System.out.println("Estic nedant");
    }
}
