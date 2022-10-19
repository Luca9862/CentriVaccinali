package centrivaccinali;

import cittadini.CittadinoVaccinato;
import eventiavversi.EventoAvverso;
import gestionefile.GestoreFile;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Classe per la gestione dei centri vaccinali e dei relativi file
 *
 * @author Luca Canali
 * @author Ivan Tonolli
 */

public class CentroVaccinale {
    /**
     * Nome dell'oggetto CentroVaccinale
     */
    public String nome;

    /**
     * qualificatore via dell'oggetto CentroVaccinale
     */
    public String qualificatore;

    /**
     * Nome indirizzo dell'oggetto CentroVaccinale
     */
    public String indirizzo;

    /**
     * Numero indirizzo dell'oggetto CentroVaccinale
     */
    public String numero;

    /**
     * Comune dell'oggetto CentroVaccinale
     */
    public String comune;

    /**
     * Sigla provincia dell'oggetto CentroVaccinale
     */
    public String provincia;

    /**
     * Codice postale dell'oggetto CentroVaccinale
     */
    public String cap;

    /**
     * Tipologia dell'oggetto CentroVaccinale
     */
    public String tipo;

    /**
     * Lista di CittadinoVaccinato dell'oggetto CentroVaccinale
     */
    public ArrayList<CittadinoVaccinato> listavaccinati;

    /**
     * Lista di EventoAvverso dell'oggetto CentroVaccinale
     */
    public EventoAvverso[] tabellaEventi;

    /**
     * Lista di CentroVaccinale appartenente alla classe e non al singolo oggetto
     */
    public static ArrayList<CentroVaccinale> listacentri = new ArrayList<>();

    /**
     * Metodo costruttore per le istanze della classe CittadinoVaccinato
     *
     * @param nomeCentro nome del centro vaccinale
     * @param qualificatoreIndirizzo qualificatore indirizzo
     * @param nomeIndirizzo nome dell'indirizzo
     * @param numeroIndirizzo numero civico
     * @param nomeComune comune del centro
     * @param siglaProvincia provincia del comune
     * @param numeroCap codice postale
     * @param tipoStruttura tipo di centro vaccinale
     */

    public CentroVaccinale(String nomeCentro, String qualificatoreIndirizzo, String nomeIndirizzo, String numeroIndirizzo, String nomeComune, String siglaProvincia, String numeroCap, String tipoStruttura) {
        nome = nomeCentro;
        qualificatore = qualificatoreIndirizzo;
        indirizzo = nomeIndirizzo;
        numero = numeroIndirizzo;
        comune = nomeComune;
        provincia = siglaProvincia;
        cap = numeroCap;
        tipo = tipoStruttura;
        listavaccinati = new ArrayList<>();
        tabellaEventi = new EventoAvverso[6];
    }

    /**
     * Questo metodo restituisce il nome del CentroVaccinale
     * @return String nome del centro
     *
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Questo metodo restituisce il qualificatore del CentroVaccinale
     * @return String qualificatore via del centro
     *
     */
    public String getQualificatore() {
        return this.qualificatore;
    }

    /**
     * Questo metodo restituisce il nome della via del CentroVaccinale
     * @return String nome via del centro
     *
     */
    public String getIndirizzo() {
        return this.indirizzo;
    }

    /**
     * Questo metodo restituisce il numero della via del CentroVaccinale
     * @return String numero del centro
     *
     */
    public String getNumero() {
        return this.numero;
    }

    /**
     * Questo metodo restituisce il comune del CentroVaccinale
     * @return String comune del centro
     *
     */
    public String getComune() {
        return this.comune;
    }

    /**
     * Questo metodo restituisce la sigla della provincia del CentroVaccinale
     * @return String sigla provincia del centro
     *
     */
    public String getProvincia() {
        return this.provincia;
    }

    /**
     * Questo metodo restituisce la tipologia del CentroVaccinale
     * @return String tipo del centro
     *
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * Questo metodo restituisce il codice postale del CentroVaccinale
     * @return String CAP del centro
     *
     */
    public String getCap() {
        return this.cap;
    }

    /**
     * Questo metodo converte un oggetto in una Stringa con i suoi relativi campi
     * @return String CAP del centro
     *
     */
    public String toString() {
        return this.nome + "-" + this.qualificatore + "-" + this.indirizzo + "-" + this.numero + "-" + this.comune + "-" + this.provincia + "-" + this.cap + "-" + this.tipo;
    }

    /**
     * Questo metodo richiama la classe <code>GestoreFile</code> e i suoi relativi metodi. Scopo di questo metodo
     * è registrare il centro vaccinale a sistema
     *
     */
    public void registraCentroVaccinale() {
        GestoreFile gestorecentri = new GestoreFile("data", "Centri_Vaccinali");
        GestoreFile gestorevaccinati = new GestoreFile("data", this.getNome() + "_Vaccinati");
        GestoreFile gestioneeventi = new GestoreFile("data", this.getNome() + "_Eventi_Avversi");
        gestorecentri.verificaPath();
        gestorecentri.verificaTxt();
        gestorevaccinati.verificaTxt();
        gestioneeventi.verificaTxt();
        gestorecentri.scriviTxt(this.toString());
        CentroVaccinale.listacentri.add(this);
    }

