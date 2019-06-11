import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Deserialization {

    public void Deserialization(String fileName){
        try {
            File file1 = new File(fileName);
            Scanner myReader = new Scanner(file1);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
