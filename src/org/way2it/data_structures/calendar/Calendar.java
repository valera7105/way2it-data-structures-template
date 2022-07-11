package org.way2it.data_structures.calendar;

import java.util.Scanner;

public class Calendar {

    private enum Seasons {
        WINTER, SPRING, SUMMER, AUTUMN
    }

    private enum Months {
        JANUARY(31, Seasons.WINTER),
        FEBRUARY(28, Seasons.WINTER),
        MARCH(31, Seasons.SPRING),
        APRIL(30, Seasons.SPRING),
        MAY(31, Seasons.SPRING),
        JUNE(30, Seasons.SUMMER),
        JULY(31, Seasons.SUMMER),
        AUGUST(31, Seasons.SUMMER),
        SEPTEMBER(30, Seasons.AUTUMN),
        OCTOBER(31, Seasons.AUTUMN),
        NOVEMBER(30, Seasons.AUTUMN),
        DECEMBER(31, Seasons.WINTER);

        int day;
        Seasons season;

        Months(int day, Seasons season) {
            this.day = day;
            this.season = season;
        }

        public int getDay() {
            return day;
        }

        public Seasons getSeason() {
            return season;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the month name (press to exit `q`): ");
            String inputMonth = scanner.next();

            if (inputMonth.equalsIgnoreCase("q")) break;
            Months vMonth = getCorreectMonth(inputMonth);
            if (vMonth!=null) {
                getInfo(vMonth);
            } else {
                System.out.println("The month does not exist. Retry.");
            }
        }
    }

    private static Months getCorreectMonth(String monthsName) {
        // пошук мiсяця на вiдповiднiсть вводу
        Months result=null;
        for(Months m : Months.values()) {
            if (monthsName.equalsIgnoreCase(m.name())) {
                result=m;
            }
        }
        return result;
    }

    private static void getInfo(Months aMonths) {
        Scanner scanner = new Scanner(System.in);
        int x=0; String s ="";
        while (!"0".equals(s)) {
            System.out.println("Зробіть свій вибр");
            System.out.println("  1 - Вивести всі місяці з такою ж порою року.");
            System.out.println("  2 - Вивести всі місяці які мають таку саму кількість днів..");
            System.out.println("  3 - Вивести всі місяці які мають меншу кількість днів.");
            System.out.println("  4 - Вивести всі місяці які мають більшу кількість днів.");
            System.out.println("  5 - Вивести наступну пору року.");
            System.out.println("  6 - Вивести попередню пору року.");
            System.out.println("  7 - Вивести всі місяці які мають парну кількість днів.");
            System.out.println("  8 - Вивести всі місяці які мають непарну кількість днів.");
            System.out.println("  9 - Вивести чи введений місяць має парну кількість днів.");
            System.out.println("  0 - Вихід.");

            s = scanner.next();
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Некоретний вибір.");
            }
            String vOutput=null;
            switch (x) {
                case 0:
                    break;
                case 1:
                    vOutput=getDtl1(aMonths);
                    break;
                case 2:
                    vOutput=getDtl2(aMonths);
                    break;
                case 3:
                    vOutput=getDtl3(aMonths);
                    break;
                case 4:
                    vOutput=getDtl4(aMonths);
                    break;
                case 5:
                    vOutput=getDtl5(aMonths);
                    break;
                case 6:
                    vOutput=getDtl6(aMonths);
                    break;
                case 7:
                    vOutput=getDtl7(aMonths);
                    break;
                case 8:
                    vOutput=getDtl8(aMonths);
                    break;
                case 9:
                    vOutput=getDtl9(aMonths);
                    break;
                default:
                    System.out.println("Некоретний вибір.");
            }
            if (vOutput!=null) System.out.println(vOutput);
        }
    }
    private static String getDtl1(Months aMonths) {
        String result=" ";
        for(Months m : Months.values()) {
            if (aMonths.getSeason().equals(m.getSeason())) {
                result = getParse(result);
                result = result + m.name();
            }
        }
        return result;
    }

    private static String getDtl2(Months aMonths) {
        String result=" ";
        for(Months m : Months.values()) {
            if (aMonths.getDay() == m.getDay()) {
                result = getParse(result);
                result = result + m.name();
            }
        }
        return result;
    }

    private static String getDtl3(Months aMonths) {
        String result=" ";
        for(Months m : Months.values()) {
            if (aMonths.getDay()>m.getDay()) {
                result = getParse(result);
                result = result+m.name()+"("+m.getDay()+")";
            }
        }
        return result;
    }

    private static String getDtl4(Months aMonths) {
        String result=" ";
        for(Months m : Months.values()) {
            if (aMonths.getDay()<m.getDay()) {
                result = getParse(result);
                result = result+m.name()+"("+m.getDay()+")";
            }
        }
        return result;
    }

    private static String getDtl5(Months aMonths) {
        String result=" ";
        int lengthSeason=Seasons.values().length;
        int numberSeason=aMonths.getSeason().ordinal();
        int numberNext=numberSeason+1;
        if (numberNext>lengthSeason-1) numberNext=0;
        result=Seasons.values()[numberNext].toString();
        return result;
    }

    private static String getDtl6(Months aMonths) {
        String result=" ";
        int lengthSeason=Seasons.values().length;
        int numberSeason=aMonths.getSeason().ordinal();
        int numberPast=numberSeason-1;
        if (numberPast<0) numberPast=lengthSeason-1;
        result=Seasons.values()[numberPast].toString();
        return result;
    }

    private static String getDtl7(Months aMonths) {
        String result=" ";
        for(Months m : Months.values()) {
            if (m.getDay()%2==0) {
                result = getParse(result);
                result = result+m.name()+"("+m.getDay()+")";
            }
        }
        return result;
    }

    private static String getDtl8(Months aMonths) {
        String result=" ";
        for(Months m : Months.values()) {
            if (m.getDay()%2!=0) {
                result = getParse(result);
                result = result+m.name()+"("+m.getDay()+")";
            }
        }
        return result;
    }

    private static String getDtl9(Months aMonths) {
        String result=" парний";
        if (aMonths.getDay()%2!=0) result=" НЕ "+result;
        return result;
    }

    public static String getParse(String aLine) {
        String result=aLine;
        if (!aLine.equals(" ")) {
            result = aLine + ", ";
        }
        return result;
    }
}
