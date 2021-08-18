package filters;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import models.Title;

public class Output {

    Title[] sortedList;
    public Output() {

    }
    public Output(Title[] sortedList) {
this.sortedList = sortedList;
    }
    
    public String getOutput(){
        String aux="";
        for (int i=0;i<this.sortedList.length;i++) { 
            aux+=this.sortedList[i].getTitle()+"\n";
        }
        return aux;
    }

    @Override
    public String toString() {
        return "Output{" +
                "sortedList=" + sortedList +
                '}';
    }
}
