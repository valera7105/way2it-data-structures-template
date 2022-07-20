package org.way2it.data_structures.regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_email {

    public static void main(String[] args) {

        String text = "valera@gmail.com test Privet@gmail.Com";
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+@gmail.com\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }


}
