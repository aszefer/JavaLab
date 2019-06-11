import java.util.Random;

public class SimpleApp extends Thread{
    private String name;

    public SimpleApp(String name) {
        this.name = name ;
    }

    @Override
    public void run() {
        long range = 20000L;
        Random r = new Random();
        long number = (long)(r.nextDouble()*range);

        System.out.println("Thread " +
                Thread.currentThread().getId());
// do our thing

        name += "_" + Thread.currentThread().getId();
        Thread.currentThread().setName(name);
        PrintNumbers.printNumbers();
        try{
            sleep(number);
        }catch(InterruptedException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }


}
