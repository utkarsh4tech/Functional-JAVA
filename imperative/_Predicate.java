/*
Represents a boolean-valued function of one argument.
Syntax:
Predicate<InputType> predicateName = (inputObj)-> return true/false after doing something;
Using:
predicateName.test(inputObj);
 */
package imperative;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isValidNum("8999999999"));
        //imperative way
        Predicate<String> isValidNumPredicate =
                phnNum -> phnNum.length()==10 && !phnNum.startsWith("0");

        System.out.println(isValidNumPredicate.test("8999999999"));
        System.out.println(isValidNumPredicate.test("899"));
        System.out.println(isValidNumPredicate.test("0633999992"));

        //We can also use 'and' or 'or' and chain the Predicates like function chaining
        Predicate<String> isTenDigitLong = num->num.length()==10;
        Predicate<String> notStartsWithZero= num->!num.startsWith("0");

        System.out.println(isTenDigitLong.and(notStartsWithZero).test("9820292929"));
        System.out.println(isTenDigitLong.or(notStartsWithZero).test("9820292929"));
        System.out.println(isTenDigitLong.or(notStartsWithZero).test("0820292929"));
        System.out.println(isTenDigitLong.or(notStartsWithZero).test("0292929"));
    }

    //Declarative way
    public static boolean isValidNum(String phnNum){
        return phnNum.length()==10 &&
                !phnNum.startsWith("0");
    }
}
