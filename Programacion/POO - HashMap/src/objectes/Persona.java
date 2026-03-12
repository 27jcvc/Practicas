package objectes;

import java.util.ArrayList;

public class Persona {
    private static int id = 0;
    private int identificador;

    private String nif;
    private String nom;
    private String data;
    private int edat;
    private String email;
    private String telefon;


    public Persona(String nif) {
        this.nif = nif;

        identificador = ++id;
    }

    public Persona(String nif, String nom, String email, int edat,String telefon, String data) throws Exception {
        setNif(nif);
        setNom(nom);
        setEmail(email);
        setEdat(edat);
        setTelefon(telefon);
        setData(data);

        /// Es mejor que este al final para que no se incremente id en cualquier caso
        identificador = ++id;

    }

    public int ultimId(){
            return id;
    }


    @Override
    public String toString() {
        return  super.getClass().getSimpleName() + ": " + "\n" +
                "id: " + identificador + "\n" +
                "nif: " + nif + "\n" +
                "nom: " + nom + "\n"  +
                "data: " + data + "\n"  +
                "edat: " + edat + "\n"  +
                "email: " + email + "\n" +
                "telefon: " + telefon + "\n";
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) throws Exception {
        if(nif.matches("^[0-9]{8}[A-Z]$")){
            this.nif = nif;
        } else {
            throw new Exception("Error: Nif malament introduit");
        }

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        if(nom.length() <= 15){
            this.nom = nom;
        } else {
            throw new Exception("Error: Nom malament introduit");
        }
    }

    public String getData() {
        return data;
    }

    /**
     *
     * @param data 2004-05-27
     * @throws Exception
     */
    public void setData(String data) throws Exception {


        if(data.matches("^([1-9][0-9]{3}-[0-9]([1-9]|0)-[0-9]([1-9]|0))|(\\d{2}-\\d{2}-\\d{4})$")){
            this.data = data;
        } else {
            throw new Exception("Error: Data malament introduit");
        }
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) throws Exception {
        if (edat < 0){
            throw new Exception("Error: Edat negativa");
        }
        this.edat = edat;
    }

    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * @throws Exception
     */
    public void setEmail(String email) throws Exception {
        if(email.matches("^.+@.+((\\.cat)|(\\.com))$")) {
            this.email = email;
        } else {
            throw new Exception("Error: Email malament introduit");
        }
    }

    public String getTelefon() {
        return telefon;
    }

    /**
     *
     * @param telefon 555-555-555 +34-555-555-555 || 123456789
     * @throws Exception
     */
    public void setTelefon(String telefon) throws Exception {

        if (!telefon.matches("^(\\+\\d{1,3})?([ -]?)\\d{9}$")){
            throw new Exception("Error: Telefon malament introduit");
        }

        this.telefon = telefon;
    }

}
