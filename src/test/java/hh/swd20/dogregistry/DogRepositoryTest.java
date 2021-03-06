package hh.swd20.dogregistry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.dogregistry.model.Breed;
import hh.swd20.dogregistry.model.Dog;
import hh.swd20.dogregistry.model.DogRepository;
import hh.swd20.dogregistry.model.FCIBreedGroup;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DogRepositoryTest {

    @Autowired
    private DogRepository repository;

    @Test
    public void findByName() {
        List<Dog> dogs = repository.findByName("Vilkas Vieteri");
        
        assertThat(dogs).hasSize(1);
        assertThat(dogs.get(0).getOwner()).isEqualTo("Leena Katos");
    }  
    
    @Test
    public void createNewDog() {
    	Dog dog = new Dog("Etevän Elias", "Minna Virtanen", new Breed("Villakoira", new FCIBreedGroup("FCI 9 Seura- ja kääpiökoirat")));
    	repository.save(dog);
    	assertThat(dog.getDogId()).isNotNull();
    }  
    
    @Test
    public void deleteAllDogs() {
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }   

}
