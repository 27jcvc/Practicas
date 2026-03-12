import objectes.Alumne;
import objectes.Persona;
import objectes.Professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Controlador {

    static Scanner scan = new Scanner(System.in);

    static String resposta = "";

    public static void main(String[] args) {

//        La key de los Set Acostumbran a ser int o strings
//      persona.keySet().toArray();

        ArrayList<Persona> personesAL = new ArrayList<>();
        HashMap<Integer, Persona> personaHM = new HashMap<>();


//        persona.keySet() retorna todas las Keys

        iniDades(personesAL, personaHM);

        do {
            Vista.mostrarMenu();
            resposta = scan.nextLine();

            switch (resposta){
                case "1":
                    subMenuIntroduirDades(personaHM);
                    break;
                case "2":
//                   Modificar Persones
                    modificarDades(personaHM);
                    break;
                case "3":
//                    Llistar persones
                    subMenuLlistar(personaHM);
                    break;
                case "0":
                    break;
                default:
                    Vista.mostrarMissatge("Error: Resposta malament introduida", true);
            }
        }while(!resposta.equals("0"));

    }

    public static void subMenuLlistar(HashMap<Integer, Persona> persones){


        do {

            Vista.mostrarSubMenuLlistar();
            resposta = scan.nextLine();

        switch (resposta){
            case "1":
                Vista.mostrarAlumnes(persones);
                break;
            case "2":
                Vista.mostrarProfessors(persones);
                break;
            case "3":
                Vista.mostrarHashMap(persones, true);
                break;
            case "0":
                break;
            default:
                Vista.mostrarMissatge("Error: Resposta malament introduida", true);
        }



        }while(!resposta.equals("0"));

        resposta = "";

    }

    public static void subMenuIntroduirDades(HashMap<Integer, Persona> persones){


        do {
            Vista.mostrarMissatge("""
                                          Que vols introduir?
                                          1. Alumne
                                          2. Professor
                                          3. Tornar
                                          """, true);
            resposta = scan.nextLine();

            switch (resposta){
                case "1":
                    Model.introduirDades(scan, persones, "Alumne");
                    break;
                case "2":
                    Model.introduirDades(scan, persones, "Professor");
                    break;
                case "3":
                    break;
                default:
                    Vista.mostrarMissatge("Error: Resposta malament introduida", true);
            }



        }while(!resposta.equals("3"));

        resposta = "";

    }

    public static void subMenuModificarDades(HashMap<Integer, Persona> persones){


        do {
            Vista.mostrarMissatge("""
                                          Que vols introduir?
                                          1. Alumne
                                          2. Professor
                                          3. Tornar
                                          """, true);
            resposta = scan.nextLine();

            switch (resposta){
                case "1":
                    modificarDades(persones);
                    break;
                case "2":

                    break;
                case "3":
                    break;
                default:
                    Vista.mostrarMissatge("Error: Resposta malament introduida", true);
            }



        }while(!resposta.equals("3"));

        resposta = "";

    }

    public static void iniDades(ArrayList<Persona> persones, HashMap<Integer, Persona> persona){
        try{
//          HashMap
            Persona p = null;
            p = new Alumne("23456789B", "Marta", "m.garcia@mail.cat", 22, "987654321", "15-02-2003");
            persona.put(p.getIdentificador(), p);
            p = new Alumne("34567890C", "Oriol", "o.vidal@mail.cat", 20, "654321987", "30-11-2005");
            persona.put(p.getIdentificador(), p);
            p = new Alumne("45678901D", "Laia", "l.roca@mail.cat", 21, "741852963", "12-08-2004");
            persona.put(p.getIdentificador(), p);


            p = new Professor("12345678A", "Joan", "j.canals@professor.cat", 50, "600111222", "12-05-1975");
            persona.put(p.getIdentificador(), p);
            p = new Professor("23456789B", "Elena", "e.martinez@professor.cat", 43, "611222333", "24-08-1982");
            persona.put(p.getIdentificador(), p);
            p = new Professor("34567890C", "Xavier", "x.garcia@professor.cat", 56, "622333444", "03-01-1970");
            persona.put(p.getIdentificador(), p);

//            Vista.mostrarHashMap(persona, false);

//          --------------

//          ArrayList
//            persones.add(new Alumne("23456789B", "Marta", "m.garcia@mail.cat", 22, "987654321", "15-02-2003"));
//            persones.add(new Alumne("34567890C", "Oriol", "o.vidal@mail.cat", 20, "654321987", "30-11-2005"));
//            persones.add(new Alumne("45678901D", "Laia", "l.roca@mail.cat", 21, "741852963", "12-08-2004"));
//            persones.add(new Alumne("56789012E", "Pau", "p.ferrer@mail.cat", 24, "852963741", "05-01-2002"));
//            persones.add(new Alumne("67890123F", "Júlia", "j.serra@mail.cat", 22, "963741852", "22-04-2003"));
//            persones.add(new Alumne("78901234G", "Marc", "m.soler@mail.cat", 20, "159263487", "19-09-2005"));
//            persones.add(new Alumne("89012345H", "Aina", "a.vila@mail.cat", 21, "357159486", "03-07-2004"));
//            persones.add(new Alumne("90123456I", "Pol", "p.font@mail.cat", 24, "951753468", "14-12-2001"));
//            persones.add(new Alumne("01234567J", "Carla", "c.mas@mail.cat", 23, "753159842", "28-06-2002"));
//            persones.add(new Alumne("11223344K", "Albert", "a.puig@mail.cat", 20, "123123123", "10-03-2005"));
//
//            persones.add(new Professor("12345678A", "Joan", "j.canals@professor.cat", 50, "600111222", "12-05-1975"));
//            persones.add(new Professor("23456789B", "Elena", "e.martinez@professor.cat", 43, "611222333", "24-08-1982"));
//            persones.add(new Professor("34567890C", "Xavier", "x.garcia@professor.cat", 56, "622333444", "03-01-1970"));
//            persones.add(new Professor("45678901D", "Sílvia", "s.rodriguez@professor.cat", 37, "633444555", "15-11-1988"));
//            persones.add(new Professor("56789012E", "Albert", "a.serra@professor.cat", 46, "644555666", "30-06-1979"));
//            persones.add(new Professor("67890123F", "Mireia", "m.vidal@professor.cat", 34, "655666777", "21-03-1991"));
//            persones.add(new Professor("78901234G", "Ricard", "r.vila@professor.cat", 60, "666777888", "09-09-1965"));
//            persones.add(new Professor("89012345H", "Anna", "a.lopez@professor.cat", 40, "677888999", "27-12-1985"));
//            persones.add(new Professor("90123456I", "Jordi", "j.sanchez@professor.cat", 52, "688999000", "14-02-1973"));
//            persones.add(new Professor("01234567J", "Carme", "c.pujol@professor.cat", 45, "699000111", "05-07-1980"));
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }


    public static void modificarDades(HashMap<Integer, Persona> persones){

        for (Persona p : persones.values()){

            String m =  String.format("%s%nId: %s%nNif: %s%n",
                    p.getClass().getSimpleName(),
                    p.getIdentificador(),
                    p.getNif());

            Vista.mostrarMissatge(m, true);
        }

        ///  le doy el identificador
        int idBuscat = Model.buscar(persones, demanarNumEnter());

        if (persones.containsKey(idBuscat)){
            Vista.mostrarMissatge("Deja en blanco para conservar el actual", true);

            Persona p = persones.get(idBuscat);
            Vista.mostrarMissatge(String.format("Nif: [%s] ",p.getNif()), false);
            String nif = scan.nextLine();
            nif = (nif.isBlank())? p.getNif() : nif;

            Vista.mostrarMissatge(String.format("Nom: [%s] ",p.getNom()), false);
            String nom = scan.nextLine();
            nom = (nom.isBlank()) ? p.getNom() : nom;

            Vista.mostrarMissatge(String.format("Data: [%s] ",p.getData()), false);
            String data = scan.nextLine();
            data = (data.isBlank()) ? p.getData() : data;

            Vista.mostrarMissatge(String.format("Edat: [%s] ",p.getEdat()), false);
            String edat = scan.nextLine();
            edat = (edat.isBlank()) ? String.valueOf(p.getEdat()) : edat;

            Vista.mostrarMissatge(String.format("Email: [%s] ",p.getEmail()), false);
            String email = scan.nextLine();
            email = (email.isBlank()) ? p.getEmail() : email;

            Vista.mostrarMissatge(String.format("Telefon: [%s] ",p.getTelefon()), false);
            String telefon = scan.nextLine();
            telefon = (telefon.isBlank()) ? p.getTelefon() : telefon;

            try{
                p.setNif(nif);
                p.setNom(nom);
                p.setData(data);
                p.setEdat(Integer.parseInt(edat));
                p.setEmail(email);
                p.setTelefon(telefon);

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        String m = """
                    Deja en blanco para conservar el actual
                    Nif:     [Actual] _
                    Nom:     [Actual] _
                    Data:    [Actual] _
                    Edat:    [Actual] _
                    Email:   [Actual] _
                    Telefon: [Actual] _
                   """;



    }


    public static void esborrarDades(HashMap<Integer, Persona> persones){

    }
    public static int demanarNumEnter(){
        int num;

        while (true){

            try{
                Vista.mostrarMissatge("Introdueix un numero enter: ", true);
                num = Integer.parseInt(scan.nextLine());

                return num;
            } catch (NumberFormatException e) {
                System.out.println("No has introduit un numero enter!");
                continue;
            }
        }

    }
}


















//      Private atributs
//      PUBLIC funcions
//      protected contrassenya