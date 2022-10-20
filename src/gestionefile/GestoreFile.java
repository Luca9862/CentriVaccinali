package gestionefile;

import centrivaccinali.CentroVaccinale;
import cittadini.CittadinoRegistrato;
import cittadini.CittadinoVaccinato;
import date.GestioneDate;
import vaccini.Vaccino;

import java.io.*;

/**
 *
 * Questa classe svolge molte operazioni che si occupano di gestire la scrittura/lettura dei txt
 * e la gestione della relazione tra oggetti e file
 *
 * @author Luca Canali
 */

public class GestoreFile {
    /**
     * Percorso della directory data
     */
    private final String pathData;

    /**
     * Percorso del file txt
     */
    private final String f;

    /**
     * Metodo costruttore per le istanze della classe CittadinoVaccinato
     *
     * @param nomePath directory nella quale saranno salvati i file txt
     * @param txt      file txt
     */

    public GestoreFile(String nomePath, String txt) {
        pathData = System.getProperty("user.dir") + File.separator + nomePath;
        f = txt;
    }

    /**
     * Questo metodo verifica se una determinata directory esiste. Se non esiste la crea
     *
     */

    public void verificaPath() {
        File path = new File(this.pathData);
        if (!path.exists()) {
            path.mkdir();
        }
    }

    /**
     * Questo metodo verifica se un determinato file txt esiste. Se non esiste lo crea
     *
     */

    public void verificaTxt() {
        File txt = new File(this.pathData + File.separator + this.f + ".txt");
        if (!txt.exists()) {
            try {
                txt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Questo metodo scrive la stringa ricevuta come parametro in uno specifico file txt
     *
     * @param s stringa che verrà scritta nel txt
     *
     */

    public void scriviTxt(String s) {
        File txt = new File(this.pathData + File.separator + this.f + ".txt");
        try {
            FileWriter writerlista = new FileWriter(txt, true);
            BufferedWriter wrl = new BufferedWriter(writerlista);
            wrl.write(s);
            wrl.newLine();
            wrl.flush();
            wrl.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo che legge il file txt dei centri vaccinali e per ogni riga crea un oggetto che
     * verrà aggiunto alla lista dei centri già registrati a sistema
     *
     */

    public static void setCentri() {
        File f = new File("data" + File.separator + "Centri_Vaccinali.txt");
        if(f.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("data" + File.separator + "Centri_Vaccinali.txt"));
                String riga = reader.readLine();
                while (riga != null) {
                    String[] dato = riga.split("-");
                    CentroVaccinale c = new CentroVaccinale(dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], dato[6], dato[7]);
                    CentroVaccinale.listacentri.add(c);
                    riga = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo che legge tutti i file txt relativi ai vaccinati.
     * Per ogni riga viene creato un oggetto che viene aggiunto alla lista dei vaccinati
     * del proprio centro
     *
     */

    public static void setVaccinati() {
        for (int i = 0; i < CentroVaccinale.listacentri.size(); i++) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("data" + File.separator + CentroVaccinale.listacentri.get(i).getNome() + "_Vaccinati.txt"));
                String riga = reader.readLine();
                while (riga != null) {
                    String[] dato = riga.split("-");
                    short id = Short.parseShort(dato[4]);
                    CittadinoVaccinato vaccinato = new CittadinoVaccinato(dato[0], dato[1], GestioneDate.convert(dato[2]), Vaccino.toVaccino(dato[3]), id);
                    CentroVaccinale.listacentri.get(i).listavaccinati.add(vaccinato);
                    riga = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo che legge il file txt relativo ai cittadini registrati.
     * Per ogni riga viene creato un oggetto che viene aggiunto alla lista dei cittadini già registrati a sistema
     *
     */

    public static void setRegistrati() {
        File registrati = new File("data" + File.separator + "Cittadini_Registrati.txt");
        if(registrati.exists()){
            try {
                BufferedReader reader = new BufferedReader(new FileReader("data" + File.separator + "Cittadini_Registrati.txt"));
                String riga = reader.readLine();
                while (riga != null) {
                    String[] dato = riga.split("-");
                    short id = Short.parseShort(dato[5]);
                    CittadinoRegistrato registrato = new CittadinoRegistrato(dato[0], dato[1], dato[2], dato[3], dato[4], id);
                    CittadinoRegistrato.listaregistrati.add(registrato);
                    riga = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo che legge un intero File txt e lo stampa a terminale
     *
     */

    public static void stampaTxt(File txt){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(txt));
            String riga = reader.readLine();
            while (riga != null) {
                System.out.println(riga);
                System.out.println();
                riga = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
