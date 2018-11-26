package piotrowski.patryk.namegenerator.service;

import org.springframework.stereotype.Service;
import piotrowski.patryk.namegenerator.entity.enums.Country;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import piotrowski.patryk.namegenerator.model.Person;

@Service
public interface PersonGeneratorService {

    Person generatePerson();

    Person generatePerson(Country nationality);

    Person generatePerson(Gender gender, Country nationality);
}
