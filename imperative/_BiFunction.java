/*
A BiFunction takes in Two Input parameter
Syntax :
BiFunction<FirstInputType,SecondInputType,OutputType> biFunctionName =
                                (InputObj1,InputObj2) -> DoSomething;
Using:
biFunctionName.apply(InputObj1,InputObj2);
*/
package imperative;

import java.util.function.BiFunction;

public class _BiFunction {
    public static void main(String[] args) {
        //Declarative way
        System.out.println(addTwoAndMul(8, 10));

        //Functional Way
        BiFunction<Integer, Integer, String> addTwoAndMulBiFun =
                (num, mul) -> (num + 2) * mul + "@";
        //invoking BiFunction
        System.out.println(addTwoAndMulBiFun.apply(8, 10));
    }

    public static String addTwoAndMul(int num, int mul){
        return (num+2)*mul+"*";
    }
}
