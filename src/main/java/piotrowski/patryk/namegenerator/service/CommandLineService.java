package piotrowski.patryk.namegenerator.service;


import org.springframework.stereotype.Service;
import piotrowski.patryk.namegenerator.commandLine.model.CommandLineArgs;
import piotrowski.patryk.namegenerator.model.Person;

@Service
public interface CommandLineService {

    Person generatePerson(CommandLineArgs args);
}
