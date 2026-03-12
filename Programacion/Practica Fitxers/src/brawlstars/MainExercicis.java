package brawlstars;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class MainExercicis {

    // TODO: Ver estructura entera
    // Ens permet veure la estructura dels arxius i carpetes
    public static void llistarEstructura(String nomDirectori){
        File f = new File(nomDirectori.trim());
        llistarEstructura(f);
    }

    public static void llistarEstructura(File f){
        if (!f.exists()) {
            System.out.println("Directori: " + f.getName() + " inexistent.");
            return;
        }

        // 1. Obtener la lista y convertirla a una lista modificable
        List<File> elementos = new ArrayList<>(FileUtils.listFilesAndDirs(
                f, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE));

        // 2. Ordenar por ruta (para que los padres salgan antes que los hijos)
        Collections.sort(elementos, Comparator.comparing(File::getAbsolutePath));

        String rutaBase = f.getAbsolutePath();

        for (File elemento : elementos) {
            // Ignorar la propia raíz si no quieres que salga como el primer elemento
            if (elemento.equals(f)) continue;

            // Calcular profundidad relativa para la sangría
            String rutaRelativa = elemento.getAbsolutePath().substring(rutaBase.length());
            long nivel = rutaRelativa.chars().filter(ch -> ch == File.separatorChar).count();

            String sangria = "  ".repeat((int) nivel);
            String tipo = elemento.isDirectory() ? "[DIR] " : "[FILE] ";

            System.out.println(sangria + tipo + elemento.getName());
        }
    }
    // TODO: --------------------------------------------------


    // TODO: Ex1
    public static void esborrarDirectori(String nomDirectori) throws IOException {
        File f = new File(nomDirectori.trim());
        esborrarDirectori(f);
    }

    public static void esborrarDirectori(File f) throws IOException {
        if (!f.exists()) {
            Vista.mostrarMissatge(String.format("Error: Fitxer %s no existeix.", f.getName()));
            return;
        }

        FileUtils.deleteDirectory(f);
        Vista.mostrarMissatge(String.format("Directori: %s eliminat correctament.", f.getName()));
    }

    // TODO: Ex1 --------------------------------------------------------------------------------


    // TODO: Ex2
    public static void crearDirectori(String nomDirectori) throws IOException {
        File f = new File(nomDirectori.trim());
        crearDirectori(f);
    }

    public static void crearDirectori(File f) throws IOException {
        if (f.exists()) {
            Vista.mostrarMissatge(String.format("Error: Fitxer %s existent",f.getName()));
            return;
        }

        f.mkdirs();
//        FileUtils.createParentDirectories(f);
        Vista.mostrarMissatge(String.format("Directori: %s creat correctament.", f.getName()));
    }

    // TODO: Ex2 --------------------------------------------------------------------------------


    // TODO: Ex3
    public static void copiarEstructura(String origen, String desti) throws IOException {
        File o = new File(origen.trim());
        File d = new File(desti.trim());

        copiarEstructura(o, d);
    }
    public static void copiarEstructura(File origen, File desti) throws IOException {

        if (!origen.exists()) {
            Vista.mostrarMissatge("Error: ruta origen inexistent");
            return;
        }

        if (!desti.exists()){
            Vista.mostrarMissatge("Error: ruta desti inexistent");
            return;
        }

        FileUtils.copyDirectory(origen, desti);
        Vista.mostrarMissatge("Estructura copiada correctament.");

    }

    // TODO: Ex3 --------------------------------------------------------------

    // TODO: Ex4

    public static void crearFitxers(String rutaCarpeta, String[] nomFitxers) throws IOException {

        File ruta = new File(rutaCarpeta.trim());
        if (!ruta.exists()){
            Vista.mostrarMissatge("Error: La ruta no existeix");
            return;
        }

        crearFitxers(ruta, nomFitxers);
    }

        public static void crearFitxers(File rutaCarpeta, String[] nomFitxers) throws IOException {



            for (String nom : nomFitxers){
                nom = nom.trim();
                nom += (!nom.matches("\\w+\\.stats$")) ? ".stats" : "";

                if (nom.isBlank()){
                    Vista.mostrarMissatge(String.format("Error: Fitxer %s no creat.",nom));
                    continue;
                }

                String rutaFitxer = rutaCarpeta.getPath() + "\\" + nom;
                File rFitxer = new File(rutaFitxer);

                if (rFitxer.exists()){
                    Vista.mostrarMissatge(String.format("Error: Fitxer %s existent.",nom));
                    continue;
                }

                File f = new File(rutaCarpeta, nom);
                FileUtils.touch(f);

                Vista.mostrarMissatge(String.format("Fitxer: %s creat correctament",nom));
            }

        }


    // TODO: Ex4 --------------------------------------------------------------------------------

    // TODO: Ex5

    public static void moureRenombrarFitxer(String fitxerOrigen, String carpetaDesti) throws IOException {
        File f = new File(fitxerOrigen.trim());
        File c = new File(carpetaDesti.trim());

        moureRenombrarFitxer(f, c);
    }

    public static void moureRenombrarFitxer(File fitxerOrigen, File carpetaDesti) throws IOException {

        if (!fitxerOrigen.exists()){
            Vista.mostrarMissatge("Fitxer d'origen inexistent");
            return;
        }

        FileUtils.moveFile(fitxerOrigen, carpetaDesti);
        Vista.mostrarMissatge("Funció efectuada correctament.");
    }

    // TODO: Ex5 --------------------------------------------------------------------------------


// TODO: Arxius de text----------------------------------------------------------------

    // TODO: Ex6 -------------------------------------

    public static ArrayList<String> desarLinies(String arxiu) throws FileNotFoundException {
        File f = new File(arxiu);
        return desarLinies(f);
    }

    public static ArrayList<String> desarLinies(File arxiu) throws FileNotFoundException {
        Scanner reader = new Scanner(arxiu);
        ArrayList<String> linies = new ArrayList<>();

        while (reader.hasNextLine()) {
            String liniaActual = reader.nextLine();

            if (!liniaActual.trim().isEmpty()) {
                linies.add(liniaActual);
            }
        }

        reader.close();

        return linies;
    }


    public static void tractarParaules(String arxiu, int linia) throws FileNotFoundException {
        File f = new File(arxiu);
        tractarParaules(f, linia);
    }

    public static void tractarParaules(File arxiu, int linia) throws FileNotFoundException {
        ArrayList<String> linies = desarLinies(arxiu);
        ArrayList<String> paraulesAmbMajus = new ArrayList<>();
        int paraulesTotals = 0;

        if (linia - 1 < 0 || linia - 1 >= linies.size()){
            Vista.mostrarMissatge("linia fora del margen");
            return;
        }

        String liniaQueVolem = "";
        liniaQueVolem = linies.get(linia - 1);
        Scanner reader = new Scanner(liniaQueVolem);

        while(reader.hasNext()){
            String p = reader.next();

            if (p.matches("^[A-Z].*")) paraulesAmbMajus.add(p);
            ++paraulesTotals;
        }
        reader.close();

        String m = "";

        m += String.format( "Paraules totals: %d%n" +
                        "Paraules amb majuscula: %n",
                paraulesTotals);

        for (String e : paraulesAmbMajus){
            m += e + "\n";
        }

        Vista.mostrarMissatge(m);


    }


    // TODO: Ex6 ----------------------

    /* TODO: Ex7 ----------------------------------------
        7. Guarda contingut de "Brawlers.txt" en altres arxius.
        La primera línia s'ha de guardar en un fitxer anomenat BrawlerInfo.stats.
        La resta de línies que no estiguin buides s'han de guardar en BrawlerResum.stats.
    */

    public static void desarDades(String arxiuLlegible, String nomFitxerGuardatPrimeraLinea, String nomFitxerGuardatRestesLineas) throws FileNotFoundException {
        File a = new File(arxiuLlegible);
        File nFgPL = new File(nomFitxerGuardatPrimeraLinea);
        File nFgRl = new File(nomFitxerGuardatRestesLineas);

        desarDades(a, nFgPL, nFgRl);

    }

    public static void desarDades(File arxiuLlegible, File nomFitxerGuardatPrimeraLinea, File nomFitxerGuardatRestesLineas) throws FileNotFoundException {

        if (!arxiuLlegible.exists()){
            Vista.mostrarMissatge(String.format("Error: Fitxer %s inexistent", arxiuLlegible));
            return;
        }

        if (!nomFitxerGuardatPrimeraLinea.exists()){
            Vista.mostrarMissatge(String.format("Error: Fitxer %s inexistent", nomFitxerGuardatPrimeraLinea));
            return;
        }

        if (!nomFitxerGuardatRestesLineas.exists()){
            Vista.mostrarMissatge(String.format("Error: Fitxer %s inexistent", nomFitxerGuardatRestesLineas));
            return;
        }

            ArrayList<String> linies = desarLinies(arxiuLlegible);

            Scanner reader = new Scanner(arxiuLlegible);
            PrintStream writer = new PrintStream(nomFitxerGuardatPrimeraLinea);

            writer.println(linies.getFirst());

            writer = new PrintStream(nomFitxerGuardatRestesLineas);


            for (int i = 1; i < linies.size(); i++) {
                String liniaActual = linies.get(i).trim();

                if (liniaActual.isBlank()) {
                    continue;
                }

                writer.print(linies.get(i) + "\n");
            }

                reader.close();
                writer.close();

        Vista.mostrarMissatge(String.format("Fitxer: %s llegit correctament",   arxiuLlegible.getName()));
        Vista.mostrarMissatge(String.format("Fitxer: %s guardat correctament",   nomFitxerGuardatPrimeraLinea.getName()));
        Vista.mostrarMissatge(String.format("Fitxer: %s guardat correctament",   nomFitxerGuardatRestesLineas.getName()));


    }



    // TODO: Ex7 ----------------------


    // TODO: Ex8 --------------------------------------------------------------

        public static void comptarParaules(String fitxer, String paraula) throws FileNotFoundException {
            File f = new File(fitxer);
            comptarParaules(f, paraula);
        }

        public static void comptarParaules(File fitxer, String paraula) throws FileNotFoundException {

            ArrayList<String> linies = desarLinies(fitxer);
            int qtVegades = 0;

            ArrayList<Integer> liniesCoincident = new ArrayList<>();

            for (int i = 0; i < linies.size(); i++) {
                if ((!linies.get(i).contains(paraula))){
                    continue;
                }

                // El único cambio real: sumamos cuántas veces aparece en esta línea
                qtVegades += linies.get(i).split(paraula, -1).length - 1;
                liniesCoincident.add(i+1);
            }

//            liniesCoincident.add(i+1);
            Vista.mostrarMissatge(String.format("Total vegades: %s%nLinies: %s",qtVegades, liniesCoincident));

        }

    // TODO: Ex8 ----------------------

    // TODO: Ex9 --------------------------------------------------------------


    public static void mostraRecompensesResumides() throws FileNotFoundException {

        File fRewards = new File("Practica/Rewards.csv");
        if (!fRewards.exists()){
            Vista.mostrarMissatge(String.format("Error: Fitxer %s inexistent", fRewards.getName()));
            return;
        }

        ArrayList<String> linies = desarLinies(fRewards);

        Scanner reader = new Scanner(fRewards);
        String[] pLinia = linies.getFirst().split(";");

        Scanner scan = new Scanner(System.in);
        Vista.mostrarMissatge("Introdueix el nom: ");
        String nom = scan.nextLine().trim();
        nom = String.valueOf(nom.charAt(0)).toUpperCase() + nom.substring(1).toLowerCase();

        String[][] arrayBi = new String[linies.size()][];
        boolean trobat = false;

        for (int i = 1; i < linies.size(); i++) {
            arrayBi[i] = linies.get(i).trim().split(";");
            if(trobat) break;

            for (int j = 1; j < 5; j++) {
//                System.out.println(i + ": " + pLinia[j]);
                if (arrayBi[i][1].equals(nom)) {
                    Vista.mostrarMissatge(String.format("%-30s: %s", pLinia[j], arrayBi[i][j]));
                    trobat = true;
                }
            }
        }

        if (!trobat) Vista.mostrarMissatge(String.format("Jugador: %s no trobat", nom));
        reader.close();
    }




    // TODO: Ex9 ----------------------

    // TODO: Ex10 -----------------------------------------------------------

    public static void mostraRecompensesEspecials() throws FileNotFoundException {

        File fRewards = new File("Practica/Rewards.csv");
        File fSpecialRewards = new File("Practica/AltresArxius/SpecialRewards.csv");

        if (!fRewards.exists()){
            Vista.mostrarMissatge(String.format("Error: Fitxer %s inexistent", fRewards.getName()));
            return;
        }

        if (!fSpecialRewards.exists()){
            Vista.mostrarMissatge(String.format("Error: Fitxer %s inexistent", fSpecialRewards.getName()));
            return;
        }

        ArrayList<String> linies = desarLinies(fRewards);

        Scanner reader = new Scanner(fRewards);
        PrintStream writer = new PrintStream(fSpecialRewards);

        String[] pLinia = linies.getFirst().split(";");
        int[] idxRecompEspecials = new int[]{1,2,5,8};

        String[][] arrayBi = new String[linies.size()][];

        for (int i = 1; i < linies.size(); i++) {
            arrayBi[i] = linies.get(i).trim().split(";");

            for (int j : idxRecompEspecials) {
                writer.printf("%-30s: %s%n",pLinia[j],arrayBi[i][j]);
            }
            writer.println();
        }

//        System.out.println(i + ": " + pLinia[idxRecompEspecials[i]]);
//        int[] idxRecompensesEspecials = new int[]{1,2,5,8};
        /*
            1: Player Name
            2: Special Coins Earned
            3: Gems Purchased
            4: Rare Brawlers Unlocked
            5: Legendary Brawlers Unlocked
            6: Power Points Earned
            7: Total Trophies
            8: Wins in Special Modes
            9: Star Skin Unlocked

        * */

        writer.close();
        reader.close();
    }
        // TODO: Ex10 ----------------------

}
