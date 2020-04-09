package hh.swd20.dogregistry.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
	
	List<Dog> findByName(String name);

}
