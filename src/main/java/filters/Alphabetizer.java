package filters;

import java.util.List;
import java.util.TreeSet;
import models.Title;

public class Alphabetizer {

    Title[] circularTitles;
    
    public Alphabetizer() {
    }
    public Alphabetizer(Title[] circularTitles) {
    this.circularTitles = circularTitles;


    }


    public Title[]  alfabetizar(){
        Title[] sortedList = new Title[this.circularTitles.length];
        
        String temp;
        int t;
        String[] aux=new String[this.circularTitles.length];
        int[] ids=new int[this.circularTitles.length];
        for(int i=0;i<this.circularTitles.length;i++){
            String a="";
            a+=this.circularTitles[i].getTitle();
            aux[i]=a;
            ids[i]=this.circularTitles[i].getId();
            
        }
        
        for (int i = 0; i < this.circularTitles.length; i++) {
            System.out.println("T ="+this.circularTitles[i].getTitle());
            for (int j = i + 1; j < this.circularTitles.length; j++) {
                
                // to compare one string with other strings
                if (aux[i].compareTo(aux[j]) > 0) {
                    // swapping
                    temp = aux[i];
                    aux[i]=aux[j];
                    aux[j]=temp;
                    t=ids[i];
                    ids[i]=ids[j];
                    ids[j]=t;
                }
            }
        }
        
        for(int i=0;i<aux.length;i++){
            Title tit=new Title(aux[i],ids[i]);
            sortedList[i]=tit;
        }
        
      return sortedList;
    }
}
