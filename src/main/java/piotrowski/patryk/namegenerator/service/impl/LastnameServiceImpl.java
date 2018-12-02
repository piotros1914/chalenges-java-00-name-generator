package piotrowski.patryk.namegenerator.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import piotrowski.patryk.namegenerator.entity.Lastname;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import piotrowski.patryk.namegenerator.entity.enums.Nationality;
import piotrowski.patryk.namegenerator.exception.DataNotFound;
import piotrowski.patryk.namegenerator.repository.RandomLastnameRepository;
import piotrowski.patryk.namegenerator.service.LastnameService;

@Service
public class LastnameServiceImpl  implements LastnameService {

    @Autowired
    RandomLastnameRepository randomLastnameRepository;

    private static final Logger log = LoggerFactory.getLogger(LastnameServiceImpl.class);

    @Override
    public String generateLastname(Gender gender, Nationality nationality)  {
        Lastname lastname = getRandomLastname(gender, nationality);
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

    private Lastname getRandomLastname(Gender gender, Nationality nationality){
        Lastname lastname = null;
        try {
            lastname = randomLastnameRepository.getRandomLastnameByCountry(nationality);
        } catch (DataNotFound dataNotFound) {
            StringBuilder sb = new StringBuilder();
            sb.append("Lastname not found for ");
            sb.append("gender ").append(gender).append(" ");
            sb.append("nationality ").append(nationality).append(" ");
            throw new RuntimeException(sb.toString(), dataNotFound);
        }
        return lastname;
    }
}
