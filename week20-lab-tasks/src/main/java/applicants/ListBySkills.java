package applicants;

import java.util.ArrayList;
import java.util.List;

public class ListBySkills implements ApplicantListGenerator {

    private ApplicantRepository applicantRepository;

    public ListBySkills(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public List<Applicant> getListFromDatabase() {
        List<Applicant> loadFromDatabase = applicantRepository.loadData();
        List<Applicant> result = new ArrayList<>();
        for(Applicant a: loadFromDatabase) {
            if(a.getSkill().length() == 3) {
                result.add(new Applicant(a.getFirstName(), a.getLastName(), a.getSkill()));
            }
        }
        return result;
    }
}
