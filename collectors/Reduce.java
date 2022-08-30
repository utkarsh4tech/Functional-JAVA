/*
 * Java Parallel Streams is a feature of Java 8 and higher, 
 * meant for utilizing multiple cores of the processor. 
 * Normally any java code has one stream of processing,
 *  where it is executed sequentially. 
 * Whereas by using parallel streams, we can divide the code into multiple streams 
 * that are executed in parallel on separate cores and the final result
 * is the combination of the individual outcomes. 
 * The order of execution, however, is not under our control.
 */

package collectors;

import java.util.stream.Collectors;

public class Reduce {
    
    public static void main(String[] args) {

        System.out.println(
        Person.getPersons().stream()
                .filter(p->p.getAge()>=30)
                .map(p->p.getAge())
                .reduce(0,Integer::sum));

        System.out.println(
        Person.getPersons().parallelStream() // parallel Stream is like stream
                    .filter(p->p.getAge()>=20)
                    .map(Person::getName)
                    .map(String::toUpperCase)
                    .collect(Collectors.toSet()));
    }

}
