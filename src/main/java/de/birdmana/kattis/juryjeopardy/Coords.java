package de.birdmana.kattis.juryjeopardy;

public class Coords implements Comparable<Coords>{

    int x;
    int y;
    char maze;

    public Coords(int x, int y, char maze){
        this.x = x;
        this.y = y;
        this.maze=maze;

    }

    @Override
    public int compareTo(Coords coords) {
        if(this.y > coords.y) {
            return -1;
        } else if(this.y == coords.y && this.x < coords.x) {
            return -1;
        } else if(this.y == coords.y && this.x == coords.x) {
            return 0;
        }
        return 1;
    }
}
