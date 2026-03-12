package brawlstars;

import java.util.ArrayList;

public class Vista {

    public static void mostrarMenu(){
        System.out.print( """
                            \s
                            ---------------------------------------------
                            | 1.  Esborrar directori                    |
                            | 2.  Crear carpeta.                        |
                            | 3.  Copiar estructura carpeta             |
                            | 4.  Crear fitxers                         |
                            | 5.  Moure / Renombrar un fitxer           |
                            | 6.  Llegir linies d'un fitxer             |
                            | 7.  Guarda contingut de Brawlers.txt      |
                            | 8.  Comptar paraules a Brawlers.txt       |
                            | 9.  Mostrar recompenses d'un jugador      |
                            | 10. Generar recompenses especials         |
                            | 0.  Acabar                                |
                            |                                           |
                            | 100. Ver estructura                       |
                            ---------------------------------------------
                           \s
                            Entra una opció (0-10):\s""");
    }

    public static void mostrarMissatge(String m){
        System.out.println(m);
    }
    public static void mostrarMissatge(String m, boolean format){
        System.out.print(m);
    }
    public static void mostrarArrayLineas(ArrayList<String> linies){
        for (int i = 0; i < linies.size(); i++) {
            System.out.println(i + " " + linies.get(i));
        }
    }
}
