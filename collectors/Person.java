package collectors;

import java.util.List;

public class Person{
    private final int age;
    private final String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static List<Person> getPersons(){
        return List.of(
            new Person(22,"YXZ"),
            new Person(22, "YjZ"),
            new Person(12, "HGS"),
            new Person(72, "OWM"),
            new Person(3, "ISN")
        );
    }

    @Override
    public String toString(){
        return this.name+"->"+this.age;
    }

}