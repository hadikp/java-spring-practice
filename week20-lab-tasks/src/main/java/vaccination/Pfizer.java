package vaccination;

import javax.sql.DataSource;
import java.util.LinkedList;
import java.util.List;

public class Pfizer extends Vaccine {

    public Pfizer(VaccineRepository vaccineRepository) {
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
        getResultPregnant(persons, result);
        getResultOld(persons, result);
        for(Person p: persons) {
            result.add(p);
        }
        return result;
    }

    private void getResultOld(List<Person> persons, List<Person> result) {
        for(Person p: persons) {
            if (p.getAge() > 65) {
                result.add(p);
            }
        }
        persons.removeAll(result);
    }

    private void getResultPregnant(List<Person> persons, List<Person> result) {
        for(Person p: persons) {
            if (p.getPregnant() == Pregnancy.YES) {
                result.add(p);
            }
        }
        persons.removeAll(result);
    }
}
