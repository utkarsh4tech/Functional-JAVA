package collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Max_Min {
    public static void main(String[] args) {
        List<Person> persons =Person.getPersons();//List.of();
        
        //Getting maximum age
        System.out.println(
        persons.stream()
            .mapToInt(Person::getAge)
            .max()
            );

        //Getting minimum age
        System.out.println(
        persons.stream()
            .mapToInt(Person::getAge)
            .min()
            );

        //what if we want the Person(object) 
        //or some other property of object instead of just age...

        System.out.println(
            persons.stream()
                .collect(
                    Collectors.maxBy(Comparator.comparing(Person::getAge)))
        );

        //But this returns an optional... so what now?
        System.out.println(
            persons.stream()
                .collect(
                    Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Person::getAge)), 
                        // person->person.getName() 
                        // -- The method getName() is undefined for the type Optional<Person>
                        person->person.map(Person::getName).orElse("")
                        )
                )
        );
    }
}
