package piotrowski.patryk.namegenerator.model;

import piotrowski.patryk.namegenerator.entity.enums.Nationality;
import piotrowski.patryk.namegenerator.entity.enums.Gender;

public class Person {

    Gender gender;

    String firstName;

    String secondName;

    String lastname;

    Nationality nationality;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender=" + gender +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nationality=" + nationality +
                '}';
    }
}
