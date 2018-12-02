package piotrowski.patryk.namegenerator.commandLine.model;

import com.beust.jcommander.Parameter;
import piotrowski.patryk.namegenerator.commandLine.validator.GenderValidator;
import piotrowski.patryk.namegenerator.commandLine.validator.NationalityValidator;

public class CommandLineArgs {

    @Parameter(names = "-gender", description = "Gender", validateWith = GenderValidator.class)
    private String gender;

    @Parameter(names = "-nationality", description = "Nationality", validateWith = NationalityValidator.class)
    private String nationality;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "CommandLineArgs{" +
                "gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
