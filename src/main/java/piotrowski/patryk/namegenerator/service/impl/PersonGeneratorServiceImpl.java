package piotrowski.patryk.namegenerator.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piotrowski.patryk.namegenerator.entity.enums.Nationality;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import piotrowski.patryk.namegenerator.model.Person;
import piotrowski.patryk.namegenerator.service.LastnameService;
import piotrowski.patryk.namegenerator.service.NameService;
import piotrowski.patryk.namegenerator.service.PersonGeneratorService;

@Service
public class PersonGeneratorServiceImpl implements PersonGeneratorService {

    private static final Logger log = LoggerFactory.getLogger(PersonGeneratorServiceImpl.class);

    @Autowired
    NameService nameService;

    @Autowired
    LastnameService lastnameService;

    @Override
    public Person generatePerson() {
        return generatePerson(Nationality.PL);
    }

    @Override
    public Person generatePerson(Gender gender) { return generatePerson(gender, generateNationality()); }

    @Override
    public Person generatePerson(Nationality nationality) {
        return generatePerson(generateGender(), nationality);
    }

    @Override
    public Person generatePerson(Gender gender, Nationality nationality) {
        log.info("generatePerson(), {}, {}", gender, nationality);
        Person person = generatePersonWithoutCatchException(gender, nationality);
        return person;
    }

    private Person generatePersonWithoutCatchException(Gender gender, Nationality nationality) {
        Person person = new Person();
        person.setGender(gender);
        person.setNationality(nationality);
        person.setFirstName(nameService.generateFirstName(gender, nationality));
        person.setSecondName(nameService.generateSecondName(person.getFirstName(), gender, nationality));
        person.setLastname(lastnameService.generateLastname(gender, nationality));
        return person;
    }

    private Gender generateGender() {
        return Gender.random();
    }

    private Nationality generateNationality() {
        return Nationality.random();
    }

}
