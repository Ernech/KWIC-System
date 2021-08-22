package filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Title;
import utils.Utils;

public class CircularShifting {

    private Title[] titulo;


    public CircularShifting() {

    }

    public CircularShifting(Title[] titulo) {
        this.titulo = titulo;
    }


    public Title[] indexList(Title[] titulo) {
        Title[] indList = new Title[nIndex(titulo)];
        int cont = 0;


        for (int k = 0; k < titulo.length; k++) {
            String tituloRorate = titulo[k].getTitle();
            int id = titulo[k].getId();
            String[] line = tituloRorate.split(" ");
            String[][] output = new String[line.length][line.length];
            //System.out.println("\nThe circular shifted lines are :");
            for (int i = 0; i < line.length; i++) {
                String aux = "";

                for (int j = 0; j < line.length; j++) {
                    output[i][j] = line[(i + j) % line.length];
                    aux += output[i][j] + " ";

                    //  System.out.print(output[i][j] + " ");
                }
                Title t = new Title(aux, id);
                indList[cont] = t;
                cont++;
                // System.out.println("\n");
            }
        }

        return indList;
    }

    private int nIndex(Title[] titulo) {
        int numero = 0;
        for (int i = 0; i < titulo.length; i++) {
            String[] tituloVector = titulo[i].getTitle().split(" ");
            numero += tituloVector.length;
        }
        return numero;
    }

    public Title[] circularShiftsProcess() {

        String keywords = Utils.NON_KEYWWORDS;
        Title[] output = this.indexList(this.titulo);
        int cantidad = 0;
//        Title[] circularList = new Title[];
        for (int i = 0; i < output.length; i++) {
            String fila = "";
            String[] primeraPalabra = output[i].getTitle().split(" ");

            if (!keywords.contains(primeraPalabra[0].toLowerCase())) {

//                circularList.add(fila);
                cantidad++;
            }
        }

        String[] title = new String[cantidad];
        int[] ids = new int[cantidad];
        int c = 0;

        for (int i = 0; i < output.length; i++) {
            String fila = "";
            String[] primeraPalabra = output[i].getTitle().split(" ");

            if (!keywords.contains(primeraPalabra[0].toLowerCase())) {

                title[c] = output[i].getTitle();
                ids[c] = output[i].getId();
                c++;
            }
        }

        Title[] circularList = new Title[cantidad];

        for (int i = 0; i < title.length; i++) {
            Title aux = new Title(title[i], ids[i]);
            circularList[i] = aux;
        }

        return circularList;
    }

}
