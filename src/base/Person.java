package base;

import java.util.ArrayList;

public class Person {

    public int id;
    public static ArrayList<Person> personList = new ArrayList<>();
    public String name;
    public String nationalID;

    public Person(String name, String nationalID) {
        this.name = name;
        this.nationalID = nationalID;
        this.id = personList.size() + 1;
        personList.add(this);
    }

    public static Person findByID(int id) {
        for (Person person : personList) {
            if (person.id == id) {
                return person;
            }
        }
        return null;
    }
}
