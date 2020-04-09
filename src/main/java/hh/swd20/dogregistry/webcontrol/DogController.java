package hh.swd20.dogregistry.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.dogregistry.model.Breed;
import hh.swd20.dogregistry.model.BreedRepository;
import hh.swd20.dogregistry.model.Dog;
import hh.swd20.dogregistry.model.DogRepository;
import hh.swd20.dogregistry.model.FCIBreedGroup;
import hh.swd20.dogregistry.model.FCIBreedGroupRepository;

@Controller
public class DogController {
	
	@Autowired
	private DogRepository dogRepository; 
	
	@Autowired
	private BreedRepository breedRepository;
	
	@Autowired
	private FCIBreedGroupRepository breedGroupRepository;

	// etusivu
    @RequestMapping(value="/index")
    public String index() {	
        return "index";
    }	
	
	// listaa kaikki koirat
    @RequestMapping(value= {"/doglist"})
    public String dogList(Model model) {	
        model.addAttribute("dogs", dogRepository.findAll());
        return "doglist";
    }
	
	// REST: listaa kaikki koirat
    @RequestMapping(value="/dogs", method = RequestMethod.GET)
    public @ResponseBody List<Dog> dogListRest() {	
        return (List<Dog>) dogRepository.findAll();
    }
    
	// REST: etsi koira tietyllä id-arvolla
    @RequestMapping(value="/dog/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Dog> findDogRest(@PathVariable("id") Long dogId) {	
    	return dogRepository.findById(dogId);
    }
    
    // tyhjä lomake uuden koiran lisäämiseen
    @RequestMapping(value = "/newdog")
    public String addDog(Model model){
    	model.addAttribute("dog", new Dog());
    	model.addAttribute("breeds", breedRepository.findAll());
        return "dogform";
    }  
    
    // tallenna uusi koira
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Dog dog){
        dogRepository.save(dog);
        return "redirect:doglist";
    } 
    
    // poista koira
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long dogId, Model model) {
    	dogRepository.deleteById(dogId);
        return "redirect:../doglist";
    } 
    
    // muokkaa koiran tietoja
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long dogId, Model model) {
    	model.addAttribute("dog", dogRepository.findById(dogId));
    	model.addAttribute("breeds", breedRepository.findAll());
    	return "editdog";
    }
	
    // listaa kaikki rodut
    @RequestMapping(value= {"/breedlist"})
    public String breedList(Model model) {	
        model.addAttribute("breeds", breedRepository.findAll());
        return "breedlist";
    }
    
	// REST: listaa kaikki rodut
    @RequestMapping(value="/breeds", method = RequestMethod.GET)
    public @ResponseBody List<Breed> breedListRest() {	
        return (List<Breed>) breedRepository.findAll();
    }
    
	// REST: etsi rotu tietyllä id-arvolla
    @RequestMapping(value="/breed/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Breed> findBreedRest(@PathVariable("id") Long breedId) {	
    	return breedRepository.findById(breedId);
    }
    
    // tyhjä lomake uuden rodun lisäämiseen
    @RequestMapping(value = "/newbreed")
    public String addBreed(Model model){
    	model.addAttribute("breed", new Breed());
    	model.addAttribute("breedgroups", breedGroupRepository.findAll());
        return "breedform";
    } 
    
    // muokkaa rodun tietoja
    @RequestMapping(value = "/updateBreed/{id}", method = RequestMethod.GET)
    public String updateBreed(@PathVariable("id") Long breedId, Model model) {
    	model.addAttribute("breed", breedRepository.findById(breedId));
    	model.addAttribute("breedgroups", breedGroupRepository.findAll());
    	return "editbreed";
    }
    
    // tallenna rotu
    @RequestMapping(value = "/saveBreed", method = RequestMethod.POST)
    public String saveBreed(Breed breed){
        breedRepository.save(breed);
        return "redirect:breedlist";
    } 
	
    // lista kaikki roturyhmät
    @RequestMapping(value= {"/breedgrouplist"})
    public String breedGroupList(Model model) {	
        model.addAttribute("breedgroups", breedGroupRepository.findAll());
        return "breedgrouplist";
    }
    
	// REST: listaa kaikki roturyhmät
    @RequestMapping(value="/breedgroups", method = RequestMethod.GET)
    public @ResponseBody List<FCIBreedGroup> breedGroupListRest() {	
        return (List<FCIBreedGroup>) breedGroupRepository.findAll();
    }
    
	// REST: etsi roturyhmä tietyllä id-arvolla
    @RequestMapping(value="/breedgroup/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<FCIBreedGroup> findBreedGroupRest(@PathVariable("id") Long groupId) {	
    	return breedGroupRepository.findById(groupId);
    } 
    
    // muokkaa roturyhmän tietoja
    @RequestMapping(value = "/updateGroup/{id}", method = RequestMethod.GET)
    public String updateGroup(@PathVariable("id") Long groupId, Model model) {
    	model.addAttribute("breedgroup", breedGroupRepository.findById(groupId));
    	return "editbreedgroup";
    }
    
    // tallenna rotu
    @RequestMapping(value = "/saveGroup", method = RequestMethod.POST)
    public String saveGroup(FCIBreedGroup breedGroup){
        breedGroupRepository.save(breedGroup);
        return "redirect:breedgrouplist";
    } 
   
}
