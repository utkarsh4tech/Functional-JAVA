/*
 * Pattern Matching must not be confused with the
 * regular expression matching.
 * 
 * This is for making our code more readable, understandable & also ready for production
 */
package pattern_matching;

import java.util.Arrays;
import java.util.Objects;

public class pattern_matching{

    /*
        Cerimonious Code ... Very Verbose 
        Better way to use a ** Switch Statement **
    */
    public static String process(Object o) {
        if(o instanceof Integer){
            Integer num = (Integer)o;
            return "I got Number "+ num;
        }
        else if(o instanceof String){
            String s= (String)o;
            return "I got String of Length " + s.length();
        }
        else if(o instanceof Boolean){
            Boolean flag=(Boolean)o;
            return "I got the Boolean Value " + flag.toString();
        }
        else return "I don't Know how to process";

    }

    public static String switchStatement(Object o){
        String str;
        if(!Objects.isNull(o)){
            switch (o) {
                case Integer num:
                    str="I got Number "+ num;
                    break;
                
                case String s:
                    str="I got String of Length " + s.length();
                    break;

                case Boolean flag:
                    str="I got the Boolean Value " + flag.toString();
                    break;
                
                default:
                    str="I don't Know how to process";
                    break;
            }
        }
        else str="Don't mess up with null";
        return str;
    }

    public static String switchExp(Object obj){
        return switch (obj) {
            case Integer num -> "I got an integer "+num;
            case String s -> "I got an string of length "+ s.length();
            case Boolean flag -> "I got a Boolean value " + flag.toString();
            case null -> "Don't mess up with null";
            default -> "Don't Know what to do";
        };
    }

    public static void main(String[] args) {
        var list = Arrays.asList(10,"Hello World",true,null);
        
        // Just a way of processing the Objects
        list.stream()
            .map(pattern_matching::process)
            .forEach(System.out::println);
        System.out.println();

        // lets say we add a null to the list then the code blows up...
                list.stream()
            .map(pattern_matching::switchStatement)
            .forEach(System.out::println);      
        System.out.println();

        // lets use switch expression...
        list.stream()
            .map(pattern_matching::switchExp)
            .forEach(System.out::println);
        System.out.println();
    }
}