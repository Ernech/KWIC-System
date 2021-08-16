package filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifting {

    private List<String> titulo;
    private List<String> palabrasNoClave;


    public CircularShifting() {

    }

    public CircularShifting(List<String> titulo, List<String> palabrasNoClave) {
        this.titulo = titulo;
        this.palabrasNoClave = palabrasNoClave;
    }

    private  List<String> keywords(List<String> titulo, List<String> palabrasNoClave){
        List<String> palabras = new ArrayList<>();
        
        for(int i=0;i<titulo.size();i++){
            String [] tituloArray = titulo.get(i).split(" ");
            
            for(int j =0;j<tituloArray.length;j++){
            if(!palabrasNoClave.contains(tituloArray[j])){

                  if(!palabras.contains(tituloArray[j])){
                    palabras.add(tituloArray[j]);
                      System.out.println(tituloArray[j]);
                }
                }
                
                
            }
        }
        
        
        
       System.out.println(palabras);
        return palabras;
    }
    public   List<String> indexList(List<String> titulo){
        List<String> indList=new  ArrayList<>();
        
        for(int k=0;k<titulo.size();k++){
        String tituloRorate = titulo.get(k).concat(" /");
        String [] line = tituloRorate.split(" ");
        String [][] output = new String[line.length][line.length];
        //System.out.println("\nThe circular shifted lines are :");
        for (int i = 0; i < line.length; i++){
            String aux="";
            for (int j = 0; j < line.length; j++) {
                output[i][j] = line[(i + j) % line.length];
                aux+=output[i][j]+" ";
                
              //  System.out.print(output[i][j] + " ");
            }
            indList.add(aux);
           // System.out.println("\n");
        }  
        }
        
        return  indList;
    }

    public  List<String> circularShiftsProcess(){
        List<String> keywords = this.keywords(this.titulo,this.palabrasNoClave);
        List<String> output= this.indexList(this.titulo);
        List<String> circularList = new ArrayList<>();
        for (int i = 0; i < output.size(); i++){
            String fila ="";
            String[] primeraPalabra=output.get(i).split(" ");
            if(keywords.contains(primeraPalabra[0])){
                
                for(int j=0; j< primeraPalabra.length; j++){
                    fila += primeraPalabra[j]+" ";
                }
                circularList.add(fila);
            }
        }
        return circularList;
    }

}
