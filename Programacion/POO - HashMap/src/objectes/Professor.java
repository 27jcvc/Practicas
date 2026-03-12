package objectes;

public class Professor extends Persona {
    public Professor(String nif) {
        super(nif);
    }

    public Professor(String nif, String nom, String email, int edat, String telefon, String data) throws Exception {
        super(nif, nom, email, edat, telefon, data);
    }

}



