/*
Supplier represents a function with single return value which takes in no argument
Syntax:
Supplier<OutputType> supplierName = ()-> return Something;
Using:
supplierName.get();
Note:
BiSupplier Doesn't exist
 */
package imperative;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(dbUrl());
        //functional way
        Supplier<String> dbUrlConsumer = () -> "jdbc://localhost:5432/users";
        System.out.println(dbUrlConsumer.get());
    }

    //Declarative way
    public static String dbUrl(){
        return "jdbc://localhost:5432/users";
    }
}
