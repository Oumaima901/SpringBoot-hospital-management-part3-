package tn.itbs.spring.Controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tn.itbs.spring.Dao.DocteurRepository;
import tn.itbs.spring.entities.Docteur;

@Controller
public class DocteurController {
	@Autowired
	DocteurRepository docteurRepo;
	
	@GetMapping("/AffichageListe")
	public ModelAndView affiche(Model model){
		List<Docteur> listD = docteurRepo.findAll();
		ModelAndView mv = new ModelAndView("AffichageD");
		mv.addObject("listD", listD);
		
		Docteur docteur = new Docteur();
		model.addAttribute("Docteur", docteur);
		return mv;
		
	}
	@PostMapping(value = "/ChercherDoc")
	public ModelAndView ChercherDocteur(@ModelAttribute("Docteur")
	@Valid Docteur doc, BindingResult result, Model model) {
	
	List<Docteur> listdoc = docteurRepo.findAllBynom(doc.getNom());
	ModelAndView mv = new ModelAndView("AffichageD");
	mv.addObject("listD",listdoc);
	return mv ;
	} 
	
	//pour l'ajout on a deux methode afficher le formulaire et une methode pour ajouter 
    //associer au modelAttribute="docteur"
	@GetMapping(value="/addform")
	public String AfficheForm(Model model){
		
		Docteur docteur  = new Docteur();
		model.addAttribute("Docteur", docteur);
		return "AjoutD";
		
	}
	
	
	//associer au action='AjouterDoc'
	@PostMapping(value="/AjouterDoc")
	public String AjouterForm(@ModelAttribute(name="Docteur") 
	@Valid Docteur docteur, BindingResult result, Model model){
		
		if (result.hasErrors()) {
			return "addform";
			}
			docteurRepo.save(docteur);
			return "redirect:/AffichageListe";
			}
	
	
	@RequestMapping("/SupprimerDoc/{id}")
	public String deleteDoc(@PathVariable(name ="id") int id) {
		docteurRepo.deleteById(id);
	    return "redirect:/AffichageListe";       
	}
	
	

	@RequestMapping(value="/editdoc",method=RequestMethod.GET)
	public ModelAndView Editpage( int id) {
	    ModelAndView mv = new ModelAndView("ModifierD");
	    Docteur docteur = docteurRepo.getById(id);
	    System.out.println(docteur.getId());
	    mv.addObject("docteur", docteur );
	     
	    return mv;
	}
	
	

	@PostMapping(value ="/editsave") //formulaire post
	public String editsavedoc(
			@Valid Docteur docteur, BindingResult result, Model model) {
	if (result.hasErrors()) {
	return "AjoutD";
	}
	else {
	docteurRepo.save(docteur);}
	return "redirect:/AffichageListe";
	}
	

	 
	   
	
	
	
	
		
	}
	



