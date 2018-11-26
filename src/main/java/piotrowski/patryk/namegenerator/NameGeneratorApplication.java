package piotrowski.patryk.namegenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import piotrowski.patryk.namegenerator.entity.enums.Country;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import piotrowski.patryk.namegenerator.model.Person;
import piotrowski.patryk.namegenerator.service.PersonGeneratorService;

@SpringBootApplication
public class NameGeneratorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(NameGeneratorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NameGeneratorApplication.class, args);
	}

	@Autowired
	PersonGeneratorService personGenerator;

	@Override
	public void run(String... strings) throws Exception {

		Person person = personGenerator.generatePerson(Gender.FEMALE, Country.PL);
		log.info(person.toString());

	}
}
