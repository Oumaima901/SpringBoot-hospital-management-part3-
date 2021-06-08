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

import tn.itbs.spring.Dao.ReceptionnisteRepository;

import tn.itbs.spring.entities.Receptionniste;




@Controller
public class ReceptionnisteController {
	@Autowired
	ReceptionnisteRepository recepRepo;
	
	@GetMapping("/AffichageListeRecep")
	public ModelAndView afficheRecep(Model model){
		List<Receptionniste> listRece = recepRepo.findAll();
		ModelAndView mv = new ModelAndView("AffichageRecp");
		mv.addObject("listRece", listRece);
		
		Receptionniste Recep = new Receptionniste();
		model.addAttribute("Receptionniste", Recep);
		return mv;
		
	}
	@PostMapping(value = "/ChercherRecep")
	public ModelAndView ChercherRecep (@ModelAttribute("Receptionniste")
	@Valid Receptionniste Rece, BindingResult result, Model model) {
	
	List<Receptionniste> listRece = recepRepo.findAllByNom(Rece.getNom());
	ModelAndView mv = new ModelAndView("AffichageRecp");
	mv.addObject("listRece",listRece);
	return mv ;
	} 
	@RequestMapping("/SupprimerRecep/{id}")
	public String deleteDoc(@PathVariable(name ="id") int id) {
		recepRepo.deleteById(id);
	    return "redirect:/AffichageListeRecep";       
	}
	
	
	
	//pour l'ajout on a deux methode afficher le formulaire et une methode pour ajouter 
    //associer au modelAttribute="docteur"
	@GetMapping(value="/addformRecep")
	public String AfficheForm(Model model){
		
		Receptionniste recep  = new Receptionniste();
		model.addAttribute("Receptionniste", recep);
		return "AjoutRecep";
		
	}
	
	
	//associer au action='AjouterDoc'
	@PostMapping(value="/AjouterRecep")
	public String AjouterForm(@ModelAttribute(name="Receptionniste") 
	@Valid Receptionniste recep, BindingResult result, Model model){
		
		if (result.hasErrors()) {
			return "addformRecep";
			}
			recepRepo.save(recep);
			return "redirect:/AffichageListeRecep";
			}

	
	
	
	@RequestMapping(value="/editRecep",method=RequestMethod.GET)
	public ModelAndView Editpage( int id) {
	    ModelAndView mv = new ModelAndView("ModifierRecep");
	    Receptionniste Receptionniste = recepRepo.getById(id);
	    System.out.println(Receptionniste.getId());
	    mv.addObject("Receptionniste", Receptionniste );
	     
	    return mv;
	}
	
	

	@PostMapping(value ="/editsaveRecep") //formulaire post
	public String editsaverecp(
			@Valid Receptionniste Receptionniste, BindingResult result, Model model) {
	if (result.hasErrors()) {
	return "AjoutRecep";
	}
	else {
	recepRepo.save(Receptionniste);}
	return "redirect:/AffichageListeRecep";
	}
	
	
}
