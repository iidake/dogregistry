package hh.swd20.dogregistry.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Dog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dogId;
	private String name;
	private String owner;
	
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "breedId")
    private Breed breed;
	
	//konstruktorit
	
	public Dog() {
	}
	
	public Dog(String name, String owner, Breed breed) {
		super();
		this.name = name;
		this.owner = owner;
		this.breed = breed;
	}
	
	//getterit ja setterit
	
	public Long getDogId() {
		return dogId;
	}
	public void setDogId(Long dogId) {
		this.dogId = dogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	//toString
	
	@Override
	public String toString() {
		if (this.breed != null)
			return "Dog [dogId=" + dogId + ", name=" + name + ", owner=" + owner + ", breed=" + this.getBreed() + "]";
		else
			return "Dog [dogId=" + dogId + ", name=" + name + ", owner=" + owner + "]";
	}

}
