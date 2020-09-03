package dk.kea.dat19c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class Main {

    //reads a url one line at a time
    public static HashMap<String, Integer> readURLlookFor(ArrayList<String> words) throws Exception {
        URL cnn = new URL("https://dr.dk/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(cnn.openStream()));

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (String ss: words) {
            hm.put(ss, Integer.valueOf(0));
        }
        String inputLine = "";
        while (inputLine != null) {
            System.out.println(inputLine);
            for (String ss : words) {
                if ((inputLine.indexOf(ss)) > -1) {
                    Integer ii = hm.get(ss);
                    ii++;
                    hm.put(ss, ii);
                }
            }
            inputLine = in.readLine();
        }
        in.close();
        return hm;
    }
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Trump");
        words.add("<div");
        words.add("dr");
        words.add("<a href");
        HashMap<String, Integer> hm1;
        try {
            hm1 = readURLlookFor(words);
            for (String sKey : hm1.keySet()) {
                System.out.println(" We found " + sKey + " " + hm1.get(sKey) + " times");
            }
        } catch (Exception err) {
            System.out.println(" Exception URL " + err);
        }
    }
}