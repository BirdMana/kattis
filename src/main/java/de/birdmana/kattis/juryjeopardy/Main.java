package de.birdmana.kattis.juryjeopardy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    static int ymin = 0;
    static int ymax = 0;
    static int xmax = 0;
    static int height = 0;
    static int width = 0;

    static ArrayList<Coords> coordsList = new ArrayList<>();

    public static void main(String[] args) {

        BufferedReader reader;

        int cases;
        char direction = 'O';

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//            reader = new BufferedReader(new InputStreamReader(System.in));
            reader = new BufferedReader(new StringReader("3\n" +
                    "FFRBLF\n" +
                    "FFRFRBRFBFRBRFLF\n" +
                    "FRLFFFLBRFFFRFFFRFRFBRFLBRFRLFLFFR\n"));
            String line = reader.readLine();

            cases = Integer.parseInt(line);
            out.println(cases);

            line = reader.readLine();

            for (int i = 0; i < cases; i++) {

                int currentX = 0;
                int currentY = 0;
                xmax = 0;
                ymin = 0;
                ymax = 0;
                height = 0;
                width = 0;
                //reset direction for next test case
                direction = 'O';

                coordsList.clear();
                coordsList.add(new Coords(0, 0, '.'));
                coordsList.add(new Coords(1, 0, '.'));
                coordsList.add(new Coords(0, 1, '#'));
                coordsList.add(new Coords(0, -1, '#'));

                for (int j = 0; j < line.length(); j++) {
                    String character = line.substring(j, j + 1);

                    if (Objects.equals(character, "R")) {
                        if (direction == 'N') {
                            currentX++;
                            direction = 'O';

                        } else if (direction == 'O') {
                            currentY--;
                            direction = 'S';

                        } else if (direction == 'S') {
                            currentX--;
                            direction = 'W';

                        } else if (direction == 'W') {
                            currentY++;
                            direction = 'N';

                        }


                    } else if (Objects.equals(character, "F")) {
                        // rechts ist Mauer
                        if (direction == 'N') {
                            check(new Coords(currentX + 1, currentY, '#'));
                            currentY++;
                        } else if (direction == 'O') {
                            check(new Coords(currentX, currentY - 1, '#'));
                            currentX++;
                        } else if (direction == 'S') {
                            check(new Coords(currentX - 1, currentY, '#'));
                            currentY--;
                        } else if (direction == 'W') {
                            check(new Coords(currentX, currentY + 1, '#'));
                            currentX--;
                        }

                    } else if (Objects.equals(character, "L")) {
                        //rechts und gerade ist Mauer

                        if (direction == 'N') {
                            check(new Coords(currentX + 1, currentY, '#'));
                            check(new Coords(currentX, currentY + 1, '#'));
                            currentX--;
                            direction = 'W';
                        } else if (direction == 'O') {
                            check(new Coords(currentX, currentY - 1, '#'));
                            check(new Coords(currentX + 1, currentY, '#'));
                            currentY++;
                            direction = 'N';
                        } else if (direction == 'S') {
                            check(new Coords(currentX, currentY - 1, '#'));
                            check(new Coords(currentX - 1, currentY, '#'));
                            currentX++;
                            direction = 'O';
                        } else if (direction == 'W') {
                            check(new Coords(currentX + 1, currentY, '#'));
                            check(new Coords(currentX, currentY + 1, '#'));
                            currentY--;
                            direction = 'S';
                        }


                    } else if (Objects.equals(character, "B")) {
                        //rechts, gerade und links ist Mauer

                        if (direction == 'N') {
                            check(new Coords(currentX, currentY + 1, '#'));
                            check(new Coords(currentX + 1, currentY, '#'));
                            check(new Coords(currentX - 1, currentY, '#'));

                            currentY--;
                            direction = 'S';
                        } else if (direction == 'O') {
                            check(new Coords(currentX + 1, currentY, '#'));
                            check(new Coords(currentX, currentY - 1, '#'));
                            check(new Coords(currentX, currentY + 1, '#'));

                            currentX--;
                            direction = 'W';
                        } else if (direction == 'S') {
                            check(new Coords(currentX, currentY - 1, '#'));
                            check(new Coords(currentX + 1, currentY, '#'));
                            check(new Coords(currentX - 1, currentY, '#'));

                            currentY++;
                            direction = 'N';
                        } else if (direction == 'W') {
                            check(new Coords(currentX + 1, currentY, '#'));
                            check(new Coords(currentX, currentY - 1, '#'));
                            check(new Coords(currentX, currentY + 1, '#'));

                            currentX++;
                            direction = 'O';
                        }


                    }
                    check(new Coords(currentX, currentY, '.'));
                }

                height = Math.abs(ymin) + ymax + 1;
                width = xmax + 1;
                //Check if all walls are there
                wallCheck();

                out.println(height + " " + width);
                out.flush();

                Collections.sort(coordsList);
                print(out);
                line = reader.readLine();
            }


            reader.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(PrintWriter out) {
        for (Coords coord : coordsList) {
            out.print(coord.maze);
            out.flush();
            //Zeilenumbrüche
            if (coord.x == xmax) {
                out.println();
                out.flush();
            }
        }
    }

    public static void check(Coords point) {
        boolean flag = true;

        List<Coords> duplicateCheck  =  coordsList.stream()
                .filter(i ->  i.x == point.x)
                .collect(Collectors.toList());

        for (int k = 0; k < coordsList.size(); k++) {
            Coords element = coordsList.get(k);

            if (point.x == element.x && point.y == element.y) {
                flag = false;
                break;
            }
        }
        if (flag) {
        ymax = Math.max(point.y, ymax);
        ymin = Math.min(point.y, ymin);
        xmax = Math.max(point.x, xmax);
//        if (duplicateCheck.isEmpty()) {

            coordsList.add(point);
        }
    }

    public static void wallCheck() {
        for (int l = 1; l < width + 1; l++) {
            check(new Coords(l - 1, ymin, '#'));
            check(new Coords(l - 1, ymax, '#'));
        }

        for (int k = ymin; k < ymax + 1; k++) {
            check(new Coords(width - 1, k, '#'));
            check(new Coords(0, k, '#'));
        }
    }
}
