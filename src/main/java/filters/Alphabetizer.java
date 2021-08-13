package filters;

import java.util.List;
import java.util.TreeSet;

public class Alphabetizer {

    List<String> circularTitles;
    public Alphabetizer() {
    }
    public Alphabetizer(List<String> circularTitles) {
    this.circularTitles = circularTitles;


    }


    public TreeSet<String>  alfabetizar(){
        TreeSet<String> sortedList = new TreeSet<>();
        for (int i =0;i<this.circularTitles.size();i++){
            sortedList.add(this.circularTitles.get(i));
        }
      return sortedList;
    }
}
