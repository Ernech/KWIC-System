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
import models.Title;

/**
 *
 * @author diego
 */
public class SearchTitle {

    private Title[] sortedList;

    public SearchTitle(Title[] sortedList) {
        this.sortedList = sortedList;
    }

    public Title[] getSortedList() {
        return sortedList;
    }

    public void setSortedList(Title[] sortedList) {
        this.sortedList = sortedList;
    }
/*
    public Title[] searchTitleMethod(String[] searchWords) {
        int results = 0;
//        int sbi;
        for (int i = 0; i < this.sortedList.length; i++) {
//            sbi = 0;
            String[] ppalabra = this.sortedList[i].getTitle().toLowerCase().split(" ");
            for (int j = 0; j < searchWords.length; j++) {

                if (ppalabra[0].equals(searchWords[j])) {
                    results++;
                }
            }
//            if (sbi == searchWords.length) {
//                results++;
//            }
        }
        Title[] searchResult = new Title[results];
        String[] res = new String[results];
        int[] ids = new int[results];
        int cc = 0;
        for (int i = 0; i < this.sortedList.length; i++) {
//            sbi = 0;
            String[] ppalabra = this.sortedList[i].getTitle().toLowerCase().split(" ");
            for (int j = 0; j < searchWords.length; j++) {

                if (ppalabra[0].equals(searchWords[j])) {
                    res[cc] = this.sortedList[i].getTitle();
                    ids[cc] = this.sortedList[i].getId();
                    cc++;
                }
            }
//            if (sbi == searchWords.length) {
//                res[cc] = this.sortedList[i].getTitle();
//                ids[cc] = this.sortedList[i].getId();
//                cc++;
//            }

        }

        for (int i = 0;
                i < results;
                i++) {
            Title t = new Title(res[i], ids[i]);
            searchResult[i] = t;
        }

        return searchResult;

//        if(term==null || term.isEmpty()){
//            return this.titlesList;
//        }
//        else{
//            List<String> result = new ArrayList<>();
//            String[] words=term.split(" ");
//            for (int i = 0; i < this.titlesList.size(); i++){
//               int wordsIn = 0;
//                for (int j = 0;j<words.length;j++){
//                    if(this.titlesList.get(i).contains(words[j].toLowerCase().trim())){
//                      wordsIn++;
//                    }
//                }
//                if(wordsIn==words.length){
//                    result.add(this.titlesList.get(i));
//                }
//            }
//            return result;
//        }
    }*/

    public Title[] searchTitleMethod2(String[] searchWords){
        int results = 0;
        for (int i =0;i<sortedList.length;i++){
            String [] titleSplitted = vectorize(this.sortedList[i].getTitle());

            if(searchWords.length<=titleSplitted.length){
                if(match(titleSplitted,searchWords)){
                    results++;
                }
            }
        }
        System.out.println("RESULTS!!!!!! "+results);
        Title[] searchResult = new Title[results];
        String[] res = new String[results];
        int[] ids = new int[results];
        int cc = 0;
        for (int i =0;i<sortedList.length;i++){
            String [] titleSplitted = vectorize(this.sortedList[i].getTitle());
            if(searchWords.length<=titleSplitted.length){
                if(match(titleSplitted,searchWords)){
                    res[cc] = this.sortedList[i].getTitle();
                    ids[cc] = this.sortedList[i].getId();
                    cc++;
                }
            }
        }

        for (int i = 0;
             i < results;
             i++) {
            Title t = new Title(res[i], ids[i]);
            searchResult[i] = t;
        }

        return searchResult;
    }

    private boolean match(String[] title,String [] searchWords){
        String titleString="";
        String searchWordsString="";
        for(int i = 0;i<title.length;i++){
            titleString+=title[i].toLowerCase()+" ";
        }
        for(int i = 0;i<searchWords.length;i++){
            searchWordsString+=searchWords[i].toLowerCase()+" ";
        }
        if(titleString.contains(searchWordsString)){
            return true;
        }
        return false;

    }


    private String[] vectorize(String textArea){
        String[] titArray=textArea.toLowerCase().split(" ");
        String keywords = "the of to a";
        String s="";
        for(int i =0;i<titArray.length;i++){
            if(!keywords.contains(titArray[i])){
                s+=titArray[i]+" ";
            }
        }
        String[] res=s.split(" ");

        return res;



    }
    public String[] findTitles(Title[] res, String[] searchwords) {
        int results = 0;
        int cc = 0;
        String ids = "";
        String aux = "";
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < searchTitleMethod2(searchwords).length; j++) {

                if (searchTitleMethod2(searchwords)[j].getId() == res[i].getId()) {

                    ids += searchTitleMethod2(searchwords)[j].getId() + " ";

                }
            }
        }
        System.out.println(ids);
        String[] comprobarIds = ids.split(" ");
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < searchTitleMethod2(searchwords).length; j++) {

                if (searchTitleMethod2(searchwords)[j].getId() == res[i].getId()) {
                    cc = 0;
                    String ayuda = "" + searchTitleMethod2(searchwords)[j].getId();
                    for (int k = 0; k < comprobarIds.length; k++) {
                        if (!aux.contains(ayuda)) {
                            if (comprobarIds[k].equals(ayuda)) {
                                System.out.println(ayuda);
                                cc++;
                            }
                        }
                    }
                    if (cc > searchwords.length) {
                        cc--;
                    }
                    aux += ayuda + " ";
                    if (cc == searchwords.length) {
                        results++;
                    }
                }
            }
        }
        System.out.println("Results =" + results);
        String[] result = new String[results];
//        String tr = "";
        int cresult = 0;
        cc = 0;
        aux = "";

        for (int i = 0; i < res.length; i++) {

            for (int j = 0; j < searchTitleMethod2(searchwords).length; j++) {

                if (searchTitleMethod2(searchwords)[j].getId() == res[i].getId()) {
                    cc = 0;
                    String ayuda = "" + searchTitleMethod2(searchwords)[j].getId();
                    for (int k = 0; k < comprobarIds.length; k++) {

                        if (!aux.contains(ayuda)) {
                            if (comprobarIds[k].equals(ayuda)) {
                                cc++;
                            }
                        }
                    }
                    if (cc > searchwords.length) {
                        cc--;
                    }
                    aux += ayuda + " ";
                    if (cc == searchwords.length) {
                        result[cresult] = res[i].getTitle();
                        cresult++;
                    }
                }

            }
        }

        return result;
    }

}
