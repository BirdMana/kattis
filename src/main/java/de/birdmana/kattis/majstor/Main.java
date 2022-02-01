package de.birdmana.kattis.majstor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
//            reader = new BufferedReader(new StringReader("5\n" +
//                    "SSPPR\n" +
//                    "1\n" +
//                    "SSPPR"));
            String line = reader.readLine();
            int points = 0;

            int cases = Integer.parseInt(line);
            line = reader.readLine();
            String[] sven = line.split("");
            line = reader.readLine();
            int friends = Integer.parseInt(line);
            ArrayList<String[]> friendsChoices = new ArrayList<>(friends);
            String[] enemy = new String[0];

            int maxPoints = 0;

            for (int i = 0; i < friends; i++) {
                line = reader.readLine();
                enemy = line.split("");
                friendsChoices.add(enemy);

                for (int j = 0; j < cases; j++) {
                    if (Objects.equals(sven[j], enemy[j])) {          //Gleichstand
                        points++;
                    } else if (Objects.equals(sven[j], "S") && Objects.equals(enemy[j], "P")) {
                        points = points + 2;
                    } else if (Objects.equals(sven[j], "R") && Objects.equals(enemy[j], "S")) {
                        points = points + 2;
                    } else if (Objects.equals(sven[j], "P") && Objects.equals(enemy[j], "R")) {
                        points = points + 2;
                    }
                }
            }

            String[] options = {"R", "P", "S"};
            // Maximal number of points
            for (int i = 0; i < cases; i++) {
                int maxR = 0;
                int maxP = 0;
                int maxS = 0;
                for (String[] element : friendsChoices) {
                    for (String s : options) {
                        if (element[i].equals(s)) {
                            if (element[i].equals("P")) {
                                maxS += 2;
                                maxP++;
                            } else if (element[i].equals("S")) {
                                maxR += 2;
                                maxS++;
                            } else if (element[i].equals("R")) {
                                maxP += 2;
                                maxR++;
                            }
                        }
                    }
                }
                maxPoints += Math.max(Math.max(maxR, maxP), maxS);
            }

            System.out.println(points);
            System.out.println(maxPoints);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
