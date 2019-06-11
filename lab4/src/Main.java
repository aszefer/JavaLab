import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
       /* System.out.println("Task 1:");



        for (int i = 0; i < 5; i++) {
            SimpleApp a = new SimpleApp("Process");
            a.start();

        }
        System.out.println(); */
        System.out.println("Task 2:");

        for (int i = 0; i < 50000; i++) {
            long rang = 20000000000000L;
            Random rr = new Random();
            long n = (long)(rr.nextDouble()*rang);
            LongPrime l = new LongPrime(n);
            l.start();
        }

        ReadLong r = new ReadLong();
        List<Long> longs;
        longs = r.ReadLong("new.csv");

        for(long l: longs){
            LongPrime c = new LongPrime(l);
            c.start();
        }

    }
}

