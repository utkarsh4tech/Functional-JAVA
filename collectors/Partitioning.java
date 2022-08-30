package collectors;

import java.util.stream.Collectors;

public class Partitioning {
    public static void main(String[] args) {
        /*
            Let say we want lists people whose age is even and odd
            List<Person> evenAge,oddAge;
            evenAge=Person.getPersons().stream()
                        .filter(p->p.getAge()%2==0)
                        .toList();
            oddAge=Person.getPersons().stream()
                        .filter(p->p.getAge()%2!=0)
                        .toList();
            System.out.println(evenAge);
            System.out.println(oddAge);
        */

        System.out.println(
            Person.getPersons().stream()
                    .collect(Collectors.partitioningBy(p->p.getAge()%2==0))
        );
        
    }
}
