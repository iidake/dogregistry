package hh.swd20.dogregistry.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class FCIBreedGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long groupId;
	private String name;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "FCIBreedGroup")
	private List<Breed> breeds;
	
	//konstruktorit

	public FCIBreedGroup() {
		super();
	}
	
	public FCIBreedGroup(String name) {
		super();
		this.name = name;
	}
	
	//getterit ja setterit

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Breed> getBreeds() {
		return breeds;
	}

	public void setBreeds(List<Breed> breeds) {
		this.breeds = breeds;
	}
	
	//toString

	@Override
	public String toString() {
		return "FCIBreedGroup [id=" + groupId + ", name=" + name + "]";
	}
	
	
}
