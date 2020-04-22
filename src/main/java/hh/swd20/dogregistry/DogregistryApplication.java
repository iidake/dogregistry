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
import hh.swd20.dogregistry.model.User;
import hh.swd20.dogregistry.model.UserRepository;

@SpringBootApplication
public class DogregistryApplication {
	private static final Logger log = LoggerFactory.getLogger(DogregistryApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DogregistryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DogRepository dogRepository, BreedRepository breedRepository, FCIBreedGroupRepository breedGroupRepository, UserRepository userRepository) {
	return (args) -> {
		log.info("save dogs");
		
		FCIBreedGroup breedGroup1 = new FCIBreedGroup("FCI 1 Lammas- ja karjakoirat (paitsi sveitsinpaimenkoirat)");
		FCIBreedGroup breedGroup2 = new FCIBreedGroup("FCI 2 Pinserit, snautserit, molossityyppiset ja sveitsinpaimenkoirat");
		FCIBreedGroup breedGroup3 = new FCIBreedGroup("FCI 3 Terrierit");
		FCIBreedGroup breedGroup4 = new FCIBreedGroup("FCI 4 Mäyräkoirat");
		FCIBreedGroup breedGroup5 = new FCIBreedGroup("FCI 5 Pystykorvat ja alkukantaiset koirat");
		FCIBreedGroup breedGroup6 = new FCIBreedGroup("FCI 6 Ajavat ja jäljestävät koirat");
		FCIBreedGroup breedGroup7 = new FCIBreedGroup("FCI 7 Seisovat lintukoirat");
		FCIBreedGroup breedGroup8 = new FCIBreedGroup("FCI 8 Noutajat, ylösajavat koirat ja vesikoirat");
		FCIBreedGroup breedGroup9 = new FCIBreedGroup("FCI 9 Seurakoirat ja kääpiökoirat");
		FCIBreedGroup breedGroup10 = new FCIBreedGroup("FCI 10 Vinttikoirat");
		
		breedGroupRepository.save(breedGroup1);
		breedGroupRepository.save(breedGroup2);
		breedGroupRepository.save(breedGroup3);
		breedGroupRepository.save(breedGroup4);
		breedGroupRepository.save(breedGroup5);
		breedGroupRepository.save(breedGroup6);
		breedGroupRepository.save(breedGroup7);
		breedGroupRepository.save(breedGroup8);
		breedGroupRepository.save(breedGroup9);
		breedGroupRepository.save(breedGroup10);
		
		Breed breed1 = new Breed("Kultainennoutaja", breedGroup8);
		Breed breed2 = new Breed("Labradorinnoutaja", breedGroup8);
		Breed breed3 = new Breed("Whippet", breedGroup10);
		
		breedRepository.save(breed1);
		breedRepository.save(breed2);
		breedRepository.save(breed3);
		
		Dog dog1 = new Dog("Kultainen Kultahippu", "Veera Valtava", breed1);
		Dog dog2 = new Dog("Kultainen Kimallus", "Jouni Heino", breed1);
		Dog dog3 = new Dog("Vilkas Vieteri", "Leena Katos", breed3);
		
		dogRepository.save(dog1);
		dogRepository.save(dog2);
		dogRepository.save(dog3);
		
		User user1 = new User("user", "$2a$04$xt9Bi1Vmnp/jTx6eULMtmeMpTtEsBYjgWYPy4ZmxcsdxMA.pTUp52", "user@mail.com", "USER");
		User user2 = new User("admin", "$2a$04$QDzL8YmTLzBFRizwV5o7e.8Inz6QoBvTOLBN8FYqfk0Vqe.vWgXoS", "admin@gmail.com", "ADMIN");
		userRepository.save(user1);
		userRepository.save(user2);
		
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
