/*
A Function takes in One Input parameter
Syntax :
Function<InputType,OutputType> FunctionName = (InputObj) -> DoSomething;
Using:
FunctionName.apply(InputObj);
*/

package imperative;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        int num=0;
        //Declarative Style of Function
        System.out.println(num+"-->"+increment(num));

        //Functional way of defining function
        Function<Integer,Integer> increaseByOne = n->n+1;

        //Invoking Function
        System.out.println(increaseByOne.apply(22));

        Function<Integer,Integer> multiplyByTen = n->n*10;

        //Function Chaining, a benefit of Imperative Style
        System.out.println(increaseByOne.andThen(multiplyByTen).apply(12));

    }

    public static int increment(int n){
        return n+1;
    }
}
