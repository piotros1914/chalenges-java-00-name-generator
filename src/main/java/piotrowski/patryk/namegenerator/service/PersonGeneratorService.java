package piotrowski.patryk.namegenerator.service;

import org.springframework.stereotype.Service;
import piotrowski.patryk.namegenerator.entity.enums.Nationality;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import piotrowski.patryk.namegenerator.model.Person;

@Service
public interface PersonGeneratorService {

    Person generatePerson();

    Person generatePerson(Nationality nationality);

    Person generatePerson(Gender gender);

    Person generatePerson(Gender gender, Nationality nationality);
}
