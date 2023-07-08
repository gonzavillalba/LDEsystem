package org.lde.model;

import java.util.ArrayList;
import java.util.List;

public class ClasePrueba {
    List<Integer>integerList;

    public ClasePrueba() {
        integerList = new ArrayList<>();
        funcionInfinita();
    }

    public void funcionInfinita(){
        int cont = 0;
        for (Integer recorrido:integerList) {
            integerList.add(cont++);
            System.out.println(integerList);
        }

    }
}
