package db.person;


import db.BaseRepositoryDB;
import domain.person.Person;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Larry & Annelore
 *
 */

public class PersonRepositoryDB extends BaseRepositoryDB implements PersonRepository {

    public PersonRepositoryDB(InputStream resourceAsStream) {
        // config loading and opening connection is handled by BaseRepositoryDB
        super("persons", resourceAsStream);

    }

    public Person get(int id) {
        try {
            PreparedStatement statement = db.prepareStatement(
                    String.format("SELECT * FROM %s WHERE id = ?", this.getTable())
            );
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            return new Person(
                    id,
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("firstname"),
                    result.getString("lastname"),
                    result.getString("woonplaats"),
                    result.getString("salt")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        try {
            Statement statement = db.createStatement();
            ResultSet results = statement.executeQuery(String.format("SELECT * FROM %s", this.getTable()));
            while (results.next()) {
                persons.add(
                        new Person(
                                results.getInt("id"),
                                results.getString("email"),
                                results.getString("password"),
                                results.getString("firstname"),
                                results.getString("lastname"),
                                results.getString("woonplaats"),
                                results.getString("salt")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return persons;
    }

    public void add(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("No Person given");
        }
        try {
            PreparedStatement statement = db.prepareStatement(
                    String.format("INSERT INTO %s (id, email, password, firstname, lastname, salt, woonplaats) VALUES (?,?,?,?,?,?,?) RETURNING id;", this.getTable())
            );
            statement.setInt(1, this.generateNewId());
            statement.setString(2, person.getEmail());
            statement.setString(3, person.getPassword());
            statement.setString(4, person.getFirstName());
            statement.setString(5, person.getLastName());
            statement.setString(6, person.getSalt());
            statement.setString(7, person.getWoonplaats());
            ResultSet result = statement.executeQuery();
            result.next();
            this.last_insert_id = result.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void update(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("No Person given");
        }
        try {
            PreparedStatement statement = db.prepareStatement(
                    String.format("UPDATE %s SET email=?, password=?, firstname=?, lastname=? WHERE id = ?", this.getTable())
            );
            statement.setString(1, person.getEmail());
            statement.setString(2, person.getPassword());
            statement.setString(3, person.getFirstName());
            statement.setString(4, person.getLastName());
            statement.setInt(5, person.getId());
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = db.prepareStatement(
                    String.format("DELETE FROM %s WHERE id = ?", this.getTable())
            );
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public int generateNewId() {
        return this.last_insert_id + 1;
    }

    @Override
    public Person getPersonByEmail(String email) {
        try {
            PreparedStatement statement = db.prepareStatement(
                    String.format("SELECT * FROM %s WHERE email = ?", this.getTable())
            );
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            result.next();
            return new Person(
                    result.getInt("id"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("firstname"),
                    result.getString("lastname"),
                    result.getString("woonplaats"),
                    result.getString("salt")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}