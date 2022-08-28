/*
Consumers are like void functions, they take in one parameter but return nothing
Syntax:
Consumer<InputType> consumerName = (inputObj)-> doSomeThing;
Using:
consumerName.accept(inputObj);
 */
package imperative;

import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer utkarsh=new Customer("Utkarsh","99999");
        greetCustomer(utkarsh);

        //Functional way for using Consumer
        Consumer<Customer> greetCustomerConsumer =
                customer ->  System.out.println("Hello "+customer.name+" & "+ customer.phnNum);
        greetCustomerConsumer.accept(utkarsh);
    }

    //Declarative way of using Function
    public static void greetCustomer(Customer customer){
        System.out.println("Hello "+customer.name+" & "+ customer.phnNum);
    }

    static class Customer{
        private final String name;
        private final String phnNum;

        Customer(String name, String phnNum) {
            this.name = name;
            this.phnNum = phnNum;
        }
    }
}
