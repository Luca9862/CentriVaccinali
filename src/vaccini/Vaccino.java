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
}
