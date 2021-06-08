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
import tn.itbs.spring.Dao.PatientRepository;
import tn.itbs.spring.entities.Docteur;
import tn.itbs.spring.entities.Patient;


@Controller
public class PatientController {
	@Autowired
	PatientRepository patientRepo;
	@Autowired
	DocteurRepository docRepo;
	@GetMapping("/AffichageListePatient")
	public ModelAndView affiche(Model model){
		List<Patient> listP = patientRepo.findAll();
		ModelAndView mv = new ModelAndView("AffichagePat");
		mv.addObject("listP", listP);
		
		Patient patient = new Patient();
		model.addAttribute("Patient", patient);
		return mv;
		
	}
	@PostMapping(value = "/ChercherPat")
	public ModelAndView ChercherPatient(@ModelAttribute("Patient")
	@Valid Patient pat, BindingResult result, Model model) {
	
	List<Patient> listpat = patientRepo.findAllByNom(pat.getNom());
	ModelAndView mv = new ModelAndView("AffichagePat");
	mv.addObject("listP",listpat);
	return mv ;
	} 
	@RequestMapping("/SupprimerPat/{id}")
	public String deletePat(@PathVariable(name ="id") int id) {
		patientRepo.deleteById(id);
	    return "redirect:/AffichageListePatient";       
	}




	@ModelAttribute(value="ListDoc")
	public List<Docteur> affichageDOC() {

	return docRepo.findAll();

	}

	
	@GetMapping(value="/ajouterPatient")
	public String AfficheForm(Model model){
		
		Patient patient  = new Patient();
		model.addAttribute("Patient", patient);
		return "AjoutPat";
		
	}
	
	
	//associer au action='AjouterDoc'
	@PostMapping(value="/AjouterPat")
	public String AjouterForm(@ModelAttribute(name="Patient") 
	@Valid Patient patient, BindingResult result, Model model){
		
		if (result.hasErrors()) {
			return "ajouterPatient";
			}
			patientRepo.save(patient);
			return "redirect:/AffichageListePatient";
			}
	
	
	
	@RequestMapping(value="/editpat",method=RequestMethod.GET)
	public ModelAndView Editpage( int id) {
	    ModelAndView mv = new ModelAndView("ModifierPat");
	    Patient patient = patientRepo.getById(id);
	    System.out.println(patient.getId());
	    mv.addObject("patient", patient );
	     
	    return mv;
	}
	


	@PostMapping(value ="/editsavepat") //formulaire post
	public String editsavepat(@Valid Patient patient, BindingResult result, Model model) {
	if (result.hasErrors()) {
	return "AjoutPat";
	}
	else {
	patientRepo.save(patient);
	}
	return "redirect:/AffichageListePatient";
	}
	
	

	

	
	
	

}
