package piotrowski.patryk.namegenerator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piotrowski.patryk.namegenerator.commandLine.model.CommandLineArgs;
import piotrowski.patryk.namegenerator.service.CommandLineService;
import piotrowski.patryk.namegenerator.entity.enums.Nationality;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import piotrowski.patryk.namegenerator.model.Person;
import piotrowski.patryk.namegenerator.service.PersonGeneratorService;

@Service
public class CommandLineSerivceImpl implements CommandLineService {

    @Autowired
    PersonGeneratorService personGeneratorService;

    @Override
    public Person generatePerson(CommandLineArgs args) {
        Gender gender = Gender.getGenderBySymbol(args.getGender());
        Nationality nationality = Nationality.getNationalityBySymbol(args.getNationality());
        if(gender != null && nationality != null) {
            return personGeneratorService.generatePerson(gender, nationality);
        }
        if(gender != null){
            return personGeneratorService.generatePerson(gender);
        }
        if(nationality != null){
            return personGeneratorService.generatePerson(nationality);
        }
        return personGeneratorService.generatePerson();
    }
}
