package hh.swd20.dogregistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.dogregistry.model.Breed;
import hh.swd20.dogregistry.model.BreedRepository;
import hh.swd20.dogregistry.model.Dog;
import hh.swd20.dogregistry.model.DogRepository;
import hh.swd20.dogregistry.model.FCIBreedGroup;
import hh.swd20.dogregistry.model.FCIBreedGroupRepository;

@SpringBootApplication
public class DogregistryApplication {
	private static final Logger log = LoggerFactory.getLogger(DogregistryApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DogregistryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DogRepository dogRepository, BreedRepository breedRepository, FCIBreedGroupRepository breedGroupRepository) {
	return (args) -> {
		log.info("save dogs");
		
		FCIBreedGroup breedGroup1 = new FCIBreedGroup("FCI 5 Pystykorvat ja alkukantaiset koirat");
		FCIBreedGroup breedGroup2 = new FCIBreedGroup("FCI 8 Noutajat, ylösajavat koirat ja vesikoirat");
		FCIBreedGroup breedGroup3 = new FCIBreedGroup("FCI 10 Vinttikoirat");
		
		breedGroupRepository.save(breedGroup1);
		breedGroupRepository.save(breedGroup2);
		breedGroupRepository.save(breedGroup3);
		
		Breed breed1 = new Breed("kultainennoutaja", breedGroup2);
		Breed breed2 = new Breed("labradorinnoutaja", breedGroup2);
		Breed breed3 = new Breed("whippet", breedGroup3);
		
		breedRepository.save(breed1);
		breedRepository.save(breed2);
		breedRepository.save(breed3);
		
		Dog dog1 = new Dog("Kultainen Kultahippu", "Veera Valtava", breed1);
		Dog dog2 = new Dog("Kultainen Kimallus", "Jouni Heino", breed1);
		Dog dog3 = new Dog("Vilkas Vieteri", "Leena Katos", breed3);
		
		dogRepository.save(dog1);
		dogRepository.save(dog2);
		dogRepository.save(dog3);
		
		log.info("fetch all breedgroups");
		for (FCIBreedGroup FCIBreedGroup : breedGroupRepository.findAll()) {
			log.info(FCIBreedGroup.toString());
		}
		
		log.info("fetch all breeds");
		for (Breed breed : breedRepository.findAll()) {
			log.info(breed.toString());
		}
		
		log.info("fetch all dogs");
		for (Dog dog : dogRepository.findAll()) {
			log.info(dog.toString());
		}
		
	};
	}
	
}
