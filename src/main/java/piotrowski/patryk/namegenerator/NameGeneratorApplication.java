package piotrowski.patryk.namegenerator;

import com.beust.jcommander.JCommander;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import piotrowski.patryk.namegenerator.commandLine.model.CommandLineArgs;
import piotrowski.patryk.namegenerator.model.Person;
import piotrowski.patryk.namegenerator.service.CommandLineService;

@SpringBootApplication
public class NameGeneratorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(NameGeneratorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NameGeneratorApplication.class, args);
	}

	@Autowired
	CommandLineService commandLineService;

	@Override
	public void run(String... args) {
		CommandLineArgs argumets = parseArgs(new CommandLineArgs(), args);
		Person person = commandLineService.generatePerson(argumets);
		log.info("Generated person: {}", person);
	}

	private CommandLineArgs parseArgs(CommandLineArgs out, String... in){
		log.debug("Parsing arguments: {}", in);
		JCommander.newBuilder()
				.addObject(out)
				.build()
				.parse(in);
		log.debug("Parsing results: {}", out);
		return out;
	}
}
