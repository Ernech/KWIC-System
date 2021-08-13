package modulos;

import java.util.ArrayList;
import java.util.List;

public class CircularShifting {

    List<String> titulos;
    List<String> palabrasNoClave;

    public CircularShifting() {
    }

    public CircularShifting(List<String> titulos, List<String> palabrasNoClave) {
        this.titulos = titulos;
        this.palabrasNoClave = palabrasNoClave;
    }

    private static List<String> keywords(String titulo, List<String> palabrasNoClave){
        String [] tituloArray = titulo.split(" ");
        List<String> palabras = new ArrayList<>();
        for(int i =0;i<tituloArray.length;i++){
            if(!palabrasNoClave.contains(tituloArray[i])){
                palabras.add(tituloArray[i]);
            }
        }
        return palabras;
    }
    private static  String [][] indexList(String titulo){
        String tituloRorate = titulo.concat(" /");
        String [] line = tituloRorate.split(" ");
        String [][] output = new String[line.length][line.length];
        System.out.println("\nThe circular shifted lines are :");
        for (int i = 0; i < line.length; i++){
            for (int j = 0; j < line.length; j++) {
                output[i][j] = line[(i + j) % line.length];
                System.out.print(output[i][j] + " ");
            }
            System.out.println("\n");
        }
        return  output;
    }

    public static List<String> circularShifts( String [][] output, List<String> palabrasClave){
        List<String> circularList = new ArrayList<>();
        for (int i = 0; i < output.length; i++){
            String fila ="";
            if(palabrasClave.contains(output[i][0])){
                for(int j=0; j< output.length; j++){
                    fila += output[i][j]+" ";
                }
                circularList.add(fila);
            }
        }
        return circularList;
    }

}
