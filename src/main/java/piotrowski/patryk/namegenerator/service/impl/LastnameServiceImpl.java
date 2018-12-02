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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class LastnameServiceImpl  implements LastnameService {

    @Autowired
    RandomLastnameRepository randomLastnameRepository;

    private static final Logger log = LoggerFactory.getLogger(LastnameServiceImpl.class);

    private static final Map<String, String> endOfSurnames;

    static {
        Map<String, String> ends = new HashMap<>();
        ends.put("ski", "ska");
        ends.put("cki", "cka");
        ends.put("dzki", "dzka");

        endOfSurnames = Collections.unmodifiableMap(ends);
    }

    @Override
    public String generateLastname(Gender gender, Nationality nationality)  {
        String lastname = getRandomLastname(gender, nationality).getLastname();
        if(Gender.FEMALE.equals(gender)){
            lastname = replaceEnds(lastname);
        }
        return lastname;
    }

    String replaceEnds(String lastname) {
        log.debug("replaceEnds(), {}", lastname);
        for (Map.Entry<String, String> ends : endOfSurnames.entrySet()){
            if (lastname.endsWith(ends.getKey())) {
                log.debug("replace end from {} to {}", ends.getKey(), ends.getValue());
                lastname = lastname.replace(ends.getKey(), ends.getValue());
                break;
            }
         }
        return lastname;
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
