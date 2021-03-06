package vaccination;

public class Person {

    private String name;
    private int age;
    private ChronicDisease chronic;
    private Pregnancy pregnant;

    public Person(String name, int age, ChronicDisease chronic, Pregnancy pregnant) {
        this.name = name;
        this.age = age;
        this.chronic = chronic;
        this.pregnant = pregnant;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ChronicDisease getChronic() {
        return chronic;
    }

    public Pregnancy getPregnant() {
        return pregnant;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", chronic=" + chronic +
                ", pregnant=" + pregnant +
                "\n";
    }
}
