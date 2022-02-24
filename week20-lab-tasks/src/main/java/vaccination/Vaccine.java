package vaccination;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class Vaccine {

    private VaccineRepository vaccineRepository;

    public Vaccine(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    public List<Person> loadData() {
        return vaccineRepository.dataFromDatabase();
    }

    public List<Person> getVaccinationList() {
        List<Person> persons = loadData();
        return persons;
    }

}
