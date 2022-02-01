package de.birdmana.kattis.astrologicalsign;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;

public class KattioMain {
    public static void main(String[] args) {

        ZodiacSign aries = new ZodiacSign("Aries", MonthDay.of(3, 21), MonthDay.of(4, 20));
        ZodiacSign taurus = new ZodiacSign("Taurus", MonthDay.of(4, 21), MonthDay.of(5, 20));
        ZodiacSign gemini = new ZodiacSign("Gemini", MonthDay.of(5, 21), MonthDay.of(6, 21));
        ZodiacSign cancer = new ZodiacSign("Cancer", MonthDay.of(6, 22), MonthDay.of(7, 22));
        ZodiacSign leo = new ZodiacSign("Leo", MonthDay.of(7, 23), MonthDay.of(8, 22));
        ZodiacSign virgo = new ZodiacSign("Virgo", MonthDay.of(8, 23), MonthDay.of(9, 21));
        ZodiacSign libra = new ZodiacSign("Libra", MonthDay.of(9, 22), MonthDay.of(10, 22));
        ZodiacSign scorpio = new ZodiacSign("Scorpio", MonthDay.of(10, 23), MonthDay.of(11, 22));
        ZodiacSign sagittarius = new ZodiacSign("Sagittarius", MonthDay.of(11, 23), MonthDay.of(12, 21));
        ZodiacSign capricorn = new ZodiacSign("Capricorn", MonthDay.of(12, 22), MonthDay.of(1, 20));
        ZodiacSign aquarius = new ZodiacSign("Aquarius", MonthDay.of(1, 21), MonthDay.of(2, 19));
        ZodiacSign pisces = new ZodiacSign("Pisces", MonthDay.of(2, 20), MonthDay.of(3, 20));

        ArrayList<ZodiacSign> signs = new ArrayList<>(12);
        signs.add(aries);
        signs.add(taurus);
        signs.add(gemini);
        signs.add(cancer);
        signs.add(leo);
        signs.add(virgo);
        signs.add(libra);
        signs.add(scorpio);
        signs.add(sagittarius);
        signs.add(capricorn);
        signs.add(aquarius);
        signs.add(pisces);

//        TEST
//        String test = "7\n" +
//                      "5 May\n" +
//                      "11 Dec\n" +
//                      "22 Sep\n" +
//                      "1 Jan\n" +
//                      "29 Feb\n" +
//                      "4 Mar\n" +
//                      "30 Jul";
//        InputStream is = new ByteArrayInputStream( test.getBytes(StandardCharsets.UTF_8) );

//        try(Kattio io = new Kattio(is, System.out)) {
        try(Kattio io = new Kattio(System.in, System.out)) {
            int n = io.getInt();

            while(io.hasMoreTokens()) {
                // parse date
                int day = io.getInt();
                String monthString = io.getWord();
                int month = determineMonth(monthString);

                MonthDay birthDay = MonthDay.of(month, day);

                //check if date is in ZodiacSign & print result
                for(ZodiacSign sign: signs) {
                    if((birthDay.isAfter(sign.getStart()) || birthDay.equals(sign.getStart())) &&
                            (birthDay.isBefore(sign.getEnd()) || birthDay.equals(sign.getEnd()))) {
                        System.out.println(sign.getName());
                        break;
                    }
                    if(sign.equals(capricorn)) {
                        if((birthDay.isAfter(sign.getStart()) || birthDay.equals(sign.getStart())) &&
                                (birthDay.isBefore(MonthDay.of(12, 31)) || birthDay.equals(MonthDay.of(12, 31)))) {
                            System.out.println(sign.getName());
                            break;
                        }
                        if((birthDay.isAfter(MonthDay.of(1, 1)) || birthDay.equals(MonthDay.of(1, 1))) &&
                                (birthDay.isBefore(sign.getEnd()) || birthDay.equals(sign.getEnd()))) {
                            System.out.println(sign.getName());
                            break;
                        }
                    }
                }
            }
        }
    }

    private static int determineMonth(String rawMonth) {
        switch(rawMonth) {
            case "Jan":
                return 1;
            case "Feb":
                return 2;
            case "Mar":
                return 3;
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "Jun":
                return 6;
            case "Jul":
                return 7;
            case "Aug":
                return 8;
            case "Sep":
                return 9;
            case "Oct":
                return 10;
            case "Nov":
                return 11;
            case "Dec":
                return 12;
            default:
                //tough luck
                return 0;
        }
    }
}
