package modulos;

import java.util.List;
import java.util.TreeSet;

public class Alphabetizer {



    private static void alfabetizar(List<String> circularList){
        TreeSet<String> sortedList = new TreeSet<>();
        for (int i =0;i<circularList.size();i++){
            sortedList.add(circularList.get(i));
        }
        System.out.println("Ordenado: "+sortedList);
    }
}
