package ladybird;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LadyBirdResultTest {

    LadyBirdResult ladyBirdResult;
    LadiBirdrepository ladiBirdrepository;

    @BeforeEach
    public void setUp() {
        try {
            MariaDbDataSource dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/ladybird?useUnicode=true");
            dataSource.setUser("lady");
            dataSource.setPassword("lady");

            Flyway flyway = Flyway.configure().locations("db/migration/ladybird").dataSource(dataSource).load();
            //flyway.clean();
            flyway.migrate();

            ladiBirdrepository = new LadiBirdrepository(dataSource);
            ladyBirdResult = new LadyBirdResult(ladiBirdrepository);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get data.", sqle);
        }
    }

  @Test
    public void testGetLadybirdsWithExactNumberOfPoints() {
        List<String> ladybirds = ladyBirdResult.getLadybirdsWithExactNumberOfPoints(11);

        assertEquals(5, ladybirds.size());
        assertEquals("sziki tizenegypettyes katica", ladybirds.get(2));
    }

    @Test
    public void testGetLadybirdsWithNotExistingNumberOfPoints() {
        List<String> ladybirds = ladyBirdResult.getLadybirdsWithExactNumberOfPoints(100);

        assertEquals(0, ladybirds.size());
    }

    @Test
    public void testGetLadybirdsByNumberOfPoints() {
        Map<Integer, Integer> numberOfLadybirdsByPoints = ladyBirdResult.getLadybirdsByNumberOfPoints();

        assertEquals(1, numberOfLadybirdsByPoints.get(24));
        assertEquals(5, numberOfLadybirdsByPoints.get(11));
        assertEquals(2, numberOfLadybirdsByPoints.get(7));
    }

    @Test
    public void testGetLadybirdByPartOfLatinNameAndNumberOfPoints() {
        Set<LadyBird> ladybirds = ladyBirdResult.getLadybirdByPartOfLatinNameAndNumberOfPoints("Scymnus", 2);

        System.out.println(ladybirds);
        assertEquals(4, ladybirds.size());
        assertTrue(ladybirds.contains(new LadyBird("ostoros bödice", "(Scymnus flagellisiphonatus)", "bödiceformák (Scymninae)", 2)));
        assertFalse(ladybirds.contains(new LadyBird("sárgafejű bödice", "(Scymnus auritus)", "bödiceformák (Scymninae)", 0)));
    }

    @Test
    public void testGetLadybirdStatistics() {
        Map<String, Integer> ladybirdStatistics = ladyBirdResult.getLadybirdStatistics();

        assertEquals(36, ladybirdStatistics.get("katicaformák (Coccinellinae)"));
        assertEquals(5, ladybirdStatistics.get("szerecsenkata-formák (Chilocorinae)"));
    }

}