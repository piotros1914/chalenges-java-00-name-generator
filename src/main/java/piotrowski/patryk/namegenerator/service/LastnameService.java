package piotrowski.patryk.namegenerator.service;

import org.springframework.stereotype.Service;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import piotrowski.patryk.namegenerator.entity.enums.Nationality;

@Service
public interface LastnameService {

    String generateLastname(Gender gender, Nationality nationality);
}
