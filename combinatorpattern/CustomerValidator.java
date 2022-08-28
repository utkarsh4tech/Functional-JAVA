package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidator {
    

    private boolean isValidEmail(String email){
        return email.contains("@");
    }

    private boolean isValidPhnNo(String num){
        return num.length()==13
                && num.startsWith("+91");
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(
            dob, LocalDate.now()
            ).getYears()>=18;
    }

    public boolean isValid(Customer c){
        return isValidEmail(c.getEmail()) 
            && isValidPhnNo(c.getPhnNo()) 
            && isAdult(c.getDob());

    }
}
