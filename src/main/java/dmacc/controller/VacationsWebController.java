/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Apr 8, 2023
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Vacations;
import dmacc.repository.ActivitiesRepository;
import dmacc.repository.CustomerRepository;
import dmacc.repository.ResortRepository;
import dmacc.repository.VacationsRespository;

@Controller
public class VacationsWebController {
	@Autowired
	VacationsRespository VacationsRepo;
	
	@Autowired
	CustomerRepository CustomerRepo;
	
	@Autowired
	ResortRepository ResortRepo;
	
	@Autowired
	ActivitiesRepository ActivitesRepo;
	
	@GetMapping({"/viewAllVacations"})
	public String viewAllVacations(Model model)	{
		if(VacationsRepo.findAll().isEmpty()) {
			return addNewVacations(model);
		}
		model.addAttribute("vacations", VacationsRepo.findAll());
		model.addAttribute("customers", CustomerRepo.findAll());
		model.addAttribute("resorts", ResortRepo.findAll());
		model.addAttribute("activities", ActivitesRepo.findAll());
		return "vacationsResults";
	}
			
	@GetMapping("/inputVacation")	
	public String addNewVacations(Model model) {
		model.addAttribute("customers", CustomerRepo.findAll());
		model.addAttribute("resorts", ResortRepo.findAll());
		model.addAttribute("activities", ActivitesRepo.findAll());
		
		Vacations v = new Vacations();
		model.addAttribute("newVacation", v);
		return "vacationInput";
	}
	
	@PostMapping("/inputVacation") 
	public String addNewVacations(@ModelAttribute Vacations v, Model model) {
		System.out.println("Input Vacation " + v );
		VacationsRepo.save(v);
		return viewAllVacations(model);
	}
	
	@GetMapping("editVacation/{vacationId}")
	public String showUpdateVacations(@PathVariable("vacationId") long vacationId, Model model) {
		System.out.println("editVacation " + vacationId);
		Vacations v = VacationsRepo.findById(vacationId).orElse(null);
		model.addAttribute("newVacation", v);
		
		model.addAttribute("customers", CustomerRepo.findAll());
		model.addAttribute("resorts", ResortRepo.findAll());
		model.addAttribute("activities", ActivitesRepo.findAll());
		
		return "vacationInput";
	}
	
	@PostMapping("/updateVacation/{vacationId}")
	public String reviseVacations(@ModelAttribute Vacations v, Model model) {
		System.out.println("updateVacation " + v);
		VacationsRepo.save(v);
		return viewAllVacations(model);
	}
	
	@GetMapping("/deleteVacation/{vacationId}")
	public String deleteUser(@PathVariable("vacationId") long vacationId, Model model) {
		Vacations v = VacationsRepo.findById(vacationId).orElse(null);
		VacationsRepo.delete(v);
		return viewAllVacations(model);
	}

}