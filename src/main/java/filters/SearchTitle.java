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
import utils.Utils;

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


    public Title[] searchTitleMethod2(String[] searchWords) {
        if (searchWords.length > 0) {
            int results = 0;
            for (int i = 0; i < sortedList.length; i++) {
                String[] titleSplitted = Utils.vectorizeTitle(this.sortedList[i].getTitle());

                if (searchWords.length <= titleSplitted.length) {
                    if (match(titleSplitted, searchWords)) {
                        results++;
                    }
                }
            }
            Title[] searchResult = new Title[results];
            String[] res = new String[results];
            int[] ids = new int[results];
            int cc = 0;
            for (int i = 0; i < sortedList.length; i++) {
                String[] titleSplitted = Utils.vectorizeTitle(this.sortedList[i].getTitle());
                if (searchWords.length <= titleSplitted.length) {
                    if (match(titleSplitted, searchWords)) {
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
        return new Title[0];
    }

    private boolean match(String[] title, String[] searchWords) {
        int cWords = 0;
            for (int j = 0; j < searchWords.length; j++) {
                if (title[j].equalsIgnoreCase(searchWords[j].toLowerCase())) {
                    cWords++;
                }
            }

        if (cWords == searchWords.length) {
            return true;
        }
        return false;


    }



    public String[] findTitles(Title[] res, String[] searchwords) {
        int results = 0;

        String ids = "";
        String aux = "";



        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < searchTitleMethod2(searchwords).length; j++) {

                if (searchTitleMethod2(searchwords)[j].getId() == res[i].getId()) {

                    String ayuda = "" + searchTitleMethod2(searchwords)[j].getId();
                    if (!aux.contains(ayuda)) {

                        aux += ayuda + " ";

                        results++;
                    }
                }
            }
        }

        String[] result = new String[results];

        int cresult = 0;

        aux = "";

        for (int i = 0; i < res.length; i++) {

            for (int j = 0; j < searchTitleMethod2(searchwords).length; j++) {

                if (searchTitleMethod2(searchwords)[j].getId() == res[i].getId()) {

                    String ayuda = "" + searchTitleMethod2(searchwords)[j].getId();

                    if (!aux.contains(ayuda)) {

                        aux += ayuda + " ";
                        result[cresult] = res[i].getTitle();
                        cresult++;
                    }
                }

            }
        }

        return result;
    }

}
