package objectes;

public class Animal {

    protected String nom;
    protected int anys;

    public Animal(String nom, int anys) {
        this.nom = nom;
        this.anys = anys;
    }

    public void moure(){
        System.out.println("M'estic movent");
    }
    /// Getters
    public String getNom() {
        return nom;
    }

    public int getAnys() {
        return anys;
    }


    ///  Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAnys(int anys) {
        this.anys = anys;
    }

    @Override
    public String toString() {
        return "nom: " + nom + '\n' +
                "anys: " + anys + "\n" + "-".repeat(10);
    }
}
