package collectors;

import java.util.stream.Collectors;

public class Joining {
    
    public static void main(String[] args) {
        
        /*  
            for printing name seperated by comma
            for(Person p : Person.getPersons()){
                System.out.print(p.getName()+", ");
            }
            System.out.println();
        */

        System.out.println(
            Person.getPersons().stream()
                    .map(Person::getName)
                    .collect(Collectors.joining(
                        ", "
                        //, Prefix -- "[ "
                        //, Suffix -- " ]"
                        ))
        );
    }  

}
