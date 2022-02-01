package de.birdmana.kattis.twostones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int number = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            while(line != null) {
                number = Integer.parseInt(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        if((number % 2) == 0) {
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }
    }
}
