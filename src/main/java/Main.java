import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args){
       // String titulo = "essentials of bussiness communications";
        String titulo = "el señor de los anillos";
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
       String tituloRorate = titulo.concat("/");
        String [] line = tituloRorate.split(" ");
        String [][] output = new String[line.length][line.length];
      //  return null;
        System.out.println("\n The circular shifted lines are :");
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
                if(palabrasClave.contains(output[i][0])){
                    System.out.println(output[i]);
                }
        }


        return circularList;
    }
}
