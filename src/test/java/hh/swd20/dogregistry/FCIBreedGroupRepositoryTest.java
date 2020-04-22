package hh.swd20.dogregistry;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.dogregistry.model.FCIBreedGroup;
import hh.swd20.dogregistry.model.FCIBreedGroupRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FCIBreedGroupRepositoryTest {

    @Autowired
    private FCIBreedGroupRepository repository;

    @Test
    public void findByName() {
        List<FCIBreedGroup> breedgroups = repository.findByName("FCI 10 Vinttikoirat");
        assertThat(breedgroups).hasSize(1);
    }  
    
    @Test
    public void createNewBreed() {
    	FCIBreedGroup breedgroup = new FCIBreedGroup("FCI 9 Seura- ja kääpiökoirat");
    	repository.save(breedgroup);
    	assertThat(breedgroup.getGroupId()).isNotNull();
    }  
    
    @Test
    public void deleteAllBreedGroups() {
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }   

}
