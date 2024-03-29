package domain.person;

import db.person.PersonRepository;
import db.person.PersonRepositoryDB;
import db.person.PersonRepositoryMap;

import java.io.InputStream;
import java.util.List;
/**
 * 
 * @author Larry & Annelore
 *
 */
public class PersonService {
    private PersonRepository personRepository;

    public PersonService() {
        this.personRepository = new PersonRepositoryMap();
    }

    public PersonService(InputStream resourceAsStream) {
        this.personRepository = new PersonRepositoryDB(resourceAsStream);
        /*Person admin =  new Person("admin@administrator.be", "t", "ad", "min", "ergens", PersonType.ADMINISTRATOR);
        this.personRepository.add(admin);*/
    }

    public Person getPerson(int personId) {
        return getPersonRepository().get(personId);
    }

    public Person getPerson(String id) {
        return getPerson(Integer.parseInt(id));
    }

    public Person getPersonByEmail(String email) {
        return getPersonRepository().getPersonByEmail(email);
    }

    public List<Person> getPersons() {
        return getPersonRepository().getAll();
    }

    public void addPerson(Person person) {
        getPersonRepository().add(person);
    }

    public void updatePersons(Person person) {
        getPersonRepository().update(person);
    }

    public void deletePerson(String id) {
        deletePerson(Integer.parseInt(id));
    }

    public void deletePerson(int id) {
        getPersonRepository().delete(id);
    }

    private PersonRepository getPersonRepository() {
        return personRepository;
    }

    public Person authenticate(String email, String password) {
        if (email == null || password == null) {
            throw new IllegalArgumentException("email or password is null");
        }
        Person p = this.getPersonByEmail(email);
        if (p.isCorrectPassword(password)) {
            return p;
        } else {
            throw new IllegalArgumentException("buiten!! dief");
        }
    }
}
