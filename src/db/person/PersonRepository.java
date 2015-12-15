package db.person;

import domain.person.Person;

import java.util.List;

public interface PersonRepository {

    Person get(int personId);

    List<Person> getAll();

    void add(Person person);

    void update(Person person);

    void delete(int id);

    int generateNewId();

    Person getPersonByEmail(String email);
}