package modulos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Input {

    List<String> titles = Arrays.asList("el señor de los anillos", "essentials of bussiness communications");
    List<String> palabrasNoClave = Arrays.asList("el","de","los","del","uno","la","al","of");

    /**
     * Constructor para inicalizar los arrays
     */
/*
    public Input() {
        this.titles = new ArrayList<>();
        this.palabrasNoClave = new ArrayList<>();
    }*/

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getPalabrasNoClave() {
        return palabrasNoClave;
    }

    public void setPalabrasNoClave(List<String> palabrasNoClave) {
        this.palabrasNoClave = palabrasNoClave;
    }

    public void agregarTitulo(String titulo){
        this.titles.add(titulo);
    }
    public void agregarPalabraNoClave(String palabraNoClave){
        this.titles.add(palabraNoClave);
    }
}
