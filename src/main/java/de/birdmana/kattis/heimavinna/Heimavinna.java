package de.birdmana.kattis.heimavinna;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Heimavinna {
    public static void main(String[] args) {

//        TEST
//        String test = "1-3;5;7;10-13";
//        String test = "3-10";
//        String test = "1;3;5;8;13";
//        InputStream is = new ByteArrayInputStream( test.getBytes(StandardCharsets.UTF_8) );

//        try(Kattio io = new Kattio(is, System.out)) {
        try(Kattio io = new Kattio(System.in, System.out)) {
            String line = io.getWord();
            String[] split = line.split(";");
            int sum = 0;

            for(String s : split) {
                if (s.contains("-")) {
                    String[] range = s.split("-");
                    sum = sum + Integer.parseInt(range[1]) - Integer.parseInt(range[0]) + 1;
                } else {
                    sum = sum + 1;
                }
            }
            io.println(sum);
        }
    }
}
