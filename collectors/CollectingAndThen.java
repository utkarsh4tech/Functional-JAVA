package collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectingAndThen {
    public static void main(String[] args) {
        List<Person> persons=List.of(
            new Person(22,"YXZ"),
            new Person(22, "YjZ"),
            new Person(12, "HGS"),
            new Person(72, "OWM"),
            new Person(3, "ISN"),
            new Person(23,"YXZ")
        );

        Map<String,Long> mapNameAge = persons.stream()
                                            .collect(Collectors.groupingBy(
                                                p->p.getName(),
                                                Collectors.counting()
                                            ));
        System.out.println(mapNameAge);
        
        //collectingAndThen first collects and then applies the function supplied.....
        Map<String,Integer> mapNameAgeInt = persons.stream()
                                            .collect(Collectors.groupingBy(
                                                p->p.getName(),
                                            //Collectors.collectingAndThen(Collector,Function))
                                            Collectors.collectingAndThen(
                                                Collectors.counting(), 
                                                Long::intValue)    
                                            ));
        System.out.println(mapNameAgeInt);
    }
    
}
