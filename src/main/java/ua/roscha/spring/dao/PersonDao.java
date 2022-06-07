package ua.roscha.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.roscha.spring.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> index() {
        String selectAllCommand = "SELECT * FROM PERSON";
        List<Person> people = jdbcTemplate.query(selectAllCommand, new PersonRawMapper());
        System.out.println("Return peoples list: " + people);
        return people;
    }

    public Person show(int id) {
        String selectByIdCommand = "SELECT * FROM Person WHERE ID = " + id;
        return jdbcTemplate.queryForObject(selectByIdCommand, new PersonRawMapper());
    }

    public void save(Person person) {
        person.setId((int) (Math.random() * 10_000));
        jdbcTemplate.update("INSERT INTO Person VALUES (?, ?, ?, ?)", person.getId(), person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person updatePerson) {
        String updateCommand = "UPDATE Person "
            + "SET " + " name = " + "'" + updatePerson.getName() + "'" + ", age = " + updatePerson.getAge() + ", email = " + "'" + updatePerson.getEmail()
            + "'" + " WHERE id = " + id;
        System.out.println("COMMAND: " + updateCommand);
        jdbcTemplate.update(updateCommand);
    }

    public void delete(int id) {
        String deleteCommand = "DELETE FROM Person WHERE ID = " + id;
        jdbcTemplate.update(deleteCommand);
    }
}
