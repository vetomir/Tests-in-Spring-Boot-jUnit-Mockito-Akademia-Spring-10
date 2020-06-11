package pl.gregorymartin.testspringbootexerciseakademiaspringhw;


public class Person {
    private String name;
    private String surname;
    private Gender gender;

    public Person(final String name, final String surname, final Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }
}
