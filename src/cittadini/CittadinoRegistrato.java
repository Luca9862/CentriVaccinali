package cittadini;

import centrivaccinali.CentroVaccinale;
import eventiavversi.EventoAvverso;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Classe per la gestione dei cittadini che si registrano nel sistema
 *
 * @author Luca Canali
 * @author Ivan Tonolli
 */

public class CittadinoRegistrato {
    /**
     * Nome dell'oggetto Cittadinoregistrato
     */
    String nome;

    /**
     * Codice fiscale dell'oggetto CittadinoRegistrato
     */
    String codicefiscale;

    /**
     * Email dell'oggetto CittadinoRegistrato
     */
    String email;

    /**
     * UserId dell'oggetto CittadinoRegistrato
     */
    String userid;

    /**
     * Password dell'oggetto CittadinoRegistrato
     */
    String password;

    /**
     * Id univoco dell'oggetto CittadinoRegistrato
     */
    short idvaccinazione;
    public static ArrayList<CittadinoRegistrato> listaregistrati = new ArrayList<>();

    /**
     * Metodo costruttore per le istanze della classe CittadinoVaccinato
     *
     * @param nomeCittadino nome del cittadino
     * @param cf codice fiscale
     * @param indirizzoEmail email del cittadino
     * @param uid user-Id del cittadino
     * @param pssw password di accesso
     * @param id id univoco di vaccinazione
     */
    public CittadinoRegistrato(String nomeCittadino, String cf, String indirizzoEmail, String uid, String pssw, short id){
        nome = nomeCittadino;
        codicefiscale = cf;
        email = indirizzoEmail;
        userid = uid;
        password = pssw;
        idvaccinazione = id;
    }

    /**
     * Questo metodo restituisce il campo nome del cittadino
     * @return nome del cittadino
     *
     */
    public String getNome(){ return this.nome;}

    /**
     * Questo metodo restituisce il campo codicefiscale del cittadino
     * @return codice fiscale
     *
     */
    public String getCf(){ return this.codicefiscale;}

    /**
     * Questo metodo restituisce il campo email del cittadino
     * @return email del cittadino
     *
     */
    public String getEmail(){ return this.email;}

    /**
     * Questo metodo restituisce il campo UserId del cittadino
     * @return user-id del cittadino
     *
     */
    public String getUserid(){ return this.userid;}

    /**
     * Questo metodo restituisce il campo password del cittadino
     * @return password per accedere al sistema del cittadino
     *
     */
    public String getPassword(){ return this.password;}

    /**
     * Questo metodo restituisce l'id univoco di vaccinazione
     * @return id univoco
     *
     */
    public String getIdvaccinazione(){ return Short.toString(idvaccinazione);}

    /**
     * Questo metodo converte un oggetto in una stringa contenente i suoi campi
     * @return Stringa informazioni cittadino
     *
     */
    public String toString(){
        return this.nome + "-" + this.codicefiscale + "-" + this.getEmail() + "-" + this.getUserid() + "-" + this.password + "-" + this.idvaccinazione;
    }

    /**
     * Questo verifica se un determinato cittadino è registrato al sistema
     * @param uid user-Id
     * @param pass password
     * @return boolean true/false
     *
     */
    public static boolean login(String uid, String pass) {
        for (int i = 0; i < CittadinoRegistrato.listaregistrati.size(); i++) {
            if (uid.equals(CittadinoRegistrato.listaregistrati.get(i).getUserid()) && pass.equals(CittadinoRegistrato.listaregistrati.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Questo metodo è il main della sottoapplicazione CittadinoRegistrato
     *
     */
    public static void menuCittadinoRegistrato(){
        Scanner in = new Scanner(System.in);
        System.out.println("LOGIN");
        System.out.println();
        System.out.print("User-Id: ");
        String id = in.nextLine();
        System.out.print("Password: ");
        String password = in.nextLine();
        System.out.println();
        if(CittadinoRegistrato.login(id, password)){
            System.out.println("Login effettuato correttamente");
            System.out.println("Ora è possibile compilare il modulo degli eventi avversi ricercando il proprio centro");
            System.out.println();
            System.out.print("Digitare il nome completo del centro in cui si è effettuata la vaccinazione: ");
            String nomecentro = in.nextLine();
            if(CentroVaccinale.centroEsiste(nomecentro)) {
                System.out.println("MODULO SEGNALAZIONE EVENTI AVVERSI POST VACCINO: ");
                System.out.println();
                System.out.print("MAL DI TESTA,");
                System.out.print("Severità: ");
                int severita0 = in.nextInt();
                System.out.print("FEBBRE,");
                System.out.print("Severità: ");
                int severita1 = in.nextInt();
                System.out.print("DOLORI MUSCOLARI,");
                System.out.print("Severità: ");
                int severita2 = in.nextInt();
                System.out.print("LINFOADENOPATIA,");
                System.out.print("Severità: ");
                int severita3 = in.nextInt();
                System.out.print("TACHICARDIA,");
                System.out.print("Severità: ");
                int severita4 = in.nextInt();
                System.out.print("CRISI IPERTENSIVA,");
                System.out.print("Severità: ");
                int severita5 = in.nextInt();

                EventoAvverso eventoMalDiTesta = new EventoAvverso("Mal Di Testa", severita0);
                EventoAvverso eventoFebbre = new EventoAvverso("Febbre", severita1);
                EventoAvverso eventoDoloriMuscolari = new EventoAvverso("Dolori Muscolari", severita2);
                EventoAvverso eventoLinfoAdenopatia = new EventoAvverso("Linfoadenopatia", severita3);
                EventoAvverso eventoTachicardia = new EventoAvverso("Tachicardia", severita4);
                EventoAvverso eventoCrisiIpertensiva = new EventoAvverso("Crisi Ipertensiva", severita5);

                CentroVaccinale.registraEvento(eventoMalDiTesta, nomecentro);
                CentroVaccinale.registraEvento(eventoFebbre, nomecentro);
                CentroVaccinale.registraEvento(eventoDoloriMuscolari, nomecentro);
                CentroVaccinale.registraEvento(eventoLinfoAdenopatia, nomecentro);
                CentroVaccinale.registraEvento(eventoTachicardia, nomecentro);
                CentroVaccinale.registraEvento(eventoCrisiIpertensiva, nomecentro);

                System.out.println();
                System.out.println("Compilazione andata a buon fine");
                System.out.println();
                Cittadino.menuCittadino();
            }

        }else{
            System.out.println("ERRORE: UserId o Password errati");
            System.out.println();
            CittadinoRegistrato.menuCittadinoRegistrato();
        }
    }
}
