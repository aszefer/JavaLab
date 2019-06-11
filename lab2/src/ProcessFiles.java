import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProcessFiles {
    private List<String> names = new ArrayList<>();
    private List<Integer> age = new ArrayList<>();
    private List<Double> salary = new ArrayList<>();

    private List<String> tempSingleNames = new ArrayList<>();
    private List<Integer> tempSingleAge = new ArrayList<>();
    private List<Double> tempSingleSalary = new ArrayList<>();

    private List<String> maxNames = new ArrayList<>();
    private List<Integer> maxAge = new ArrayList<>();
    private List<Double> avgSalary = new ArrayList<>();




    public ProcessFiles(String path, int nb){

        GetData(path, nb);

        //max age in all files
        int index = age.indexOf(Collections.max(age));
        System.out.println("Highest age in all files is " + Collections.max(age) + " and name of the person is "
                + names.get(index));

        //avg salary in all files
        double sum = 0;
        for(int n = 0; n < salary.size();n ++){
            sum += salary.get(n);
        }
        double av = sum/21;
        System.out.println("The avarage salary from all files is: " + av);
        System.out.println();

        for (int i = 0; i < nb; i++ ){

            System.out.println("Highest age in a single file " + (i + 1)  + " is " + maxAge.get(i)
                    + " and name of the person is " + maxNames.get(i) );
            System.out.println("Average salary in the " + (i + 1) + " file is " + avgSalary.get(i) );
            System.out.println();

        }

    }

    private void GetData(String path, int nb){
        for (int i = 1; i <= nb; i++){
            tempSingleNames.clear();
            tempSingleAge.clear();
            tempSingleSalary.clear();

            String fileN = path.split("\\.")[0] + Integer.toString(i) + ".txt";
            try {
                File file = new File(fileN);
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String [] infos;
                    infos = myReader.nextLine().split(" ");


                    //adding names
                    names.add(infos[0] + " " + infos[1]);
                    tempSingleNames.add(infos[0] + " " + infos[1]);

                    //adding age
                    int dataInt = Integer.parseInt(infos[3]);
                    age.add(dataInt);
                    tempSingleAge.add(dataInt);

                    //adding salary
                    double dataDouble = Double.parseDouble(infos[5]);
                    salary.add(dataDouble);
                    tempSingleSalary.add(dataDouble);

                }

                //max age and name of the person in single file
                int index = tempSingleAge.indexOf(Collections.max(tempSingleAge));
                maxAge.add(Collections.max(tempSingleAge));
                maxNames.add(tempSingleNames.get(index));

                //avg salary in single file
                double sum = 0;
                for(int n = 0; n < tempSingleSalary.size();n ++){
                    sum += tempSingleSalary.get(n);
                }
                double av = sum/tempSingleSalary.size();
                avgSalary.add(av);

                myReader.close();


            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }



    }


    public void WriteCSVFile(String fileName){

        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            myWriter.write("file nb,"+" full name,max age,average salary\n");
            for (int i = 0; i< maxAge.size();i++){


                myWriter.write((i+1) + "," + maxNames.get(i) + "," + maxAge.get(i)
                            + "," + avgSalary.get(i) +"\n");


            }
            int index = age.indexOf(Collections.max(age));

            //avg salary in all files
            double sum = 0;
            for(int n = 0; n < salary.size();n ++){
                sum += salary.get(n);
            }
            double av = sum/21;

            myWriter.write("of all files," + names.get(index)  + "," + Collections.max(age) + "," + av );
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
