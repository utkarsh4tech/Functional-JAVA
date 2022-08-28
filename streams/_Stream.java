package streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import streams._Stream.Person.Gender;

public class _Stream {
    public static void main(String[] args) {

        List<Person> personList = List.of(
                new Person("Jane", Gender.FEMALE),
                new Person("Hari", Gender.MALE),
                new Person("Sheela", Gender.FEMALE),
                new Person("Jesus", Gender.MALE),
                new Person("James", Gender.PREFER_NOT_TO_SAY),
                new Person("Shantanu", Gender.MALE),
                new Person("Isha", Gender.FEMALE)
        );

        // Collecting GENDERS IN A SET
        personList.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                // method reference, same as gender->System.out.println(gender);
                .forEach(System.out::println);


        // Map takes in a Function...
        //Sorted is used for sorting, can take a comparator
        Function<Person,String> personToName = person -> person.name;

        personList.stream()
                .map(personToName)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);

        //Anymatch checks if all of them satisfy the predicate
        Predicate<Person> isFemale=person -> person.gender.equals(Person.Gender.FEMALE);
        boolean femalesOnly = personList.stream()
                                    .allMatch(isFemale);
        System.out.println(femalesOnly);

    /*
        Lets say we want to collect first two males.
        The declarative way to do so would be....

        int limit=2;
        List<Person> firstTwoMale = new ArrayList<>();

        for(Person p: personList){
            if(p.gender.equals(Gender.MALE)){
                firstTwoMale.add(p);
                limit--;
            }
            if(limit==0)break;
        }
        System.out.println(firstTwoMale);
    */

        //functional way for the same task is...
        Predicate<Person> isMale = p-> p.gender.equals(Gender.MALE);
        List<Person> first2males = personList.stream()
                                            .filter(isMale)
                                            .limit(2)
                                            .collect(Collectors.toUnmodifiableList());
    
        System.out.println(first2males);


    }

    static  class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){
            this.name=name;
            this.gender=gender;
        }

        @Override
        public String toString(){
            return String.format("Person { Name: %s & Age: %s}", this.name,this.gender);
        }
        enum Gender{
            MALE,FEMALE,PREFER_NOT_TO_SAY
        }
    }
}
