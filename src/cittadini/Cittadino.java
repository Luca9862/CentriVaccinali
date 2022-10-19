package cittadini;

import centrivaccinali.CentroVaccinale;
import gestionefile.GestoreFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * Classe per la gestione di un cittadino che accede al sistema
 * Questa classe contiene anche il metodo main della sottoapplicazione Cittadino
 *
 * @author Luca Canali
 */

public class Cittadino {
    /**
     * Nome dell'oggetto Cittadino
     */
    String nome;

    /**
     * Metodo costruttore per le istanze della classe CittadinoVaccinato
     *
     * @param nomecittadino nome del cittadino
     */

    public Cittadino(String nomecittadino) {
        nome = nomecittadino;
    }

    /**
     * Questo metodo cerca tutti i centri vaccinali registrati nel cui nome compaia la il parametro di ricerca
     * @param ricerca nome del centro da cercare
     * @return ArrayList contente tutti i centri in cui compaia il parametro precedente
     *
     */

    public static ArrayList<CentroVaccinale> ricercaPerNome(String ricerca) {
        ArrayList<CentroVaccinale> risultati = new ArrayList<>();
        for (int i = 0; i < CentroVaccinale.listacentri.size(); i++) {
            if (CentroVaccinale.listacentri.get(i).getNome().contains(ricerca)) {
                risultati.add(CentroVaccinale.listacentri.get(i));
            }
        }
        return risultati;
    }

    /**
     * Questo metodo restituisce tutti i centri vaccinali di un determinato comune e di una determinata tipologia
     * @param comune nome del comune
     * @param tipologia tipo dei centri da ricercare
     * @return ArrayList contente tutti i centri in cui compaia il parametro precedente
     *
     */

    public static ArrayList<CentroVaccinale> ricercaPerComuneTipo(String comune, String tipologia) {
        ArrayList<CentroVaccinale> risultati = new ArrayList<>();
        for (int i = 0; i < CentroVaccinale.listacentri.size(); i++) {
            if (CentroVaccinale.listacentri.get(i).getComune().contains(comune) && CentroVaccinale.listacentri.get(i).getTipo().equals(tipologia)) {
                risultati.add(CentroVaccinale.listacentri.get(i));
            }
        }
        if (risultati.isEmpty())
            System.out.println("Nessun centro trovato");

        return risultati;
    }

    /**
     * Questo metodo permette di selezionare un centro vaccinale dopo una ricerca per visualizzare le informazioni
     * @param risultati Array che contiene tutti i risultati di una determinata ricerca
     * @param selezione nome del centro che si desidera selezionare
     * @return Stringa che rappresenta il centro selezionato con le sue informazioni
     *
     */

    public static String visualizzaInfoCentroVaccinale(ArrayList<CentroVaccinale> risultati, String selezione) {
        String infoCentro = "";
        for (CentroVaccinale centroVaccinale : risultati) {
            if (selezione.equals(centroVaccinale.getNome())) {
                infoCentro = centroVaccinale.toString();
                File f = new File("data" + File.separator + centroVaccinale.getNome() + "_Eventi_Avversi.txt");
                GestoreFile.stampaTxt(f);
            }
        }
        return infoCentro;
    }

    /**
     * Questo metodo permette a un cittadino di registrarsi al sistema.
     * Viene creato un Cittadino Registrato che viene aggiunto alla lista dei registrati.
     * I dati del cittadino registrato vengono scritti nel file relativo ai registrati.
     * @param centro centro vaccinale in cui si vuole effettuare la registrazione
     * @param nome nome del cittadino
     * @param cf codice fiscale del cittadino
     * @param email email del cittadino
     * @param userid userId scelto dal cittadino
     * @param pssw password impostata dal cittadino
     * @param id id univoco Vaccinazione del cittadino
     * @return boolean
     */

    public static boolean registraCittadino(CentroVaccinale centro, String nome, String cf, String email, String userid, String pssw, short id) {
        GestoreFile gestore = new GestoreFile("data", "Cittadini_Registrati");
        CittadinoRegistrato cr = new CittadinoRegistrato(nome, cf, email, userid, pssw, id);
        boolean existId = false;
        for (int i = 0; i < centro.listavaccinati.size(); i++) {
            if (cr.getIdvaccinazione().equals(centro.listavaccinati.get(i).getIdVaccinazione())) {
                existId = true;
            }
        }
        if (existId) {
            CittadinoRegistrato.listaregistrati.add(cr);
            gestore.verificaTxt();
            gestore.scriviTxt(cr.toString());
        }
        return existId;
    }

    /**
     * Questo metodo contiene il main della sottoapplicazione Cittadino
     *
     */

