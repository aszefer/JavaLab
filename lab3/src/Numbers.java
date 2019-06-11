import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    private List<Double> numbers = new ArrayList<>();
    private List<Double> sorted = new ArrayList<>();

    public Numbers(int n){

        for (int i = 0; i < n; i++) {
            double randReal = Math.random();
            numbers.add(randReal);

        }
    }

    public Numbers(String path){
        try {
            File file1 = new File(path);
            Scanner myReader = new Scanner(file1);
            while (myReader.hasNextLine()) {
                double n2 = Double.parseDouble(myReader.nextLine());
                numbers.add(n2);
            }

            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Numbers(List<Double> n){
        for (double d : n){
            numbers.add(d);
        }

    }

    public List<Double> ToList() {
        return numbers;
    }



    /*public void parseToNumbers(List<Double> l){
        Numbers l = new Numbers()

    }*/

    public double Average(){
        double sum = 0;
        for (double n : numbers){
            sum += n;

        }
        double av = sum/numbers.size();
        return av;
    }

    public double MaxNb(){
        int index = numbers.indexOf(Collections.max(numbers));
        return numbers.get(index);
    }

    public double MinNb(){
        int index = numbers.indexOf(Collections.min(numbers));
        return numbers.get(index);
    }

    public void SortedList(){
        for (double n : numbers){
            sorted.add(n);
        }
        Collections.sort(sorted);
        System.out.println(sorted);

    }

    public double Median(){
        double median;
        double n1;
        double n2;
        if (sorted.size() % 2 == 0){
            n1 = sorted.get(sorted.size()/2);
            n2 = sorted.get((sorted.size()/2)-1);
            median = n1+n2/2;
        }else
            median = sorted.get(sorted.size()/2);
        return median;
    }

    public void PrintList(){
        System.out.println(numbers);
    }

    public String Show(){
        return numbers.toString();
    }




    public void WritePlain(String fileName){
        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            for(Double d : numbers){
                myWriter.write(d.toString()+"\n");
            }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }

    public void WriteToFile(String fileName){
        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            myWriter.write("Generated list of real numbers: \n");
            myWriter.write(numbers.toString()+ "\n\n");
            myWriter.write("Sorted list of real numbers: \n");
            myWriter.write(sorted.toString()+ "\n\n");
            myWriter.write("Average: " + Average() + "\n\n");
            myWriter.write("Maximum nb: " + MaxNb() + "\n\n");
            myWriter.write("Minimum: " + MinNb() + "\n\n");
            myWriter.write("Median: " + Median() + "\n\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
