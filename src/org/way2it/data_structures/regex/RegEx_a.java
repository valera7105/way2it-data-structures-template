package org.way2it.data_structures.regex;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_a {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String text = scanner.next();
        Pattern pattern = Pattern.compile("\\b+а.+?\\b");
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(text.substring(matcher.start(), matcher.end()));
        }


    }



}
