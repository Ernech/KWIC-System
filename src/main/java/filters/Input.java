package filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Input {


  private  List<String> titles ;//= Arrays.asList("el señor de los anillos", "essentials of bussiness communications");
    private List<String> nonValueWords;// = Arrays.asList("el","de","los","del","uno","la","al","of");

    /**
     * Constructor para inicalizar los arrays
     */

   /* public Input() {

    }*/

    public Input() {
        this.titles = new ArrayList<>();
        this.nonValueWords = new ArrayList<>();
    }
    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getPalabrasNoClave() {
        return nonValueWords;
    }

    public void setPalabrasNoClave(List<String> nonValueWords) {
        this.nonValueWords = nonValueWords;
    }

    public void agregarTitulo(String titulo){
        this.titles.add(titulo);
    }
    public void agregarPalabraNoClave(String nonValueWord){
        this.nonValueWords.add(nonValueWord);
    }
}
