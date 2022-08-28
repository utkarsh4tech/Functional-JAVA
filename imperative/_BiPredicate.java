/*
Represents a boolean-valued function of two argument.
Syntax:
Predicate<InputType1,InputType2> biPredicateName = (inputObj1,inputObj2)-> return true/false after doing something;
Using:
biPredicateName.test(inputObj);
 */
package imperative;

import java.util.function.BiPredicate;

public class _BiPredicate {
    public static void main(String[] args) {
        System.out.println(isAdditiveInverse(8,-8));

        //Functional way
        BiPredicate<Integer,Integer> isAdditiveInverseBiPredicate =
                (n1,n2)-> n1+n2==0;
        System.out.println(isAdditiveInverseBiPredicate.test(9,0));
        System.out.println(isAdditiveInverseBiPredicate.test(8,-8));
    }

    //Declarative way
    public static boolean isAdditiveInverse(int num1,int num2){
        return num1+num2==0;
    }
}
