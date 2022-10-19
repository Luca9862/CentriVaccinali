package cittadini;

import centrivaccinali.CentroVaccinale;

/**
 *
 * Classe per la gestione dei cittadini che sono stati vaccinati
 *
 * @author Luca Canali
 */

public class CittadinoVaccinato{
    /**
     * Nome dell'oggetto CittadinoVaccinato
     */
    String nome;

    /**
     * Codice fiscale dell'oggetto CittadinoVaccinato
     */
    String codicefiscale;

    /**
     * Data dell'oggetto CittadinoVaccinato
     */
    String data;

    /**
     * Tipo vaccino dell'oggetto CittadinoVaccinato
     */
    String vaccino;

    /**
     * Id univoco dell'oggetto CittadinoVaccinato
     */
    short idvaccinazione;

    /**
     * Metodo costruttore per le istanze della classe CittadinoVaccinato
     *
     * @param nomeVaccinato nome del vaccinato
     * @param cf codice fiscale
     * @param dataVaccino data vaccino
     * @param tipoVaccino tipo di vaccino
     * @param id id vaccinazione
     */

    public CittadinoVaccinato(String nomeVaccinato, String cf, String dataVaccino, String tipoVaccino, short id) {
        nome = nomeVaccinato;
        codicefiscale = cf;
        data = dataVaccino;
        vaccino = tipoVaccino;
        idvaccinazione = id;
    }

    /**
     *
     * Questo metodo restituisce il nome del cittadino tramite String
     * @return nome del cittadino
     *
     */

    public String getNome() {
        return this.nome;
    }

    /**
     *
     * Questo metodo restituisce il codice fiscale tramite String
     * @return codice fiscale
     *
     */

    public String getCf() {
        return this.codicefiscale;
    }

    /**
     *
     * Questo metodo restituisce la data di vaccinazione tramite String
     * @return data di vaccinazione
     *
     */

    public String getDate(){return this.data; }

    /**
     *
     * Questo metodo restituisce il tipo di vaccino
     * @return tipo di vaccino
     *
     */

    public String getVaccino() {
        return this.vaccino;
    }

    /**
     *
     * Questo metodo restituisce l'id univoco di vaccinazione del vaccinato
     * @return id numerico univoco
     *
     */

    public String getIdVaccinazione(){return Short.toString(idvaccinazione);}

    /**
     *
     * Questo metodo converte in Stringa l'intero oggetto
     * @return tipo di vaccino
     *
     */

    public String toString(){
        return this.getNome() + "-" + this.getCf() + "-" + this.getDate() + "-" + this.getVaccino() + "-" +  this.getIdVaccinazione();
    }

    /**
     * Questo metodo verifica se l'id ricevuto come parametro
     * è già occupato in un determinato centro vaccinale
     * @param id id da verificare
     * @param centro centro in cui cercare l'id
     * @return boolean
     *
     */

    public static boolean idOccupato(short id, CentroVaccinale centro){
        for(int i = 0; i < centro.listavaccinati.size(); i++){
            if(id == centro.listavaccinati.get(i).idvaccinazione){
                return true;
            }
        }
        return false;
    }
}
