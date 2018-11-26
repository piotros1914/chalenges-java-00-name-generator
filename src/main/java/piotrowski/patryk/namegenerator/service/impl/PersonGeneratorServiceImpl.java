package piotrowski.patryk.namegenerator.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piotrowski.patryk.namegenerator.entity.Lastname;
import piotrowski.patryk.namegenerator.entity.enums.Country;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import piotrowski.patryk.namegenerator.exception.DataNotFound;
import piotrowski.patryk.namegenerator.model.Person;
import piotrowski.patryk.namegenerator.repository.RandomLastnameRepository;
import piotrowski.patryk.namegenerator.repository.RandomNameRepository;
import piotrowski.patryk.namegenerator.service.PersonGeneratorService;

@Service
public class PersonGeneratorServiceImpl implements PersonGeneratorService {

    private static final Logger log = LoggerFactory.getLogger(PersonGeneratorServiceImpl.class);

    @Autowired
    RandomNameRepository randomNameRepository;

    @Autowired
    RandomLastnameRepository randomLastnameRepository;

    @Override
    public Person generatePerson() {
        return generatePerson(Country.PL);
    }

    @Override
    public Person generatePerson(Country nationality) {
        return generatePerson(generateGender(), nationality);
    }

    @Override
    public Person generatePerson(Gender gender, Country nationality) {
        log.info("generatePerson()", gender, nationality);
        Person person = null;
        try {
            person = generatePersonWithoutCatchException(gender, nationality);
        } catch (DataNotFound dataNotFound) {
            log.error("Person generation error: ", dataNotFound.getMessage());
        }
        return person;
    }

    private Person generatePersonWithoutCatchException(Gender gender, Country nationality) throws DataNotFound {
        Person person = new Person();
        person.setGender(gender);
        person.setNationality(nationality);
        person.setFirstName(generateFirstName(gender, nationality));
        person.setSecondName(generateSecondName(person.getFirstName(), gender, nationality));
        person.setLastname(generateLastname(gender, nationality));
        return person;
    }

    private Gender generateGender() {
        return Gender.random();
    }

    private String generateFirstName(Gender gender, Country country) {
        return randomNameRepository.getRandomNameByCountryAndGender(gender, country).getName();
    }

    private String generateSecondName(String firstName, Gender gender, Country country) {
        String secondName = null;
        do{
            secondName = randomNameRepository.getRandomNameByCountryAndGender(gender, country).getName();
        } while (firstName.equals(secondName));
        return secondName;
    }

    private String generateLastname(Gender gender, Country country) throws DataNotFound {
        Lastname lastname = randomLastnameRepository.getRandomLastnameByCountry(country);
        if(lastname == null){
            throw new DataNotFound("Not found lastname for country: " + country);
        }
        String lastNameStr = lastname.getLastname();
        if(Gender.FEMALE.equals(gender)){
            if( lastNameStr.endsWith("ski")){
                lastNameStr = lastNameStr.replace("ski", "ska");
            } else if( lastNameStr.endsWith("cki")){
                lastNameStr = lastNameStr.replace("cki", "cka");
            } else if( lastNameStr.endsWith("dzki")){
                lastNameStr = lastNameStr.replace("dzki", "dzka");
            }
        }
        return lastNameStr;
    }
}
