package ladybird;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LadyBirdTest {
    private LadyBird ladybird;

    @BeforeEach
    public void setUp() {
        try {
            MariaDbDataSource dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/ladybird?useUnicode=true");
            dataSource.setUser("lady");
            dataSource.setPassword("lady");

            Flyway flyway = Flyway.configure().locations("db/migration/ladybird").dataSource(dataSource).load();
            flyway.clean();
            flyway.migrate();

            //ladybird = new LadyBird(dataSource);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get data.", sqle);
        }
    }

    @Test
    void init() {
        System.out.println();
    }

   /* @Test
    public void testGetLadybirdsWithExactNumberOfPoints() {
        List<String> ladybirds = ladybird.getLadybirdsWithExactNumberOfPoints(11);

        assertEquals(5, ladybirds.size());
        assertEquals("sziki tizenegypettyes katica", ladybirds.get(2));
    }

    @Test
    public void testGetLadybirdsWithNotExistingNumberOfPoints() {
        List<String> ladybirds = ladybird.getLadybirdsWithExactNumberOfPoints(100);

        assertEquals(0, ladybirds.size());
    }

    @Test
    public void testGetLadybirdsByNumberOfPoints() {
        Map<Integer, Integer> numberOfLadybirdsByPoints = ladybird.getLadybirdsByNumberOfPoints();

        assertEquals(1, numberOfLadybirdsByPoints.get(24));
        assertEquals(5, numberOfLadybirdsByPoints.get(11));
        assertEquals(2, numberOfLadybirdsByPoints.get(7));
    }

    @Test
    public void testGetLadybirdByPartOfLatinNameAndNumberOfPoints() {
        Set<Ladybug> ladybirds = ladybird.getLadybirdByPartOfLatinNameAndNumberOfPoints("Scymnus", 2);

        assertEquals(4, ladybirds.size());
        assertTrue(ladybirds.contains(new Ladybug("ostoros bödice", "(Scymnus flagellisiphonatus)", "bödiceformák (Scymninae)", 2)));
        assertFalse(ladybirds.contains(new Ladybug("sárgafejű bödice", "(Scymnus auritus)", "bödiceformák (Scymninae)", 0)));
    }

    @Test
    public void testGetLadybirdStatistics() {
        Map<String, Integer> ladybirdStatistics = ladybird.getLadybirdStatistics();

        assertEquals(36, ladybirdStatistics.get("katicaformák (Coccinellinae)"));
        assertEquals(5, ladybirdStatistics.get("szerecsenkata-formák (Chilocorinae)"));
    }*/

}