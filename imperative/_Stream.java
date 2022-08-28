/*
Stream is a sequence of elements supporting sequential and parallel aggregate operations.

There are a lot of benefits to using streams in Java,
such as the ability to write functions at a more abstract level which can reduce code bugs,
compact functions into fewer and more readable lines of code,
and the ease they offer for parallelization.
 */
package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {
        
        List<Person> personList = List.of(
                new Person("Jane", Person.Gender.FEMALE),
                new Person("Hari", Person.Gender.MALE),
                new Person("Sheela", Person.Gender.FEMALE),
                new Person("Jesus", Person.Gender.MALE),
                new Person("James", Person.Gender.MALE)
        );

        //Declarative way
        List<Person> females=new ArrayList<>();
        for(Person p : personList)
            if(p.gender.equals(Person.Gender.FEMALE))
                females.add(p);
        System.out.println(females);

        //Stream Creation from List
        // Functional way
        List<Person> femalesByStream = personList.stream()
                .filter(p->Person.Gender.FEMALE.equals(p.gender))
                .collect(Collectors.toList());
        System.out.println(femalesByStream);
    }

    static  class Person{
        private final String name;
        private final Gender gender;

        Person(String name,Gender gender){
            this.name=name;
            this.gender=gender;
        }

        @Override
        public String toString(){
            return "Person { Name= '" +this.name+ "' & Gender= '" +this.gender+ "' }";
        }
        enum Gender{
            MALE,FEMALE
        }
    }
}

