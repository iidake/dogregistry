package hh.swd20.dogregistry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.dogregistry.model.Breed;
import hh.swd20.dogregistry.model.BreedRepository;
import hh.swd20.dogregistry.model.FCIBreedGroup;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BreedRepositoryTest {

    @Autowired
    private BreedRepository repository;

    @Test
    public void findByName() {
        List<Breed> breeds = repository.findByName("Labradorinnoutaja");
        
        assertThat(breeds).hasSize(1);
    }  
    
    @Test
    public void createNewBreed() {
    	Breed breed = new Breed("Villakoira", new FCIBreedGroup("FCI 9 Seura- ja kääpiökoirat"));
    	repository.save(breed);
    	assertThat(breed.getBreedId()).isNotNull();
    }  
    
    @Test
    public void deleteAllBreeds() {
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }   

}
