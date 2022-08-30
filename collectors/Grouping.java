package collectors;

import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        System.out.println(
            Person.getPersons().stream()
                    //.collect(Collectors.groupingBy(Function<T,R> -> Collector ))
                    //.collect(Collectors.groupingBy((Function<T,R>,Collector) -> Collector ))
                    //.collect(Collectors.groupingBy(p->p.getName().startsWith("Y"))
                    .collect(Collectors.groupingBy(
                        p->p.getName().startsWith("Y"),
                        Collectors.mapping(Person::getAge, Collectors.toList())
                        ))
        );

        System.out.println(
            Person.getPersons().stream()
                    .collect(Collectors.groupingBy(
                        p->p.getName().startsWith("Y"),
                        Collectors.counting()
                        ))
        );
    }
}
