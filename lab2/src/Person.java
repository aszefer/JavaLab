public class Person {
    private String name;
    private String surname;
    private int age;
    private double salary;
    private String gender;

    public static Integer randAge (int min, int max){
        return min +(int)(Math.random()*((max - min)+1));

    }
    public static double randSalary (double min, double max){
        return min +(int)(Math.random()*((max - min)+1));

    }

    public static String randGender (){
        int min = 0;
        int max =1;
        int res = min +(int)(Math.random()*((max - min)+1));
        if (res == 0) {return "man";}
        else {return "woman";}
    }

    public static String randName (){
        String[] names  = {"A", "B", "C","D","E","F","G"};
        int i = (int)(Math.random()*((6)+1));
        return names[i];

    }

    public static String randSName (){
        String[] snames  = {"Aa", "Bb", "Cc","Dd","Ee","Ff","Gg"};
        int i = (int)(Math.random()*((6)+1));
        return snames[i];
    }


    public Person() {

        this.name = randName();
        this.surname = randSName();
        this.age = randAge(1,100);
        this.salary = randSalary(1000.00,5000.00);
        this.gender = randGender();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name:'" + name + '\'' +
                ", surname:" + surname + '\'' +
                ", age:" + age +
                ", salary:" + salary +
                ", gender: " + gender +
                '}';
    }
}
