package de.birdmana.kattis.astrologicalsign;

import java.time.MonthDay;

public class ZodiacSign {
    private String name;
    private MonthDay start;
    private MonthDay end;

    public ZodiacSign(String name, MonthDay start, MonthDay end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonthDay getStart() {
        return start;
    }

    public void setStart(MonthDay start) {
        this.start = start;
    }

    public MonthDay getEnd() {
        return end;
    }

    public void setEnd(MonthDay end) {
        this.end = end;
    }
}
