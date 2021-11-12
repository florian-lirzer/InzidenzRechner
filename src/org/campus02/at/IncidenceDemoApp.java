package org.campus02.at;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class IncidenceDemoApp
{
    public static void main(String[] args)
    {
        Incidence steiermark20211111 = new Incidence("Steiermark", "2021-11-11", 1300);
        Incidence steiermark20211110 = new Incidence("Steiermark", "2021-11-10", 1100);
        Incidence steiermark20211109 = new Incidence("Steiermark", "2021-11-09", 1250);
        Incidence wien20211111 = new Incidence("Wien", "2021-11-11", 3000);
        Incidence wien20211110 = new Incidence("Wien", "2021-11-10", 2350);
        Incidence wien20211109 = new Incidence("Wien", "2021-11-09", 2557);

        ArrayList<Incidence> recordedValues = new ArrayList<>();
        recordedValues.add(steiermark20211111);
        recordedValues.add(steiermark20211110);
        recordedValues.add(steiermark20211109);
        recordedValues.add(wien20211111);
        recordedValues.add(wien20211110);
        recordedValues.add(wien20211109);
        recordedValues.add(new Incidence("Tirol", "2021-11-11", 2999));

        System.out.println("Count of recorded Records = " + recordedValues.size());
        
        int countTotalIncidences = 0;
        
        for (Incidence incidence : recordedValues)
        {
            countTotalIncidences += incidence.getNumber();
        }
        System.out.println("countTotalIncidences = " + countTotalIncidences);

        //iter für foreach-Schleife

        HashMap<String, Integer> totalIncidencesState = new HashMap<>(); //Anzahl der Fälle je Bundesland

        for (Incidence recordedValue : recordedValues)
        {
            /*
            1. Ist mein Key bereits in der Liste
                2. wenn nein, dann muss ich Key aufnehmen
                3. wenn ja, dann Wert auslesen, summieren und neu ablegen
             */
            if(totalIncidencesState.containsKey(recordedValue.getState()))
            {
                int currentValue = totalIncidencesState.get(recordedValue.getState());
                currentValue += recordedValue.getNumber();
                totalIncidencesState.put(recordedValue.getState(), currentValue);
            }
            else
            {
                totalIncidencesState.put(recordedValue.getState(), recordedValue.getNumber());
            }
        }
        System.out.println("totalIncidencesState = " + totalIncidencesState);
    }
}
