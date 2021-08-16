/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class Buscar {
    
    private List<String> listaBuscar;
    private  List<String> titulo;

    public Buscar(List<String> listaBuscar,List<String> titulo) {
        this.listaBuscar = listaBuscar;
        this.titulo=titulo;
    }

    public List<String> getListaBuscar() {
        return listaBuscar;
    }

    public void setListaBuscar(List<String> listaBuscar) {
        this.listaBuscar = listaBuscar;
    }

    public List<String> getTitulo() {
        return titulo;
    }

    public void setTitulo(List<String> titulo) {
        this.titulo = titulo;
    }
    
    
    
    public List<String> busqueda(List<String> output){
        List<String> resultado=new ArrayList<>();
        
        
        
        for (int i = 0; i < output.size(); i++){
            String fila ="";
            String[] primeraPalabra=output.get(i).split(" ");
            if(this.listaBuscar.contains(primeraPalabra[0])){
                
                for(int j=0; j< primeraPalabra.length; j++){
                    fila += primeraPalabra[j]+" ";
                }
                resultado.add(fila);
            }
        }
        
        return resultado;
        
    }
    
    
    
}
