package pattern_matching;

import java.util.Arrays;

public class gaurded {
    
    public static int gaurdedPattern(Object obj){
        return switch(obj){
            case null,default -> -1;
            case Integer i -> i;
            case Number num ->num.intValue();
            //this is called as an Gaurded pattern or a case with another condition
            case String s && "AEIOUaeiou".indexOf(s.charAt(0)) -> s.length()*10;
            case String s -> s.length();
            case Boolean flag -> flag?1:0;
        };
    }

    public static void main(String[] args) {
        var list = Arrays.asList(10,"Hello World",true,null,-11.0);

    
        list.stream()
            .mapToInt(gaurded::gaurdedPattern)
            .max()
            .ifPresentOrElse(System.out::println, ()->System.out.println("Empty List"));
    }
}
