package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegValidator extends Function <Customer,ValidationResults> {

    static CustomerRegValidator isValidEmail(){
        return customer-> customer.getEmail().contains("@")
                            ?ValidationResults.SUCCESS
                            :ValidationResults.EMAIL_NOT_VERIFIED;
    }

    static CustomerRegValidator isValidPhnNo(){
        return customer-> customer.getPhnNo().startsWith("+91")
                            && customer.getPhnNo().length()==13
                            ?ValidationResults.SUCCESS
                            :ValidationResults.PHN_NO_NOT_VERIFIED;
    }

    static CustomerRegValidator isAdult(){
        return customer -> Period.between(
            customer.getDob(), LocalDate.now()
            ).getYears()>=18
            ?ValidationResults.SUCCESS
            :ValidationResults.IS_NOT_ADULT;
    }

    default CustomerRegValidator and (CustomerRegValidator other){
        return customer -> {
            ValidationResults res = this.apply(customer);
            return res.equals(ValidationResults.SUCCESS)
                    ? other.apply(customer)
                    :res;
        };
    }
}
