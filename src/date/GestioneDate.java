package date;
//classe creata per la gestione delle date. Per evitare di usare le stringhe
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestioneDate {
    public static Date convert(String dateString){
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date data = new Date();
        try
        {
            data = (Date) formatter.parse(dateString);
        }
        catch (Exception e)
        {e.printStackTrace();}
        return data;
    }
}
