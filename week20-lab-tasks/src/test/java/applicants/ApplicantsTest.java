package applicants;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantsTest {

    private ApplicantListGenerator generator;
    private MariaDbDataSource dataSource;
    ApplicantRepository applicantRepository;

    @BeforeEach
    public void setUp() {
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/applicant?useUnicode=true");
            dataSource.setUser("applicant");
            dataSource.setPassword("applicant");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get data.", sqle);
        }

        Flyway fw = Flyway.configure().locations("db/migration/applicants").dataSource(dataSource).load();
        //fw.clean();
        fw.migrate();
        applicantRepository = new ApplicantRepository(dataSource);
    }

    @Test
    public void testListByApplicantsPersonal() {
        generator = new ListByApplicantsPersonal(applicantRepository);
        List<Applicant> applicants = generator.getListFromDatabase();

        assertEquals(1000, applicants.size());
        assertEquals("Bolding", applicants.get(12).getLastName());
        assertEquals("+353 (391) 686-0269", applicants.get(307).getTelephone());
        assertEquals("sbuchananll@goodreads.com", applicants.get(777).getEmail());
        assertNull(applicants.get(456).getSkill());
        //assertTrue(applicants.contains(new Applicant("Margarette", "Vaudin", "+33 (596) 756-4732", "mvaudin76@gov.uk")));
    }

    @Test
    public void testListBySkills() {
        generator = new ListBySkills(applicantRepository);
        List<Applicant> applicants = generator.getListFromDatabase();

        assertEquals(178, applicants.size());
        assertEquals("Ashbridge", applicants.get(10).getLastName());
        assertEquals("Yuri", applicants.get(15).getFirstName());
        assertEquals("EKG", applicants.get(174).getSkill());
        assertNull(applicants.get(34).getTelephone());
        assertNull(applicants.get(122).getEmail());
        //assertTrue(applicants.contains(new Applicant("Zackariah", "Strewther", "DLX")));
    }

}