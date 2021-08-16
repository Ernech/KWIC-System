/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 *
 * @author diego
 */
public class SearchTitle {
    
    private List<String> titlesList;

    public SearchTitle(List<String> titlesList) {
        this.titlesList = titlesList;
    }

    public List<String> getTitlesList() {
        return titlesList;
    }

    public void setTitlesList(List<String> titlesList) {
        this.titlesList = titlesList;
    }


    
    
    
    public List<String> searchTitleMethod(String term){

        
        if(term==null || term.isEmpty()){
            return this.titlesList;
        }
        else{
            List<String> result = new ArrayList<>();
            String[] words=term.split(" ");
            for (int i = 0; i < this.titlesList.size(); i++){
               int wordsIn = 0;
                for (int j = 0;j<words.length;j++){
                    if(this.titlesList.get(i).contains(words[j].toLowerCase().trim())){
                      wordsIn++;
                    }
                }
                if(wordsIn==words.length){
                    result.add(this.titlesList.get(i));
                }
            }
            return result;
        }
        

        
    }
    
    
}
