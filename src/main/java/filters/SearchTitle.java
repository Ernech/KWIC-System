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

    public Title[] searchTitleMethod(String[] searchWords) {
        int results = 0;
        int sbi;
        for (int i = 0; i < this.sortedList.length; i++) {
            sbi = 0;
            for (int j = 0; j < searchWords.length; j++) {

                if (this.sortedList[i].getTitle().toLowerCase().contains(searchWords[j])) {
                    sbi++;
                }
            }
            if (sbi == searchWords.length) {
                results++;
            }
        }
        Title[] searchResult = new Title[results];
        String[] res = new String[results];
        int[] ids = new int[results];
        int cc = 0;
        for (int i = 0; i < this.sortedList.length; i++) {
            sbi = 0;
            for (int j = 0; j < searchWords.length; j++) {

                if (this.sortedList[i].getTitle().toLowerCase().contains(searchWords[j])) {
                    sbi++;
                }
            }
            if (sbi == searchWords.length) {
                res[cc] = this.sortedList[i].getTitle();
                ids[cc] = this.sortedList[i].getId();
                cc++;
            }

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
    }

    public String[] findTitles(Title[] res, String[] searchwords) {
        int results = 0;

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < searchTitleMethod(searchwords).length; j++) {

                if (searchTitleMethod(searchwords)[j].getId() == res[i].getId()) {
                    results++;
                    System.out.println(results + " R " + res[i].getId() + "|" + searchTitleMethod(searchwords)[j].getId());
                }
            }
        }

        String[] result = new String[results];
        String tr = "";
        int cc = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < searchTitleMethod(searchwords).length; j++) {
                if (searchTitleMethod(searchwords)[j].getId() == res[i].getId()) {
                    if (!tr.contains(res[i].getTitle())) {
                        result[cc] = res[i].getTitle();
                        tr += result[cc] + " ";
                    } else {
                        result[cc] = "";
                    }
                    cc++;
                }
            }
        }
        return result;
    }

}
