import objectes.Alumne;
import objectes.Persona;
import objectes.Professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Model {

    public static void introduirDades(Scanner scan, HashMap<Integer, Persona> persones, String tipusClase){



        try{
                Persona p;

                String nif = Vista.asignarValor(scan, "Nif: ", false, false);
                String nom = Vista.asignarValor(scan, "Nom: ", false, false);
                int edat = Integer.parseInt(Vista.asignarValor(scan, "Edat: ", false, true));
                String data = Vista.asignarValor(scan, "Data: ", false, false);
                String email = Vista.asignarValor(scan, "Email: ", false, false);
                String telefon = Vista.asignarValor(scan, "Telefon: ", false, false);



           if (tipusClase.equals("Alumne")){
               p = new Alumne (nif, nom, email, edat, telefon, data);
            } else if (tipusClase.equals("Professor")) {
               p = new Professor (nif, nom, email, edat, telefon, data);
            } else {
               throw new Exception("Clase mal introducida");
           }


//            p.setNif(Vista.asignarValor(scan, "Nif: ", false, false));
//            p.setNom(Vista.asignarValor(scan, "Nom: ", false, false));
//            p.setEdat(Integer.parseInt(Vista.asignarValor(scan, "Edat: ", false, true)));
//            p.setData(Vista.asignarValor(scan, "Data: ", false, false));
//            p.setEmail(Vista.asignarValor(scan, "Email: ", false, false));
//            p.setTelefon(Vista.asignarValor(scan, "Telefon: ", false, false));

            persones.put(p.getIdentificador(), p);

        }catch (Exception err){
            System.out.println(err.getMessage());
        }

    }


    public static int buscar(HashMap<Integer, Persona> persones, int identificador){

        for (Persona p : persones.values()){
             if (p.getIdentificador() == identificador){
                return p.getIdentificador();
            }
        }

        return -1;

    }
}
