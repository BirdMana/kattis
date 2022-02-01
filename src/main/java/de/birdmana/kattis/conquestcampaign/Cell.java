package de.birdmana.kattis.conquestcampaign;

public class Cell {
    int x;
    int y;
    int filled = 0;

    public Cell(int x,int y,int filled){
        this.x = x;
        this.y = y;
        this.filled =filled;

    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", filled=" + filled +
                '}';
    }
}
