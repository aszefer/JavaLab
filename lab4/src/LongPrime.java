import java.io.FileWriter;
import java.io.IOException;



public class LongPrime extends Thread {
    private Long number;
    private FileWriter myWriter;


    public LongPrime(Long number) {
        this.number = number;

    }



    @Override
    public void run() {
        IsPrime n = new IsPrime();
        System.out.println("Number in thread " + Thread.currentThread().getName()
                  +  ", "+ number + ", is prime: " + n.IsPrime(number) );
        String stat;
        if (n.IsPrime(number)==true){
            stat = "yes";
        }else stat = "no";
        String data = number + " " + stat;
        //String data = Thread.currentThread().getName() + " " + n.IsPrime(number);
        //System.out.println(data);
        WriteToFile(myWriter,data);


    }



   public synchronized void WriteToFile (FileWriter fw, String data){
       try {
           fw = new FileWriter("output", true);
           fw.write(data + "\n");
           fw.close();
           System.out.println("Successfully wrote to the file.");
       } catch (IOException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }

    }

}
