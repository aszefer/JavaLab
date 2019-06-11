public class Main {

    public static void main(String[] args) {

        System.out.println("Task 1:");
        System.out.println();
        Numbers n = new Numbers(3);


        //n.WritePlain("numbers2.txt");
        Numbers n2 = new Numbers("numbers2.txt"); //desarializes data form file


        System.out.println("List of real numbers: ");
        n.PrintList();
        n2.PrintList(); //initialized from second constructor
        System.out.println();
        System.out.println("Sorted list: ");
        n.SortedList();
        n2.SortedList();
        System.out.println();

        System.out.println("Average: " + n.Average());
        System.out.println("Maximum: " + n.MaxNb());
        System.out.println("Minimum: " + n.MinNb());
        System.out.println("Median: " + n.Median());

        System.out.println();
        System.out.println("Task 2");
        System.out.println("Writing to file:");
        //n.WriteToFile("numbers.txt");



        System.out.println();
        System.out.println("Deserialization, reading from file******************************** ");
        System.out.println();
        Deserialization s = new Deserialization();
        s.Deserialization("numbers.txt");
        System.out.println("******************************************************************");

        System.out.println();
        System.out.println("Task 3: ");
        Multinumbers m = new Multinumbers(4, 3);
        System.out.println("New constructor for multi");
        Multinumbers m2 = new Multinumbers("plainMulti2.txt");
        System.out.println();
        System.out.println("Serialization, writing to file:");
        //m.Serialize("serialized.txt");
        m.Serialize("plainMulti2.txt");
        System.out.println();
        System.out.println("Deserialization ****************************************************");
        m.Deserialize("plainMulti.txt");
        System.out.println("********************************************************************");
        System.out.println();

        System.out.println("Task 4: ");
        System.out.println("Results from  lists: ");
        m.Calc();
        m.printRes();
        System.out.println();

        System.out.println("Sorted by average: ");
        m.SortingListsByAv();
        System.out.println();

        System.out.println("Sorted by mins: ");
        m.SortingListsByMin();
        System.out.println();

        System.out.println("Sorted by maxs: ");
        m.SortingListsByMax();
        System.out.println();



    }
}
