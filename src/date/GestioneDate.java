package date;
//classe creata per la gestione delle date. Per evitare di usare le stringhe
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestioneDate {
    public static Date convert(String startDateString){
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date data = new Date("1/1/1975"); //deprecato, da revisionare
        try
        {
            data = (Date)formatter.parse(startDateString);
            return data;
        }
        catch (Exception e)
        {e.printStackTrace();}
        return data;
    }
}
