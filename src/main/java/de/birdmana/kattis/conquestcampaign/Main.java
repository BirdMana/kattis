package de.birdmana.kattis.conquestcampaign;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean didchange = true;
    static int days = 1;
    static Cell[][] numberlist;

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//            reader = new BufferedReader(new InputStreamReader(System.in));
            reader = new BufferedReader(new StringReader("3 4 3\n" +
                    "2 2\n" +
                    "2 2\n" +
                    "3 4"));

//            String line = reader.readLine();
//            String[] data;
//            data = line.split(" ");
//            int rows = Integer.parseInt(data[0]);
//            int columns = Integer.parseInt(data[1]);
//            int initiallyColouredCells = Integer.parseInt(data[2]);
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int rows = Integer.parseInt(st.nextToken());
            int columns = Integer.parseInt(st.nextToken());
            int initiallyColouredCells = Integer.parseInt(st.nextToken());

            numberlist = new Cell[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    numberlist[i][j] = new Cell(i, j, 0);
                }
            }

            // Zellen einfärben
            for (int k = 0; k < initiallyColouredCells; k++) {
                st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                numberlist[x][y].filled = 1;
            }
            while (didchange) {
                didchange = false;
                for (int l = 0; l < rows; l++) {
                    for (int m = 0; m < columns; m++) {
                        if (numberlist[l][m].filled == days) {
                            cellcheck(l, m);
                        }
                    }
                }
                if (didchange) {
                    days++;
                }
            }
            out.println(days);
            out.close();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cellcheck(int x, int y) {

        //links
        if (x - 1 >= 0 && numberlist[x - 1][y].filled == 0) {
            didchange = true;
            numberlist[x - 1][y].filled = days + 1;
        }
        //rechts
        if (x + 1 < numberlist.length && numberlist[x + 1][y].filled == 0) {
            didchange = true;
            numberlist[x + 1][y].filled = days + 1;
        }
        //unten
        if (y - 1 >= 0 && numberlist[x][y - 1].filled == 0) {
            didchange = true;
            numberlist[x][y - 1].filled = days + 1;
        }
        //oben
        if (y + 1 < numberlist[0].length && numberlist[x][y + 1].filled == 0) {
            didchange = true;
            numberlist[x][y + 1].filled = days + 1;
        }
    }
}

