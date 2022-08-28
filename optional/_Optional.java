/*
 * Optional is a container object which may or may not contain a non-null value.
 * 
 * By using Optional, we can specify alternate values to return or alternate code to run. 
 * This makes the code more readable because the facts which were hidden are
 * now visible to the developer.
 */
package optional;

import java.util.List;
import java.util.Optional;

public class _Optional {

    public static void main(String[] args) {
        
        System.out.println(
            Optional.ofNullable(null)
            .orElseGet(() -> "No Value")
        );

        System.out.println(
            Optional.ofNullable("Hello")
            .orElseGet(() -> "Default Value")
        );
        
        // ifPresentOrElse takes in a Consumer and executes this if value is present
        // and the second parameter is a Runnable and performs this if no Value is present
        Optional.ofNullable(null)
                .ifPresentOrElse(
                    email->{
                        //Can aslo do some Logic...
                        System.out.println("Sending mail to "+email);
                    },
                    ()->{
                        //Can aslo do some Logic...
                        System.out.println("No email Passed");
                    }
            );
    /*
     * Let say we want to find first element from 
     * a list that satisfies few condition....
     * if we go by declarative approach then there is a high chance
     * that we might face a NullPointerException
     */
        List<Integer> nums= List.of();// List.of(2,3,4,2,9,-1,-2,0);
        System.out.println(
            nums.stream()
                .filter(e -> e%2==0)
                .filter(e -> e>=3)
                .mapToInt(e -> e*e)
                .findFirst()
            );

    }
}
