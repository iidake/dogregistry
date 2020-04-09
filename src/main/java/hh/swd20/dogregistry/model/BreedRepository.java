package hh.swd20.dogregistry.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BreedRepository extends CrudRepository<Breed, Long> {
	
	List<Breed> findByName(String name);

}
