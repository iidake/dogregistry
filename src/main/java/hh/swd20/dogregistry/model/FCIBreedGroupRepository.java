 package hh.swd20.dogregistry.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FCIBreedGroupRepository extends CrudRepository<FCIBreedGroup, Long> {
	
	List<FCIBreedGroup> findByName(String name);

}
