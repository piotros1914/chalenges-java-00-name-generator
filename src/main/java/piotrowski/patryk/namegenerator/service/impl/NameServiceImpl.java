package piotrowski.patryk.namegenerator.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piotrowski.patryk.namegenerator.entity.Name;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import piotrowski.patryk.namegenerator.entity.enums.Nationality;
import piotrowski.patryk.namegenerator.exception.DataNotFound;
import piotrowski.patryk.namegenerator.repository.RandomNameRepository;
import piotrowski.patryk.namegenerator.service.NameService;

@Service
public class NameServiceImpl implements NameService {

    @Autowired
    RandomNameRepository randomNameRepository;

    private static final Logger log = LoggerFactory.getLogger(LastnameServiceImpl.class);

    @Override
    public String generateFirstName(Gender gender, Nationality nationality) {
        return getRandomName(gender, nationality).getName();
    }

    @Override
    public String generateSecondName(String firstName, Gender gender, Nationality nationality) {
        String secondName = null;
        do{
            secondName = getRandomName(gender, nationality).getName();
        } while (firstName.equals(secondName));
        return secondName;
    }

    private Name getRandomName(Gender gender, Nationality nationality){
        Name name = null;
        try {
            name = randomNameRepository.getRandomNameByCountryAndGender(gender, nationality);
        } catch (DataNotFound dataNotFound) {
            StringBuilder sb = new StringBuilder();
            sb.append("Name not found for ");
            sb.append("gender ").append(gender).append(" ");
            sb.append("nationality ").append(nationality).append(" ");
            throw new RuntimeException(sb.toString(), dataNotFound);
        }
        return name;
    }
}
