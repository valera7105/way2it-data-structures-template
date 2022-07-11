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
        System.out.print("Enter the month: ");
        String inputMonth = scanner.next();

        Months vMonth=null;
        // пошук мiсяця на вiдповiднiсть вводу
        for(Months m : Months.values()) {
            if (inputMonth.equalsIgnoreCase(m.name())) {
                vMonth=m;
            }
        }

        if (vMonth!=null) { // мiсяць знайшли!!!
            String vMonthsSeasonName=" ";
            String vMonthsDayName=" ";
            String vMonthsLessName=" ";
            String vMonthsNextSeasonName=" ";
            String vMonthsPastSeasonName=" ";
            String vMonthsMoreName=" ";
            String vMonthsEvenName=" ";
            String vMonthsNotEvenName=" ";
            String vMonthsEven=" ";

            for(Months m : Months.values()) {
                // пошук мiсяцв одного сезону
                if (vMonth.getSeason().equals(m.getSeason())) {
                    if (!vMonthsSeasonName.equals(" ")) {
                        vMonthsSeasonName=vMonthsSeasonName+", ";
                    }
                    vMonthsSeasonName = vMonthsSeasonName+m.name();
                }

                if (vMonth.getDay()==m.getDay()) {
                    if (!vMonthsDayName.equals(" ")) {
                        vMonthsDayName=vMonthsDayName+", ";
                    }
                    vMonthsDayName = vMonthsDayName+m.name();
                }
                if (vMonth.getDay()>m.getDay()) {
                    if (!vMonthsLessName.equals(" ")) {
                        vMonthsLessName=vMonthsLessName+", ";
                    }
                    vMonthsLessName = vMonthsLessName+m.name()+"("+m.getDay()+")";
                }
                if (vMonth.getDay()<m.getDay()) {
                    if (!vMonthsMoreName.equals(" ")) {
                        vMonthsMoreName=vMonthsMoreName+", ";
                    }
                    vMonthsMoreName = vMonthsMoreName+m.name()+"("+m.getDay()+")";
                }

                if (m.getDay()%2==0) {
                    if (!vMonthsEvenName.equals(" ")) {
                        vMonthsEvenName=vMonthsEvenName+", ";
                    }
                    vMonthsEvenName = vMonthsEvenName+m.name()+"("+m.getDay()+")";
                } else {
                    if (!vMonthsNotEvenName.equals(" ")) {
                        vMonthsNotEvenName=vMonthsNotEvenName+", ";
                    }
                    vMonthsNotEvenName = vMonthsNotEvenName+m.name()+"("+m.getDay()+")";
                }
            }
            int lengthSeason=Seasons.values().length;
            int numberSeason=vMonth.getSeason().ordinal();
            int numberNext=numberSeason+1;
            int numberPast=numberSeason-1;
            if (numberNext>lengthSeason) numberNext=0;
            if (numberPast<0) numberPast=lengthSeason-1;
            vMonthsNextSeasonName=Seasons.values()[numberNext].toString();
            vMonthsPastSeasonName=Seasons.values()[numberPast].toString();


            System.out.println("1. "+vMonth.getSeason()+" months -"+vMonthsSeasonName+".");
            System.out.println("2. The same number of days ("+vMonth.getDay()+") -"+vMonthsDayName+".");
            System.out.println("3. Less days ("+vMonth.getDay()+") -"+vMonthsLessName+".");
            System.out.println("4. More days ("+vMonth.getDay()+") -"+vMonthsMoreName+".");
            System.out.println("5. Next season -"+vMonthsNextSeasonName+".");
            System.out.println("6. Past months -"+vMonthsPastSeasonName+".");
            System.out.println("7. Even months -"+vMonthsEvenName+".");
            System.out.println("8. Not even months -"+vMonthsNotEvenName+".");

            String vMonthsEvent="9. "+vMonth.name()+" has ";
            if (vMonth.getDay()%2!=0) vMonthsEvent=vMonthsEvent+"not ";
            vMonthsEvent=vMonthsEvent+"even number of days("+vMonth.getDay()+")";
            System.out.println(vMonthsEvent);
        } else {
            System.out.println("The month is incorrectly indicated.");
        }

    }

}
