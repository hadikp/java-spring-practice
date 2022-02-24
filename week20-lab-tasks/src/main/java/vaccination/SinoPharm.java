package vaccination;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SinoPharm extends Vaccine {

    public SinoPharm(VaccineRepository vaccineRepository) {
        super(vaccineRepository);
    }

    @Override
    public List<Person> loadData() {
        return super.loadData();
    }

    @Override
    public List<Person> getVaccinationList() {
        List<Person> persons = loadData();
        List<Person> result = new LinkedList<>();
        List<Person> remove = new ArrayList<>();
        for(Person p: persons) {
            if (p.getPregnant() == Pregnancy.YES || p.getChronic() == ChronicDisease.YES) {
                remove.add(p);
            }
        }
        persons.removeAll(remove);
        for(Person p: persons) {
            if(p.getAge() < 65) {
                result.add(p);
            }
        }
        persons.removeAll(result);
        for(Person p: persons) {
            result.add(p);
        }

        return result;
    }
}
