package centrivaccinali;

import cittadini.Cittadino;
import gestionefile.GestoreFile;
import java.util.Scanner;

/**
 * Questa classe contiene il metodo main del progetto
 *
 * @author Luca Canali
 */
public class CentriVaccinali {
    public static void main(String [] args) {
        home();
    }

    /**
     * Questo metodo è il main per l'esecuzione
     *
     */

    public static void home() {
        GestoreFile.setCentri();
        GestoreFile.setVaccinati();
        GestoreFile.setRegistrati();
        Scanner in = new Scanner(System.in);

        System.out.println("CENTRI VACCINALI - HOME");
        System.out.println("-----------------------");
        System.out.println("Accedi come: ");
        System.out.println();
        System.out.println("OPERATORE SANITARIO - 1");
        System.out.println("CITTADINO - 2");

        int scelta = in.nextInt();

        switch (scelta) {
            case 1 -> CentroVaccinale.menuOperatore();
            case 2 -> Cittadino.menuCittadino();
        }
    }
}
