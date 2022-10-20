package vaccini;

public enum Vaccino {
    MODERNA, PFIZER, ASTRAZENECA, JOHNSONEJHONSON;

    public String toString(){
        switch (this){
            case MODERNA: return "Moderna";
            case PFIZER: return "Pfizer";
            case ASTRAZENECA: return "Astrazeneca";
            case JOHNSONEJHONSON: return "Jhonson&Jhonson";
            default: return "";
        }
    }

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
