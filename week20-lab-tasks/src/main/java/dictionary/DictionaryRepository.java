package dictionary;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DictionaryRepository {

    private JdbcTemplate jdbcTemplate;

    public DictionaryRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertWords (String hungarian, String english) {
        jdbcTemplate.update("Insert into dict(hungarian, english) values(?,?)", hungarian, english);
    }

    public String findEnglishWord(String hungarianWord) {
        return jdbcTemplate.queryForObject("Select * from dict where hungarian = ?"
                , (rs, rowNum) -> rs.getString("english"), hungarianWord);
    }

    public String getHungarianWord(String englishWord) {
        return jdbcTemplate.queryForObject("Select * from dict where english = ?"
                , (rs, rowNum) -> rs.getString("hungarian"), englishWord);
    }


}
