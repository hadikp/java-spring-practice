package vaccination;

import javax.sql.DataSource;

public class SinoPharm extends Vaccine {

    public SinoPharm(VaccineRepository vaccineRepository) {
        super(vaccineRepository);
    }
}
