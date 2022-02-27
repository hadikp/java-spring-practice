package applicants;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ApplicantRepository {

    private JdbcTemplate jdbcTemplate;

    public ApplicantRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Applicant> loadData() {
        return jdbcTemplate.query("Select * from applicants", (rs, rowNum)
                -> new Applicant(rs.getString("first_name"), rs.getString("last_name")
                , rs.getString("phone_number"), rs.getString("email"), rs.getString("skill")));
    }
}
