/*
BiConsumers are like void functions, they take in two parameter but return nothing
Syntax:
BiConsumer<InputType1,InputType2> biConsumerName = (inputObj1,inputObj2)-> doSomeThing;
Using:
biConsumerName.accept(inputObj1,inputObj2);s
 */
package imperative;

import java.util.function.BiConsumer;

public class _BiConsumer {
    public static void main(String[] args) {
        //Functional way
        BiConsumer<DebitCard,Boolean> displayInfo =
                (card,showCVV) ->
                        System.out.println(card.ownerName +
                                " has a card with CVV "+
                                (showCVV?card.cvv:"***"));

        DebitCard JosephCard=new DebitCard("Joseph",898);
        displayInfo.accept(JosephCard, false);

        cardInfo(JosephCard,false);
    }

    //Declarative way
    public static void cardInfo(DebitCard card, boolean showCVV){
        System.out.println(card.ownerName +
                " has a card with CVV "+
                (showCVV?card.cvv:"***"));
    }
    static class DebitCard{
        private final String ownerName;
        private final int cvv;


        DebitCard(String name, int cvv){
            this.ownerName = name;
            this.cvv= cvv;
        }
    }
}

