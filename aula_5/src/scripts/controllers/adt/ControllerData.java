package scripts.controllers.adt;

import java.util.Calendar;
import java.util.Scanner;
import scripts.chore.adt.Data;


public final class ControllerData
{
    public static void imprimir(Data data)
    {
        System.out.println(String.format("%d/%d/%d", data.dia, data.mes, data.ano));
    }

    public static Data today()
    {
        Calendar c = Calendar.getInstance();

        return new Data(c.get(Calendar.DATE), c.get(Calendar.MONTH), c.get(Calendar.YEAR));
    }

    public static Data inputData()
    {
        Scanner scaner;
        int day, month, year;
        
        scaner = new Scanner(System.in);

        System.out.print("Dia: ");
        day = scaner.nextInt();
        
        System.out.print("\nMês: ");
        month = scaner.nextInt();
        
        System.out.print("\nAno: ");
        year = scaner.nextInt();

        scaner.close();

        return new Data(day, month, year);
    }
}
