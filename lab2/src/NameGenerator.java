import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class NameGenerator {
    private List<String> names = new ArrayList<>();
    private List<String> snames = new ArrayList<>();




    public NameGenerator(int nb, String path){
        ReadFile("name.txt","sname.txt");
        for (int i = 1; i <= nb; i++){
           for(int j = 0; j < 8; j++){
               String fileN = path.split("\\.")[0] + Integer.toString(i) + ".txt";
               int randAge = 18 +(int)(Math.random()*((100 - 18)+1));
               double randSalary = 1000.00 +(int)(Math.random()*((5000.00 - 1000.00)+1));
               String datas  = Generate() + " age: "+ randAge + " salary: "+ randSalary + "\n";
               WriteSingleFile(fileN, datas);
           }

        }

    }

    public void ReadFile(String FirstFile, String SecondFile){
        try {
            File file1 = new File(FirstFile);
            Scanner myReader = new Scanner(file1);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                names.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File file2 = new File(SecondFile);
            Scanner myReader = new Scanner(file2);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                snames.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String Generate(){
        int min = 0;
        int max1 = names.size()-1;
        int max2 = snames.size()-1;
        int randIndex1 = min +(int)(Math.random()*((max1 - min)+1));
        int randIndex2 = min +(int)(Math.random()*((max2 - min)+1));
        String name = names.get(randIndex1);
        String sname = snames.get(randIndex2);
        return name + " " + sname;

    }

    public void WriteSingleFile(String fileName, String data){

        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
