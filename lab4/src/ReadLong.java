import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadLong {
    private List<Long> longs = new ArrayList<>();

    public  List<Long> ReadLong(String path) {
        try {
            File file1 = new File(path);
            Scanner myReader = new Scanner(file1);
            while (myReader.hasNextLine()) {
                String[] datas = myReader.nextLine().split(",");
                for(String l: datas){
                    longs.add(Long.parseLong(l));
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return longs;
    }

}
