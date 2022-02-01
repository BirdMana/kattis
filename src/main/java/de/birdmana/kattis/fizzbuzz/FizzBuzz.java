package de.birdmana.kattis.fizzbuzz;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.MonthDay;

public class FizzBuzz {
    public static void main(String[] args) {

//        TEST
//        String test = "2 3 7";
//        InputStream is = new ByteArrayInputStream( test.getBytes(StandardCharsets.UTF_8) );

//        try(Kattio io = new Kattio(is, System.out)) {
        try(Kattio io = new Kattio(System.in, System.out)) {
            int fizz = io.getInt();
            int buzz = io.getInt();
            int end = io.getInt();

            for(int i = 1; i <= end; i++) {
                if(((i % fizz) == 0) && ((i % buzz) == 0)) {
                    io.println("FizzBuzz");
                } else if((i % fizz) == 0) {
                        io.println("Fizz");
                    } else if((i % buzz) == 0) {
                            io.println("Buzz");
                            } else {
                                io.println(i);
                                }
            }

        }
    }
}
