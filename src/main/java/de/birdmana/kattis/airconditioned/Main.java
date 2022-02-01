package de.birdmana.kattis.airconditioned;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            reader = new BufferedReader(new InputStreamReader(System.in));
//            reader = new BufferedReader(new StringReader("3\n" +
//                    "1 2\n" +
//                    "2 4\n" +
//                    "5 6"));

            int roomNumber = 1;

            int numberOfMinions = Integer.parseInt(reader.readLine());
            ArrayList<Minion> minions = new ArrayList<>(numberOfMinions);
            for (int i = 0; i < numberOfMinions; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int min = Integer.parseInt(st.nextToken());
                int max = Integer.parseInt(st.nextToken());

                minions.add(new Minion(min, max));
            }

            Collections.sort(minions);
            Minion temp = minions.get(0);
            // calculate min number of rooms for all minions to match their heat preferences
            for (int i = 0; i < numberOfMinions; i++) {
                if (minions.get(i).minTemp > temp.maxTemp) {
                    roomNumber++;
                    temp = minions.get(i);
                }
            }

//            out.println(minions);

            out.println(roomNumber);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Minion implements Comparable<Minion> {
    int minTemp;
    int maxTemp;

    public Minion(int min, int max) {
        this.minTemp = min;
        this.maxTemp = max;
    }

    @Override
    public int compareTo(Minion min) {
        return maxTemp - min.maxTemp;
    }

    @Override
    public String toString() {
        return "Minion{" +
                "minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }
}
