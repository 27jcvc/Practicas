package objectes;

public class Alumne extends Persona{


    public Alumne(String nif) {
        super(nif);
    }

    public Alumne(String nif, String nom, String email, int edat, String telefon, String data) throws Exception {
        super(nif, nom, email, edat, telefon, data);
    }
}
