package objectes;

public class TestPersona {
    public static void main(String[] args) throws Exception {

        Persona p1 = new Persona("12345678B");
        Persona p2 = new Persona("12345678A","Ruperto","j.vazquez@sapalomera.cat",21 ,"+34-999-999-999", "2004-05-27");
        Persona p3 = new Persona("12345678A","Ruperto", "27-05-2004", 21, "j.vazquez@sapalomera.cat", "+34-999-999-999");

//        modificarNom(p1, "Pere");
//        modificarNif(p1, "12345678B");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

    }

    public static void modificarNom(Persona p, String nom){
        try{
            p.setNom(nom);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void modificarNif(Persona p, String nif){
        try{
            p.setNif(nif);
        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
