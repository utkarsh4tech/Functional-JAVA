package collectors;

import java.util.Map;
import java.util.stream.Collectors;

public class Mapping {
    public static void main(String[] args) {
        
        Map<String, Integer> mapNameAge = Person.getPersons().stream()
                                                    //.collect(Collectors.toMap(KeyFunction,ValueFunction))
                                                    //.collect(Collectors.toMap(p->p.getAge(),p->p.getName()))
                                                    .collect( Collectors.toMap( Person::getName, Person::getAge ) );
        System.out.println(mapNameAge);
                                
        
    }
}
