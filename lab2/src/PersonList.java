import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class PersonList {

       List<Person> personList = new ArrayList<>();


       public PersonList(int n){
           for(int i = 0; i < n; i++){
               personList.add(new Person());

           }
       }

       public void print(){
           for(Person person : personList){
               System.out.println(person.toString());
           }

       }

       public List<Person> sortByAge(){
           int n = personList.size();
           Person tmpPerson = null;

           for (int i = 0; i<n; i++){
               for (int j =0; j <n; j++){
                   int k = j +1;

                   if (k>= n){
                       break;
                   }

                   int age1 = personList.get(j).getAge();
                   int age2 = personList.get(k).getAge();

                   if (age2>age1) {
                       tmpPerson = personList.get(k);
                       personList.set(k, personList.get(j));
                       personList.set(j, tmpPerson);
               }
           }

           }
           return personList;
       }

    public List<Person> sortBySalary(){
        int n = personList.size();
        Person tmpPerson = null;

        for (int i = 0; i<n; i++){
            for (int j =0; j <n; j++){
                int k = j +1;

                if (k>= n){
                    break;
                }

                double salary1 = personList.get(j).getSalary();
                double salary2 = personList.get(k).getSalary();

                if (salary2>salary1) {
                    tmpPerson = personList.get(k);
                    personList.set(k, personList.get(j));
                    personList.set(j, tmpPerson);
                }
            }

        }
        return personList;
    }
    public List<Person> sortBySalary2(){
           personList.sort(Comparator.comparingDouble(Person::getSalary));
           return personList;

    }

    public int AvAge(double max){
        int sum = 0;
        int counter =0;

        for(Person person : personList){

            if (person.getSalary() < max){
                continue;}
            else {
                sum += person.getAge();
                counter++;
            }
            }
        if (counter ==0){
            System.out.println("Nobody earns more than " +max);
            return 0;
        }
        else{
            return sum/counter;
        }


        }
