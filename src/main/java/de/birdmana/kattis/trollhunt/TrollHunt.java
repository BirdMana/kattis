package de.birdmana.kattis.trollhunt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TrollHunt {
    public static void main(String[] args) {

//        TEST
//        String test = "5 2 1";
//        String test = "10 5 2";
//        String test = "300 58 15";
//        InputStream is = new ByteArrayInputStream(test.getBytes(StandardCharsets.UTF_8));

//        try(Kattio io = new Kattio(is, System.out)) {
        try(Kattio io = new Kattio(System.in, System.out)) {
            int stoneBridgeNumber = io.getInt();
            int knights = io.getInt();
            int knightGroupSize = io.getInt();

            int knightGroups = knights / knightGroupSize;
            int effectiveBridgeNumber = stoneBridgeNumber - 1;

            int daysToSearchRounded = (effectiveBridgeNumber + knightGroups - 1) / knightGroups;
            io.println(daysToSearchRounded);
        }
    }
}
