/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Apr 8, 2023
 */
package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Activities;
import dmacc.beans.Customer;
import dmacc.beans.Resort;
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
	ActivitiesRepository ActivitiesRepo;
	
	@GetMapping({"/viewAllVacations"})
	public String viewAllVacations(Model model)	{
		if(VacationsRepo.findAll().isEmpty()) {
			return addNewVacations(model);
		}
		model.addAttribute("vacations", VacationsRepo.findAll());
		model.addAttribute("customers", CustomerRepo.findAll());
		model.addAttribute("resorts", ResortRepo.findAll());
		model.addAttribute("activities", ActivitiesRepo.findAll());
		return "vacationsResults";
	}
			
	@GetMapping("/inputVacation")	
	public String addNewVacations(Model model) {
		if(CustomerRepo.count() <= VacationsRepo.count()) {
			Customer c = new Customer();
			model.addAttribute("newCustomer", c);
			return "customerInput";
		}
		if(ResortRepo.count() <= VacationsRepo.count()) {
			Resort r = new Resort();
			model.addAttribute("newResort", r);
			return "resortInput";
		}
		if(ActivitiesRepo.count() <= VacationsRepo.count()) {
			Activities a = new Activities();
			model.addAttribute("newActivity", a); //connects to the input pages object name
			List<String> options = new ArrayList<String>();
			options.add("Tour");
			options.add("Art");
			options.add("Dining");
			options.add("Night Life");
			model.addAttribute("options", options);
			return "activityInput";
		}
		model.addAttribute("customers", CustomerRepo.findAll());
		model.addAttribute("resorts", ResortRepo.findAll());
		model.addAttribute("activities", ActivitiesRepo.findAll());
		
		Vacations v = new Vacations();
		model.addAttribute("newVacation", v);
		return "vacationInput";
	}
	
	@PostMapping("/inputVacation") 
	public String addNewVacations(@ModelAttribute Vacations v, Model model) {
		System.out.println("Input Vacation " + v );
		double vacationCost = v.getResort().getCost() + v.getActivity().getCost();
		v.setVacationCost(vacationCost);
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
		model.addAttribute("activities", ActivitiesRepo.findAll());
		
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
		//long customerId = v.getCustomer().getCustomerId();					// Example code to test removing customer from its OWN TABLE
		//Customer c = CustomerRepo.findById(customerId).orElse(null);
		//v.setCustomer(null);												// set private customer attribute to null to break the join
		//CustomerRepo.delete(c);
		VacationsRepo.delete(v);
		return viewAllVacations(model);
	}
	
	

}