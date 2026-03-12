package objectes;

public class Ocell extends Animal{
    public Ocell(String nom, int anys) {
        super(nom, anys);
    }

    @Override
    public void moure() {
        super.moure();
        System.out.println("Estic volant");
    }
}
