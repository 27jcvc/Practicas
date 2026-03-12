package brawlstars;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String opcio;

        do{
            Vista.mostrarMenu();
            opcio = scan.nextLine();

            try{
                comprovacionsMenu(Integer.parseInt(opcio));
            } catch (NumberFormatException e) {
                Vista.mostrarMissatge("Error: Has de introduir una opció entre (0-10)");
            }  catch (IOException e) {
                Vista.mostrarMissatge(e.getMessage());
            }

        }while(!opcio.equals("0"));

        scan.close();
    }


public static void programaPrincipal() throws IOException {
    String opcio;
    do{

        Vista.mostrarMenu();
        opcio = scan.nextLine();

        switch (Integer.parseInt(opcio)){
            case 1:
                MainExercicis.esborrarDirectori("Brawlers");
                break;
            case 2:
                MainExercicis.crearDirectori("Brawlers");
                MainExercicis.crearDirectori("Brawlers/Tank");
                MainExercicis.crearDirectori("Brawlers/Tank/Legendary");
                MainExercicis.crearDirectori("Brawlers/Tank/Epic");

                MainExercicis.crearDirectori("Brawlers/Artillery");
                MainExercicis.crearDirectori("Brawlers/Artillery/Mythic");
                MainExercicis.crearDirectori("Brawlers/Artillery/SuperRare");

                break;
            case 3:
//               TODO:
                MainExercicis.crearDirectori("Brawlers/Assasin");
                MainExercicis.copiarEstructura("Brawlers/Tank", "Brawlers/Assasin");
                break;
            case 4:
                MainExercicis.crearFitxers("Brawlers/Tank/Legendary", new String[]{"Draco.stats", "Meg.stats"});
                MainExercicis.crearFitxers("Brawlers/Tank/Epic", new String[]{"Hank.stats", "Ash.stats"});

                MainExercicis.crearFitxers("Brawlers/Artillery/Mythic", new String[]{"Sprout", "Juju"});
                MainExercicis.crearFitxers("Brawlers/Artillery/SuperRare", new String[]{"Dynamike"});

                MainExercicis.crearFitxers("Brawlers/Assasin/Legendary", new String[]{"Kenji"});
                break;
            case 5:
                MainExercicis.moureRenombrarFitxer("Brawlers/Artillery/Mythic/Juju.stats", "Brawlers/Artillery/JujuBackup.stats");
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 0:
                Vista.mostrarMissatge("Tancant programa...");
                break;
            default:
                Vista.mostrarMissatge("Error: Opcio malament introduida");

        }

    }while(!opcio.equals("0"));

    // TODO: Pensar la forma de seguir con el bucle sin que se termine cuando lanze una excepcion
//
}

public static void comprovacionsMenu(int opcio) throws IOException {
    switch (opcio){
        case 1:
            MainExercicis.esborrarDirectori("Brawlers");
            break;
        case 2:
            MainExercicis.crearDirectori("Brawlers");
            MainExercicis.crearDirectori("Brawlers/Tank");
            MainExercicis.crearDirectori("Brawlers/Tank/Legendary");
            MainExercicis.crearDirectori("Brawlers/Tank/Epic");

            MainExercicis.crearDirectori("Brawlers/Artillery");
            MainExercicis.crearDirectori("Brawlers/Artillery/Mythic");
            MainExercicis.crearDirectori("Brawlers/Artillery/SuperRare");

            break;
        case 3:
            MainExercicis.crearDirectori("Brawlers/Assasin");
            MainExercicis.copiarEstructura("Brawlers/Tank", "Brawlers/Assasin");
            break;
        case 4:
            MainExercicis.crearFitxers("Brawlers/Tank/Legendary", new String[]{"Draco.stats", "Meg.stats"});
            MainExercicis.crearFitxers("Brawlers/Tank/Epic", new String[]{"Hank.stats", "Ash.stats"});

            MainExercicis.crearFitxers("Brawlers/Artillery/Mythic", new String[]{"Sprout", "Juju"});
            MainExercicis.crearFitxers("Brawlers/Artillery/SuperRare", new String[]{"Dynamike"});

            MainExercicis.crearFitxers("Brawlers/Assasin/Legendary", new String[]{"Kenji"});
            break;
        case 5:
            MainExercicis.moureRenombrarFitxer("Brawlers/Artillery/Mythic/Juju.stats", "Brawlers/Artillery/JujuBackup.stats");
            break;
        case 6:

            MainExercicis.tractarParaules("Practica/Brawlers.txt", 5);
            break;
        case 7:
            MainExercicis.crearDirectori("Practica/AltresArxius");
            MainExercicis.crearFitxers("Practica/AltresArxius", new String[]{"BrawlerInfo.stats", "BrawlerResum.stats"});
            MainExercicis.desarDades("Practica/Brawlers.txt", "Practica/AltresArxius/BrawlerInfo.stats",  "Practica/AltresArxius/BrawlerResum.stats");
            break;
        case 8:
            MainExercicis.comptarParaules("Practica/Brawlers.txt", "Super");
            break;
        case 9:
            MainExercicis.mostraRecompensesResumides();
            break;
        case 10:
            MainExercicis.mostraRecompensesEspecials();
            break;
        case 100:
            MainExercicis.llistarEstructura("Brawlers");
            break;
        case 0:
            Vista.mostrarMissatge("Tancant programa...");
            break;
        default:
            Vista.mostrarMissatge("Error: Opcio malament introduida");
    }
}
}