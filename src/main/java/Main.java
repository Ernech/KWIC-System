import filters.Alphabetizer;
import filters.CircularShifting;
import filters.Input;
import filters.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String [] args){
        Input input = new Input();
        input.agregarTitulo("el señor de los anillos");
        input.agregarTitulo("essentials of bussiness communications");
        input.agregarTitulo("encycopledia of research on library science");
        input.agregarPalabraNoClave("el");
        input.agregarPalabraNoClave("de");
        input.agregarPalabraNoClave("los");
        input.agregarPalabraNoClave("los");
        input.agregarPalabraNoClave("uno");
        input.agregarPalabraNoClave("la");
        input.agregarPalabraNoClave("on");
        input.agregarPalabraNoClave("of");
        for (int i =0;i< input.getTitles().size();i++){
            CircularShifting circularShifting = new CircularShifting(input.getTitles().get(i),input.getPalabrasNoClave());
            Alphabetizer alphabetizer = new Alphabetizer(circularShifting.circularShiftsProcess());
            Output output = new Output(alphabetizer.alfabetizar());
            System.out.println(output);
        }






     /*   String titulo = "essentials of bussiness communications";
       //String titulo = "el señor de los anillos";
       List<String> palabrasNoClave = new ArrayList<>();
       palabrasNoClave.add("el");
       palabrasNoClave.add("de");
       palabrasNoClave.add("los");
       palabrasNoClave.add("del");
       palabrasNoClave.add("uno");
       palabrasNoClave.add("la");
       palabrasNoClave.add("al");
       palabrasNoClave.add("of");

        System.out.println(keywords(titulo,palabrasNoClave));


        System.out.println(circularShifts( indexList(titulo),keywords(titulo,palabrasNoClave)));
        alfabetizar(circularShifts( indexList(titulo),keywords(titulo,palabrasNoClave)));*/
    }

    private static List<String> keywords(String titulo,List<String> palabrasNoClave){
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

    private static List<String> circularShifts( String [][] output, List<String> palabrasClave){
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
 private static void alfabetizar(List<String> circularList){
     TreeSet<String> sortedList = new TreeSet<>();
     for (int i =0;i<circularList.size();i++){
         sortedList.add(circularList.get(i));
     }
     System.out.println("Ordenado: "+sortedList);
 }
}
