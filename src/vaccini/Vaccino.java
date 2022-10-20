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
        return switch (this) {
            case MODERNA -> "Moderna";
            case PFIZER -> "Pfizer";
            case ASTRAZENECA -> "Astrazeneca";
            case JOHNSONEJHONSON -> "Jhonson&Jhonson";
        };
    }

    /**
     * Questo metodo converte un oggetto STRING in un oggetto VACCINO
     * @return String
     */
    public static Vaccino toVaccino(String nome){
        return switch (nome) {
            case "Moderna" -> MODERNA;
            case "Pfizer" -> PFIZER;
            case "Astrazeneca" -> ASTRAZENECA;
            case "Johnson&Johnson" -> JOHNSONEJHONSON;
            default -> null;
        };
    }
}
