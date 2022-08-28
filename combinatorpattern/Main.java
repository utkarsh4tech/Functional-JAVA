package combinatorpattern;

import java.time.LocalDate;
import static combinatorpattern.CustomerRegValidator.isValidEmail;
import static combinatorpattern.CustomerRegValidator.isValidPhnNo;
import static combinatorpattern.CustomerRegValidator.isAdult;

public class Main {
    public static void main(String[] args) {
        Customer utkarsh = new Customer(
        "Utkarsh", 
        "sahuutkarsh03@gmail.com", 
        "+919264925125",
        LocalDate.of(2003,02,8));

        //System.out.println(new CustomerValidator().isValid(utkarsh)); 

        
        ValidationResults res = isValidEmail()
                                    .and(isValidPhnNo())
                                    .and(isAdult())
                                    .apply(utkarsh);
        
        if(res.equals(ValidationResults.SUCCESS))
            System.out.println(res.name());    
        else throw new IllegalStateException(res.name());
        

    }

}
