package de.birdmana.kattis.speedlimit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Speedlimit {
    public static void main(String[] args) {

//        TEST
//        String test = "3\n" +
//                "20 2\n" +
//                "30 6\n" +
//                "10 7\n" +
//                "2\n" +
//                "60 1\n" +
//                "30 5\n" +
//                "4\n" +
//                "15 1\n" +
//                "25 2\n" +
//                "30 3\n" +
//                "10 5\n" +
//                "-1";
//        InputStream is = new ByteArrayInputStream( test.getBytes(StandardCharsets.UTF_8) );

//        try(Kattio io = new Kattio(is, System.out)) {
        try(Kattio io = new Kattio(System.in, System.out)) {
            while(io.hasMoreTokens()) {
                int lineNumber = io.getInt();
                if(lineNumber == -1) {
                    break;
                }
                int milesum = 0;
                int time = 0;
                while(lineNumber > 0) {
                    int speed = io.getInt();
                    int totalTime = io.getInt();
                    time = (time == 0) ? totalTime: totalTime - time;
                    milesum = milesum + speed * time;
                    time = totalTime;
                    lineNumber = lineNumber - 1;
                }
                io.println(milesum + " miles");
            }
        }
    }
}
