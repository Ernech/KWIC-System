package filters;

import java.util.List;
import java.util.TreeSet;

public class Output {

  TreeSet<String> sortedList;
    public Output() {

    }
    public Output(TreeSet<String> sortedList) {
this.sortedList = sortedList;
    }

    @Override
    public String toString() {
        return "Output{" +
                "sortedList=" + sortedList +
                '}';
    }
}
