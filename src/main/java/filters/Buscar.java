/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author diego
 */
public class Buscar {
    
    private List<String> listaBuscar;

    public Buscar(List<String> listaBuscar) {
        this.listaBuscar = listaBuscar;
    }

    public List<String> getListaBuscar() {
        return listaBuscar;
    }

    public void setListaBuscar(List<String> listaBuscar) {
        this.listaBuscar = listaBuscar;
    }


    
    
    
    public List<String> busqueda(String termino){
        List<String> resultado;
        
        if(termino==null || termino.isEmpty()){
            resultado=this.listaBuscar;
        }
        else{
         resultado = listaBuscar.stream().filter(titulo-> titulo.contains(termino.trim())).collect(Collectors.toList());
        }
        
        return resultado;
        
    }
    
    
    
}
