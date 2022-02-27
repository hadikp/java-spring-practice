package applicants;

import java.util.ArrayList;
import java.util.List;

public class ListByApplicantsPersonal implements ApplicantListGenerator {

    private ApplicantRepository applicantRepository;

    public ListByApplicantsPersonal(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public List<Applicant> getListFromDatabase() {
        List<Applicant> loadFromDatabase = applicantRepository.loadData();
        List<Applicant> result = new ArrayList<>();
        for(Applicant a: loadFromDatabase) {
            result.add(new Applicant(a.getFirstName(), a.getLastName(), a.getTelephone(), a.getEmail()));
        }
        return result;
    }
}
