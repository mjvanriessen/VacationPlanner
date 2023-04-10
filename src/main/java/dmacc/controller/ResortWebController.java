package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Resort;
import dmacc.repository.ResortRepository;

@Controller
public class ResortWebController {
	@Autowired
	ResortRepository resortRepo;
	
	@GetMapping({"/viewAllResorts"})
	public String viewAllResorts(Model model)	{
		if(resortRepo.findAll().isEmpty()) {
			return addNewResort(model);
		}
		model.addAttribute("resorts", resortRepo.findAll());
		return "resortResults";
	}
	
	@GetMapping("/inputResort")	
	public String addNewResort(Model model) {
		Resort r = new Resort();
		model.addAttribute("newResort", r);
		return "resortInput";
	}
	
	@PostMapping("/inputResort") 
	public String addNewResort(@ModelAttribute Resort r, Model model) {
		resortRepo.save(r);
		return viewAllResorts(model);
	}
	
	@GetMapping("edit/{resortId}")
	public String showUpdateResort(@PathVariable("resortId") long resortId, Model model) {
		Resort r = resortRepo.findById(resortId).orElse(null);
		model.addAttribute("newResort", r);
		return "resortInput";
	}
	
	@PostMapping("/update/{resortId}")
	public String reviseResort(Resort r, Model model) {
		resortRepo.save(r);
		return viewAllResorts(model);
	}
	
	@GetMapping("/delete/{resortId}")
	public String deleteUser(@PathVariable("resortId") long resortId, Model model) {
		Resort r = resortRepo.findById(resortId).orElse(null);
		resortRepo.delete(r);
		return viewAllResorts(model);
	}
}