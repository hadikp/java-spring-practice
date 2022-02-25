package ladybird;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class LadiBirdrepository {

    private JdbcTemplate jdbcTemplate;

    public LadiBirdrepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<LadyBird> loadData() {
        return jdbcTemplate.query("Select * from ladybirds", (rs, rowNum)
                -> new LadyBird(rs.getString("hungarian_name"), rs.getString("latin_name"), rs.getString("genus"), rs.getInt("number_of_points")) );
    }
}
