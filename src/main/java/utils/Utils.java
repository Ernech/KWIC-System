package utils;

public class Utils {

    public static final  String NON_KEYWWORDS = "the of to a";
    public static String[] vectorize(String textArea) {

        String[] titArray = textArea.toLowerCase().split(" ");
        if (textArea.length() <= 3 && textArea.contains(NON_KEYWWORDS)) {
            return new String[0];
        } else {
            String s = "";
            for (int i = 0; i < titArray.length; i++) {
                if (!NON_KEYWWORDS.contains(titArray[i])) {
                    s += titArray[i] + " ";
                }

            }
            if (s != "") {
                String[] res = s.split(" ");
                return res;
            } else {
                return new String[0];
            }
        }

    }

    public static String[] vectorizeTitle(String textArea) {
        String[] titArray = textArea.toLowerCase().split(" ");

        String s = "";
        for (int i = 0; i < titArray.length; i++) {
            if (!NON_KEYWWORDS.contains(titArray[i])) {
                s += titArray[i] + " ";
            }
        }
        String[] res = s.split(" ");

        return res;

    }

}
