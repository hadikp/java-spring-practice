package dictionary;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    DictionaryRepository dictionaryRepository;
    Flyway flyway;

    @BeforeEach
    void init() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/dictionary?useUnicoda=true");
            dataSource.setUser("dicti");
            dataSource.setPassword("dicti");
        }
        catch (SQLException sqe) {
            throw new IllegalStateException("Cannot reach Database!", sqe);
        }

        flyway = Flyway.configure().locations("db/migration/dictionary").dataSource(dataSource).load();
        //flyway.clean();
        flyway.migrate();
        dictionaryRepository = new DictionaryRepository(dataSource);
        /*dictionaryRepository.insertWords("eszik", "eat");
        dictionaryRepository.insertWords("alszik", "sleap");
        dictionaryRepository.insertWords("iszik", "drink");
        dictionaryRepository.insertWords("busz", "bus");
        dictionaryRepository.insertWords("asztal", "table");*/
    }

    @Test
    void testFindEnglishWord() {
        assertEquals("table", dictionaryRepository.findEnglishWord("asztal"));
    }

    @Test
    void testGetHungarianWord() {
        assertEquals("asztal", dictionaryRepository.getHungarianWord("table"));
    }

}