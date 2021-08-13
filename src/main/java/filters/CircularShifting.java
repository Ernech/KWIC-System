package filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularShifting {

    private String titulo;
    private List<String> palabrasNoClave;


    public CircularShifting() {

    }

    public CircularShifting(String titulo, List<String> palabrasNoClave) {
        this.titulo = titulo;
        this.palabrasNoClave = palabrasNoClave;
    }

    private  List<String> keywords(String titulo, List<String> palabrasNoClave){
        String [] tituloArray = titulo.split(" ");
        List<String> palabras = new ArrayList<>();
        for(int i =0;i<tituloArray.length;i++){
            if(!palabrasNoClave.contains(tituloArray[i])){
                palabras.add(tituloArray[i]);
            }
        }
      //  System.out.println(palabras);
        return palabras;
    }
    private   String [][] indexList(String titulo){
        String tituloRorate = titulo.concat(" /");
        String [] line = tituloRorate.split(" ");
        String [][] output = new String[line.length][line.length];
        //System.out.println("\nThe circular shifted lines are :");
        for (int i = 0; i < line.length; i++){
            for (int j = 0; j < line.length; j++) {
                output[i][j] = line[(i + j) % line.length];
              //  System.out.print(output[i][j] + " ");
            }
           // System.out.println("\n");
        }
        return  output;
    }

    public  List<String> circularShiftsProcess(){
        List<String> keywords = this.keywords(this.titulo,this.palabrasNoClave);
        String [][]output = this.indexList(this.titulo);
        List<String> circularList = new ArrayList<>();
        for (int i = 0; i < output.length; i++){
            String fila ="";
            if(keywords.contains(output[i][0])){
                for(int j=0; j< output.length; j++){
                    fila += output[i][j]+" ";
                }
                circularList.add(fila);
            }
        }
        return circularList;
    }

}
