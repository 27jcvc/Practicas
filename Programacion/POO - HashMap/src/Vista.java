import objectes.Alumne;
import objectes.Persona;

import java.util.*;

public class Vista {

    public static void mostrarMenu(){
        System.out.println("""
                            1. Introduir Dades
                            2. Modificar Dades
                            3. Llistar
                            0. Sortir
                            """);
    }

    public static void mostrarSubMenuLlistar(){
        System.out.println("""
                            1. Llistar Alumnes
                            2. Llistar Professors
                            3. Llistar tot
                            0. Tornar
                            """);
    }

    public static void mostrarMissatge(String missatge, boolean saltLinea){
        if (saltLinea){
            System.out.println(missatge);
        } else {
            System.out.print(missatge);
        }
    }

    public static String asignarValor(Scanner scan, String missatge, boolean saltLinea, boolean number){

        Vista.mostrarMissatge(missatge, saltLinea);
        String input = scan.nextLine();

        if (number){
            try{
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Error: No has introduit un numero");
            }
        }
        return input;
    }

    public static void mostrarPersones(HashMap<Integer, Persona> arrayPersones){


    }

    public static void mostrarHashMap(HashMap<Integer, Persona> persones, boolean saltLinea){
         Object[] valors = persones.keySet().toArray();

//        for (Object v : valors){
//            Vista.mostrarMissatge(persones.get(v).toString(), saltLinea);
//        }

        Collection<Persona> a = persones.values();
//        System.out.println(a);

// 1. Obtenemos el iterador una sola vez
        Iterator<Persona> it = a.iterator();

// 2. Usamos la MISMA instancia para preguntar y para avanzar
        while(it.hasNext()){
            Persona p = it.next(); // .next() devuelve el objeto y avanza la posición
            System.out.println(p);
        }




//        ArrayList a array
//        AL = new ArrayList<> (Arrays.asList(arr))

        /**
         * Con el super puedo acceder a
         *
         * Si tengo una super clase en protected
         * - Puedo acceder desde cualquier subclase
         *
         * En cambio, si tengo la super clase en private
         * - No puedo acceder desde ninguna superclase
         */
    }



    public static void mostrarAlumnes(HashMap<Integer, Persona> persones){

        Object[] valors = persones.keySet().toArray();
        int qt = 0;

        for (Object v : valors){
            Persona p = persones.get(v);

            /// Verificar si es de la clase alumno
            if (p instanceof Alumne){
                Vista.mostrarMissatge(p.toString(), true);
                qt++;
            }

            if (qt == 0){
                Vista.mostrarMissatge("No s'han trobat dades", true);
            }
        }

//            if (persones.get(v).getClass().getSimpleName().equals("Alumne"))
//                Vista.mostrarMissatge(persones.get(v).toString(), true);

    }

    public static void mostrarProfessors(HashMap<Integer, Persona> persones){

           Object[] valors = persones.keySet().toArray();

           for (Object v : valors){
               if (persones.get(v).getClass().getSimpleName().equals("Professor"))
                   Vista.mostrarMissatge(persones.get(v).toString(), true);
           }

    }



}

