package combinatorpattern;

import java.time.LocalDate;

public class Customer {

    private final String name,email,phnNo;
    private final LocalDate dob;

    //constructor
    Customer(String name,String email,String phnNo,LocalDate dob){
        this.name=name;
        this.email=email;
        this.phnNo=phnNo;
        this.dob=dob;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhnNo() {
        return phnNo;
    }

    public LocalDate getDob() {
        return dob;
    }

}
