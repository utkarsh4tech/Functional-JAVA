package streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Filter {
    public static void main(String[] args) {

        List<Person> persons=List.of(
                new Person(19,"ANP"),
                new Person(20,"XYZ"),
                new Person(26,"ABC"),
                new Person(7,"JSH"),
                new Person(9,"IWU")
        );

    /*
        Declarative way of finding adults from a list of persons

            List<Person> adults=new ArrayList<>();
            //External Iterator similar as for loop.....
            for(Person p: persons){
                if(p.age>=18) adults.add(p);
            }
            //internal iterator.....
            adults.forEach(System.out::println);
    */

        //Functional way of filtering out from a collection
        Predicate<Person> isAdult = person -> person.age>=18;
        List<Person> adults = persons.stream()
                                .filter(isAdult)
                                .toList();
        System.out.println("Adults");
        adults.forEach(System.out::println);

        //Negating a Predicate
        List<Person> minors = persons.stream()
                                        .filter(isAdult.negate())
                                        .collect(Collectors.toUnmodifiableList());
        System.out.println("Minors");
        minors.forEach(System.out::println);

        //minors.add(new Person(98,"sss")); will throw an error....

    }

    static class Person{
        private final int age;
        private final String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString(){
            return String.format("Person{ Name: %s & Age: %d }",this.name,this.age);
        }
    }
}