    public static void menuCittadino() {
        Scanner in = new Scanner(System.in);
        System.out.println("MENU' CITTADINO");
        System.out.println("--------------------------");
        System.out.println("RICERCA CENTRO VACCINALE - 1");
        System.out.println("REGISTRATI AL TUO CENTRO (Id Vaccinazione richiesto) - 2");
        System.out.println("LOGIN - 3");


        int scelta = in.nextInt();
        in.nextLine();

        switch (scelta) {
            case 1:
                System.out.println("COME SI VUOLE EFFETTUARE LA RICERCA? Nome-1 ; Comune e tipo-2");
                System.out.println();
                int sceltaRicerca = in.nextInt();
                in.nextLine();
                if (sceltaRicerca == 1) {
                    System.out.print("DIGITARE IL NOME DA RICERCARE: ");
                    String nomeRicerca = in.nextLine();
                    System.out.println();
                    System.out.println("Risultati ricerca: ");
                    ArrayList<CentroVaccinale> centriTrovati = Cittadino.ricercaPerNome(nomeRicerca);
                    for (CentroVaccinale centroVaccinale : centriTrovati) {
                        System.out.println(centroVaccinale.toString());
                    }
                    System.out.println();
                    System.out.print("DIGITARE IL NOME DEL CENTRO CHE SI VUOLE SELEZIONARE: ");
                    String nomecentro = in.nextLine();
                    if (Cittadino.visualizzaInfoCentroVaccinale(centriTrovati, nomecentro).equals("")) {
                        System.out.println("ERRORE: stai scegliendo un centro che non esiste.");
                        System.out.println("Ritorno al menu' cittadino, puoi iniziare una nuova ricerca da lì");
                        System.out.println();
                        Cittadino.menuCittadino();
                    }
                } else if (sceltaRicerca == 2) {
                    System.out.println("DIGITARE IL COMUNE: ");
                    String comune = in.nextLine();
                    System.out.println("DIGITARE LA TIPOLOGIA DEL CENTRO: ");
                    String tipologia = in.nextLine();
                    ArrayList<CentroVaccinale> centriTrovati = Cittadino.ricercaPerComuneTipo(comune, tipologia);
                    for (CentroVaccinale centroVaccinale : centriTrovati) {
                        System.out.println(centroVaccinale.toString());
                    }
                    System.out.println();
                    System.out.println("DIGITARE IL NOME DEL CENTRO CHE SI VUOLE SELEZIONARE");
                    String nomecentro = in.nextLine();
                    if (Cittadino.visualizzaInfoCentroVaccinale(centriTrovati, nomecentro).equals("")) {
                        System.out.println("ERRORE: stai scegliendo un centro che non esiste.");
                        System.out.println("Ritorno al menu' cittadino, puoi iniziare una nuova ricerca da lì");
                        System.out.println();
                        Cittadino.menuCittadino();
                    }
                }
                break;

            case 2:
                System.out.println("Per registrarsi ad un centro vaccinale è necessario un Id vaccinazione");
                System.out.print("DIGITARE NOME COMPLETO DEL CENTRO IN CUI SI E' EFFETTUATA LA VACCINAZIONE: ");
                String nomecentro = in.nextLine();
                if(CentroVaccinale.centroEsiste(nomecentro)) {
                    Cittadino.ricercaPerNome("NomeCentro");
                    System.out.println("DIGITARE DATI RICHIESTI (Premere invio dopo ogni dato inserito)");
                    System.out.print("NOME E COGNOME: ");
                    String nomeregistrato = in.nextLine();
                    System.out.print("CODICE FISCALE: ");
                    String codicefiscale = in.nextLine();
                    System.out.print("INDIRIZZO E-MAIL: ");
                    String email = in.nextLine();
                    System.out.println("CREARE UN USER-ID PER IL LOGIN: ");
                    String userid = in.nextLine();
                    System.out.println("CREARE UNA PASSWORD: ");
                    String password = in.nextLine();
                    System.out.println("INSERIRE ID VACCINAZIONE: ");
                    short idvaccinazione = in.nextShort();

                    for(int i = 0; i < CentroVaccinale.listacentri.size(); i++){
                        if(nomecentro.equals(CentroVaccinale.listacentri.get(i).getNome())){
                            if(Cittadino.registraCittadino(CentroVaccinale.listacentri.get(i), nomeregistrato,codicefiscale,email,userid,password,idvaccinazione)){
                                System.out.println("Cittadino registrato correttamente.");
                                System.out.println("Ora è possibile compilare il modulo degli eventi avversi.");
                            }else{
                                System.out.println("ERRORE: Id vaccinazione inesistente nel centro selezionato");
                                System.out.println("Ritenta la registrazione");
                            }
                            System.out.println();
                            Cittadino.menuCittadino();
                            break;
                        }
                    }

                }
                else{
                    System.out.println("ERRORE: Il centro selezionato non esiste. Ritorno al menù cittadino.");
                    System.out.println("Si può iniziare una nuova ricerca da lì.");
                    System.out.println();
                    Cittadino.menuCittadino();
                    break;
                }

            case 3:
                CittadinoRegistrato.menuCittadinoRegistrato();
        }
    }
}
