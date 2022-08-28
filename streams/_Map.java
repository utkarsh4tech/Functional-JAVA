package streams;

import java.util.List;

public class _Map {
    public static void main(String[] args) {

        List<Student> stu = List.of(
                                new Student("Utkarsh", "Sahu", 19, 6),
                                new Student("Varsha", "Rani", 20, 5),
                                new Student("Srijan", "Pandey", 21, 7),
                                new Student("Yerish", "Raj", 21, 6),
                                new Student("Sourav", "Sinha", 22, 4),
                                new Student("Ritul", "Arora", 21, 7)
                            );
        
        // Maps are used to transform the data from one thing to another
    
        stu.stream()
                .filter(s -> s.age<=20)
                .map(s -> String.format("FirstName: %s - LastName: %s", s.fName,s.lName))
                .forEach(System.out::println);

        // mapToInt is used to map to change the incoming data to Integer
        System.out.println(
        stu.stream()
            .mapToInt(s -> s.countSub)
            .sum());

        // mapToDouble is used to map to change the incoming data to Double
        System.out.println(
            stu.stream()
                .mapToDouble( s-> s.fName.length() / s.lName.length() )
                .max()
                .orElse(-1)
        );
        
    }
    
    static class Student{
        private final String fName,lName;
        private final int age,countSub;

        Student(String fName,String lName,int age, int countSub){
            this.fName=fName;
            this.lName=lName;
            this.age=age;
            this.countSub=countSub;
        }
                
        @Override
        public String toString(){
            return String.format(
                "Student {%s,%s.%d,%d}",
                this.fName,this.lName,this.age, this.countSub);
        }

    }
}
