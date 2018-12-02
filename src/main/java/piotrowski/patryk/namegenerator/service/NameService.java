package piotrowski.patryk.namegenerator.service;

import org.springframework.stereotype.Service;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import piotrowski.patryk.namegenerator.entity.enums.Nationality;

@Service
public interface NameService {

  String generateFirstName(Gender gender, Nationality country);

  String generateSecondName(String firstName, Gender gender, Nationality country);

}
