package vaccination;

import javax.sql.DataSource;

public class AstraZeneca extends Vaccine {

    public AstraZeneca(VaccineRepository vaccineRepository) {
        super(vaccineRepository);
    }
}
