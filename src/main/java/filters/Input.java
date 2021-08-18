package filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Title;


public class Input {


  private  Title[] titles ;//= Arrays.asList("el señor de los anillos", "essentials of bussiness communications");
  //private List<String> nonValueWords;// = Arrays.asList("el","de","los","del","uno","la","al","of");

    /**
     * Constructor para inicalizar los arrays
     */

   /* public Input() {

    }*/

    

    public Input(Title[] titles){
        this.titles = titles;
    }

    public Title[] getTitles() {
        return titles;
    }

    public void setTitles(Title[] titles) {
        this.titles = titles;
    }
    
    

//    public void agregarTitulo(String titulo) {
//        this.titles.add(titulo);
//    }
//    public void agregarPalabraNoClave(String nonValueWord){
//        this.nonValueWords.add(nonValueWord);
//    }
}
