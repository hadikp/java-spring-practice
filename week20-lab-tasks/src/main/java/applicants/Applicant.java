package applicants;

public class Applicant {

    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private String skill;

    public Applicant(String firstName, String lastName, String skill) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skill = skill;
    }

    public Applicant(String firstName, String lastName, String telephone, String email) {
       this.firstName = firstName;
       this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
    }

    public Applicant(String firstName, String lastName, String telephone, String email, String skill) {
        this(firstName, lastName, telephone, email);
        this.skill = skill;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getSkill() {
        return skill;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", skill='" + skill + '\'' +
                "\n";
    }
}
