public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1 + salary attribute");
        Person a1 = new Person();
        System.out.println(a1.toString());

        System.out.println();
        System.out.println("Task 2");
        PersonList l = new PersonList(7);
        l.print();

        System.out.println();
        System.out.println("Sorted by age: ");
        for(Person person : l.sortByAge()){
            System.out.println(person);
        }

        System.out.println();
        System.out.println("Sorted by salary: ");
        for(Person person : l.sortBySalary2()){
            System.out.println(person);
        }

        System.out.println();
        System.out.println("Task 3, average age of people who earn more than 2000: " + l.AvAge(2000.00) );
        System.out.println();
        System.out.println("FileGenerator");


        NameGenerator n1 = new NameGenerator(3,"test.txt");
        ProcessFiles p1 = new ProcessFiles("test.txt", 3);
        System.out.println();
        p1.WriteCSVFile("tryCSV.csv");


    }
}
