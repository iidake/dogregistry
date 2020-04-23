package hh.swd20.dogregistry.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Breed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long breedId;
	@NotEmpty
	private String name;
	
    @ManyToOne
    //@JsonManagedReference
    @JoinColumn(name = "groupId")
    private FCIBreedGroup FCIBreedGroup;
    
    @JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "breed")
	private List<Dog> dogs;
	
	//konstruktorit
	
	public Breed() {
	}
	
	public Breed(String name, FCIBreedGroup FCIBreedGroup) {
		super();
		this.name = name;
		this.FCIBreedGroup = FCIBreedGroup;
	}
	
	//getterit ja setterit

	public Long getBreedId() {
		return breedId;
	}

	public void setBreedId(Long breedId) {
		this.breedId = breedId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public FCIBreedGroup getFCIBreedGroup() {
		return FCIBreedGroup;
	}

	public void setFCIBreedGroup(FCIBreedGroup fCIBreedGroup) {
		FCIBreedGroup = fCIBreedGroup;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}
	
	//toString

	@Override
	public String toString() {
		if (this.FCIBreedGroup != null)
			return "Breed [breedId=" + breedId + ", name=" + name +  ", FCIBreedGroup=" + this.getFCIBreedGroup() + "]";
		else
			return "Breed [breedId=" + breedId + ", name=" + name + "]";
	}
	
}
