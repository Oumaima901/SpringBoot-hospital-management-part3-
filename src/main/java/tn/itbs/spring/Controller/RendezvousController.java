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

import tn.itbs.spring.Dao.PatientRepository;
import tn.itbs.spring.Dao.RendezvousRepository;
import tn.itbs.spring.entities.Docteur;
import tn.itbs.spring.entities.Patient;
import tn.itbs.spring.entities.RendezVous;

@Controller
public class RendezvousController {
	@Autowired
	RendezvousRepository RDVRepo;
	@Autowired
	PatientRepository patientRepo;
	@GetMapping("/AffichageListeRDV")
	public ModelAndView affiche(Model model){
		List<RendezVous> listRDV = RDVRepo.findAll();
		ModelAndView mv = new ModelAndView("AffichageRdv");
		mv.addObject("listRDV", listRDV);
		
		RendezVous rendezVous = new RendezVous();
		model.addAttribute("RendezVous", rendezVous);
		return mv;
		
	}
	@PostMapping(value = "/ChercherRdv")
	public ModelAndView ChercherRendezvous(@ModelAttribute("RendezVous")
	@Valid RendezVous rdv, BindingResult result, Model model) {
	
	List<RendezVous> listrdv = RDVRepo.findAllByDate(rdv.getDate());
	ModelAndView mv = new ModelAndView("AffichageRdv");
	mv.addObject("listRDV",listrdv);
	return mv ;
	} 
	
	@RequestMapping("/SupprimerRdv/{id}")
	public String deleteRDV(@PathVariable(name ="id") int id) {
		RDVRepo.deleteById(id);
	    return "redirect:/AffichageListeRDV";       
	}
	@ModelAttribute(value="ListPatient")
	public List<Patient> affichagePat() {

	return patientRepo.findAll();

	}
	@GetMapping(value="/ajouterRendezVous")
	public String AfficheForm(Model model){
		
		RendezVous rendezvous  = new RendezVous();
		model.addAttribute("RendezVous", rendezvous);
		return "AjoutRdv";
		
	}
	
	
	//associer au action='AjouterDoc'
	@PostMapping(value="/AjouterRDV")
	public String AjouterForm(@ModelAttribute(name="RendezVous") 
	@Valid RendezVous rendezVous, BindingResult result, Model model){
		
		if (result.hasErrors()) {
			return "ajouterRendezVous";
			}
			RDVRepo.save(rendezVous);
			return "redirect:/AffichageListeRDV";
			}
	
	
	@RequestMapping(value="/editrdv",method=RequestMethod.GET)
	public ModelAndView Editpage( int id) {
	    ModelAndView mv = new ModelAndView("ModifierRdv");
	    RendezVous RendezVous = RDVRepo.getById(id);
	    System.out.println(RendezVous.getId());
	    mv.addObject("RendezVous", RendezVous );
	     
	    return mv;
	}
	


	@PostMapping(value ="/editsaverdv") //formulaire post
	public String editsavepat(@Valid RendezVous RendezVous, BindingResult result, Model model) {
	if (result.hasErrors()) {
	return "ajouterRendezVous";
	}
	else {
		RDVRepo.save(RendezVous);
	}
	return "redirect:/AffichageListeRDV";
	}



}
