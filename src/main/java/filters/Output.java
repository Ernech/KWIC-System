package filters;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Output {

  TreeSet<String> sortedList;
    public Output() {

    }
    public Output(TreeSet<String> sortedList) {
this.sortedList = sortedList;
    }
    
    public String getOutput(){
        Iterator<String> itr = this.sortedList.iterator(); 
        String aux="";
        while (itr.hasNext()) { 
            aux+=itr.next()+"\n";
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