    /**
     *  Questo metodo richiama la classe <code>GestoreFile</code> e i suoi relativi metodi. Scopo di questo metodo
     *  è registrare un cittadino vaccinato a sistema
     * @param cittadino - cittadino da registrare nel centro vaccinale corrispondente
     *
     */
    public void registraVaccinato(CittadinoVaccinato cittadino) {
        GestoreFile gestore = new GestoreFile("data", this.getNome() + "_Vaccinati");
        gestore.verificaTxt();
        gestore.scriviTxt(cittadino.toString());
        this.listavaccinati.add(cittadino);
    }

    /**
     * Questo metodo richiama la classe <code>GestoreFile</code> e i suoi relativi metodi. Scopo di questo metodo
     * è sovrascrivere un evento inserito nel suo specifico file di testo
     * @param eventoInserito evento da inserire
     * @param nomeCentro nome del centro in cui inserire gli eventi
     *
     */
    public static void registraEvento(EventoAvverso eventoInserito, String nomeCentro){
        GestoreFile gestore = new GestoreFile("data", nomeCentro + "_Eventi_Avversi");
        gestore.verificaTxt();
        gestore.scriviTxt(eventoInserito.toString());
    }


    /**
     * Questo metodo ha lo scopo di verificare se esiste un centro vaccinale ricevendo come input il nome
     * del centro che si vuole ricercare
     * @param nome nome del centro che si vuole verificare
     * @return boolean vero se il centro esiste, falso se non esiste
     *
     */

    public static boolean centroEsiste(String nome){
        for(int i = 0; i < CentroVaccinale.listacentri.size(); i++){
            if(nome.equals(CentroVaccinale.listacentri.get(i).getNome())){
                return true;
            }
        }
        return false;
    }

    /**
     * main per l'avvio della home
     *
     */

    public static void menuOperatore() {
        Scanner in = new Scanner(System.in);
        System.out.println("MENU' OPERATORE SANITARIO");
        System.out.println("--------------------------");
        System.out.println("REGISTRA CENTRO VACCINALE - 1");
        System.out.println("REGISTRA CITTADINO - 2");

        int scelta = in.nextInt();
        in.nextLine();

        switch (scelta) {
            case 1:
                System.out.println("INSERIRE I DATI DEL CENTRO COME INDICATO");
                System.out.println("(premere invio dopo ogni stringa digitata)");
                System.out.print("NOME: ");
                String nome = in.nextLine();
                System.out.print("QUALIFICATORE VIA (via/piazza/viale): ");
                String qualificatore = in.nextLine();
                System.out.print("NOME VIA: ");
                String via = in.nextLine();
                System.out.print("NUMERO CIVICO: ");
                String numero = in.nextLine();
                System.out.print("COMUNE: ");
                String comune = in.nextLine();
                System.out.print("SIGLA PROVINCIA: ");
                String sigla = in.nextLine();
                System.out.print("CAP: ");
                String cap = in.nextLine();
                System.out.print("TIPOLOGIA (hub/ospedaliero): ");
                String tipologia = in.nextLine();

                CentroVaccinale centro = new CentroVaccinale(nome, qualificatore, via, numero, comune, sigla, cap, tipologia);
                centro.registraCentroVaccinale();

                System.out.println("Centro registrato correttamente");
                System.out.println("DIGITARE 0 PER USCIRE DAL PROGRAMMA, DIGITARE 1 PER TORNARE AL MENU'");
                int scelta2 = in.nextInt();
                if (scelta2 == 1) {
                    System.out.println();
                    CentroVaccinale.menuOperatore();
                } else {
                    break;
                }

            case 2:
                System.out.println("INSERIRE I DATI DEL CITTADINO COME INDICATO");
                System.out.println("(premere invio dopo ogni comando digitato)");
                System.out.print("NOME e COGNOME: ");
                String nomevaccinato = in.nextLine();
                System.out.print("CODICE FISCALE: ");
                String cf = in.nextLine();
                System.out.print("DATA: ");
                String data = in.nextLine();
                System.out.print("VACCINO: ");
                String vaccino = in.nextLine();
                System.out.print("ID vaccinazione: ");
                short id = in.nextShort();
                in.nextLine();
                System.out.println("INSERIRE NOME COMPLETO DEL CENTRO IN CUI REGISTRARE IL CITTADINO: ");
                String nomecentro = in.nextLine();

                if(CentroVaccinale.centroEsiste(nomecentro)){
                    CittadinoVaccinato vaccinato = new CittadinoVaccinato(nomevaccinato, cf, data, vaccino, id);
                    for(int i = 0; i < listacentri.size(); i++) {
                        if (nomecentro.equals(CentroVaccinale.listacentri.get(i).getNome())) {
                            if (CittadinoVaccinato.idOccupato(id, CentroVaccinale.listacentri.get(i))) {
                                System.out.println("ERRORE: IdVaccinazione occupato");
                                System.out.println("Ritorno al menù, iniziare nuovamente la registrazione");
                                CentroVaccinale.menuOperatore();
                            } else {
                                CentroVaccinale.listacentri.get(i).registraVaccinato(vaccinato);
                                System.out.print("Cittadino registrato correttamente. Digitare 1 per tornare al menu' operatore, digitare 0 per uscire dall'applicazione: ");
                                int scelta3 = in.nextInt();
                                if (scelta3 == 1) {
                                    System.out.println();
                                    CentroVaccinale.menuOperatore();
                                } else if (scelta3 == 0) {
                                    break;
                                }
                            }
                        }
                    }

                }else {
                    System.out.println("ERRORE: Si sta tentando la registrazione ad un centro che non esiste. Ritorna al menu e riprova");
                    System.out.println();
                    CentroVaccinale.menuOperatore();
                }
        }

    }
}
