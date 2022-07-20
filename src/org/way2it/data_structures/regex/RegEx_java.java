package org.way2it.data_structures.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_java {

    public static void main(String[] args) {

        String str = "I love Java more than my friend. Java is so beautiful.";
        Pattern pattern = Pattern.compile("\\bJava\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(str.replaceFirst("Java","C#"));
            System.out.println(str.replaceAll("Java","C#"));
        }
    }


}
