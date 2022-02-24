package vaccination;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class VaccineRepository {

    private JdbcTemplate jdbcTemplate;

    public VaccineRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertData(String name, int age, ChronicDisease chronic, Pregnancy pregnant) {
        jdbcTemplate.update("Insert into registrations(person_name, age, chronic_disease, pregnancy) values(?,?,?,?)", name, age, chronic.name(), pregnant.name());
    }

    public List<Person> dataFromDatabase() {
        return jdbcTemplate.query("Select * from registrations", (rs, rowNum)
                -> new Person(rs.getString("person_name"), rs.getInt("age")
                , ChronicDisease.valueOf(rs.getString("chronic_disease")), Pregnancy.valueOf(rs.getString("pregnancy"))));
    }
}
