import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Multinumbers{
    private Numbers[] multi;

    private List<Double> list = new ArrayList<>();
    private List<Double> averages = new ArrayList<>();
    private List<Double> avSorted = new ArrayList<>();

    private List<Double> maxes = new ArrayList<>();
    private List<Double> maxSorted = new ArrayList<>();

    private List<Double> mins = new ArrayList<>();
    private List<Double> minSorted = new ArrayList<>();

    private List<Integer> indexByAv = new ArrayList<>();
    private List<Integer> indexByMax = new ArrayList<>();
    private List<Integer> indexByMin = new ArrayList<>();


    public Multinumbers(int nbOfLists, int nbOfElements) {
        multi = new Numbers[nbOfLists];
        for (int i = 0; i < nbOfLists; i++){
            multi[i] = new Numbers(nbOfElements);
            multi[i].PrintList();
        }

    }



    public Multinumbers(String path){

        try {
            File file1 = new File(path);
            Scanner myReader = new Scanner(file1);
            int counter = 0;
            while (myReader.hasNextLine()) {

                String line = myReader.nextLine();
                if (myReader.hasNext("\n")){
                    multi[counter] = new Numbers(list);
                    counter++;
                    list = new ArrayList<>();
                }else{
                    list.add(Double.parseDouble(line));
                }
            }

            myReader.close();
           /* multi = new Numbers[counter];
            for (int i = 0; i < counter; i++){
                multi[i] = new Numbers(list);
                multi[i].PrintList();
            }*/
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
        for (Numbers n : multi){
            n.PrintList();
        }


    }

    public void Serialize(String path){
        try {
            FileWriter myWriter = new FileWriter(path, true);
            for (Numbers n : multi){

                for(Double d : n.ToList()){
                    myWriter.write(d.toString()+"\n");
                }
                myWriter.write("\n");
            }

            myWriter.close();

            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public void Deserialize(String fileName){
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

    public void Calc(){

        for (Numbers n: multi){

            double av = n.Average();
            averages.add(av);

            double max =n.MaxNb();
            maxes.add(max);

            double min =n.MinNb();
            mins.add(min);


        }



    }

    public void printRes(){
        System.out.println("Averages: ");
        for (double i : averages){
            System.out.println(i);
        }

        System.out.println("Maxes: ");
        for (double i : maxes){
            System.out.println(i);
        }

        System.out.println("Mins: ");
        for (double i : mins){
            System.out.println(i);
        }


    }

    public void SortingListsByAv(){

        for (double i : averages){
            avSorted.add(i);
        }
        Collections.sort(avSorted);

        for (int i = 0; i < avSorted.size(); i++){

            for (int j = 0; j < avSorted.size(); j++){
                if (avSorted.get(i).equals(averages.get(j))){
                    indexByAv.add(j);

                }
            }
        }
        for (int i : indexByAv) multi[i].PrintList();

    }

    public void SortingListsByMax(){

        for (double i : maxes){
            maxSorted.add(i);
        }
        Collections.sort(maxSorted);

        for (int i = 0; i < maxSorted.size(); i++){

            for (int j = 0; j < maxSorted.size(); j++){
                if (maxSorted.get(i).equals(maxes.get(j))){
                    indexByMax.add(j);

                }
            }
        }
        for (int i : indexByMax) multi[i].PrintList();

    }

    public void SortingListsByMin(){

        for (double i : mins){
            minSorted.add(i);
        }
        Collections.sort(minSorted);

        for (int i = 0; i < minSorted.size(); i++){

            for (int j = 0; j < minSorted.size(); j++){
                if (minSorted.get(i).equals(mins.get(j))){
                    indexByMin.add(j);

                }
            }
        }
        for (int i : indexByMin) multi[i].PrintList();

    }


}
