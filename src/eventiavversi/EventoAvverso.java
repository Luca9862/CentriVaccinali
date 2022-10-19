package eventiavversi;

/**
 *
 * Questa classe rappresenta un Evento Avverso come un oggetto
 *
 * @author Luca Canali
 * @author Ivan Tonolli
 *
 */

public class EventoAvverso {
    /**
     * Nome dell'oggetto EventoAvverso
     */
    private String nome;

    /**
     * Severità dell'oggetto EventoAvverso
     */
    private int severita;

    /**
     * Metodo costruttore per le istanze della classe CittadinoVaccinato
     *
     * @param nomeEvento nome dell'evento
     * @param severitaEvento serverità dell'evento
     */
    public EventoAvverso(String nomeEvento, int severitaEvento){
        nome = nomeEvento;
        if(severitaEvento < 5) {
            severita = severitaEvento;
        }
        else severita = 5;
    }

    /**
     * Questo metodo converte un EventoAvverso in una stringa con i relativi campi
     * @return Stringa
     *
     */
    public String toString(){return this.nome + "-" + this.severita;}

    /**
     * Questo metodo restituisce il campo nome dell'Evento
     * @return Stringa nome dell'evento
     *
     */
    public String getNome(){return this.nome;}

    /**
     * Questo metodo restituisce il campo severità dell'Evento
     * @return Stringa severità dell'evento
     *
     */
    public String getSeverita(){return Integer.toString(this.severita);}

}
