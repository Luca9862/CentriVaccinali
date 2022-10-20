package vaccini;

/**
 *
 * Classe enum per la gestione dei tipi di vaccino
 *
 * @author Luca Canali
 */

public enum Vaccino {
    /**
     * Costanti enumerative
     */
    MODERNA, PFIZER, ASTRAZENECA, JOHNSONEJHONSON;

    /**
     * Questo metodo converte un oggetto VACCINO in STRING
     * @return String
     */
    public String toString(){
        switch (this){
            case MODERNA: return "Moderna";
            case PFIZER: return "Pfizer";
            case ASTRAZENECA: return "Astrazeneca";
            case JOHNSONEJHONSON: return "Jhonson&Jhonson";
            default: return "";
        }
    }

    /**
     * Questo metodo converte un oggetto STRING in un oggetto VACCINO
     * @return String
     */
    public static Vaccino toVaccino(String nome){
        switch (nome){
            case "Moderna": return MODERNA;
            case "Pfizer": return PFIZER;
            case "Astrazeneca": return ASTRAZENECA;
            case "Johnson&Johnson": return JOHNSONEJHONSON;
            default: return null;

        }
    }
}
