package ua.roscha.spring.dao;

import org.springframework.stereotype.Component;
import ua.roscha.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 23, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 41, "bob@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 15, "mike@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 33, "katy@gmail.com"));
    }

    public List<Person> index() {
        System.out.println("Return peoples list: " + people);
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
