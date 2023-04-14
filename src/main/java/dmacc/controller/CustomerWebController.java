/**
 * Michael Van Riessen - mjvanriessen
 * CIS175 - Spring 2023
 * Apr 5, 2023
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Customer;
import dmacc.repository.CustomerRepository;

@Controller
public class CustomerWebController {
	@Autowired
	CustomerRepository customerRepo;
	
//	@GetMapping("/index")
//	public String returnHome() {
//		return "index";
//	}
	
	@GetMapping("/viewAllCustomers")
	public String viewAllCustomers(Model model) {
		if(customerRepo.findAll().isEmpty()) {
			return addNewCustomers(model);
		}
		model.addAttribute("customer", customerRepo.findAll());
		return "customerResults";
	}
	
	@GetMapping("/inputCustomer")
	public String addNewCustomers(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "customerInput";
	}
	
	@PostMapping("/inputCustomer")
	public String addNewCustomers(@ModelAttribute Customer c, Model model) {
		customerRepo.save(c);
		return viewAllCustomers(model);
	}
	
	@GetMapping("editCustomer/{customerId}")
	public String showUpdateCustomers(@PathVariable("customerId") long customerId, Model model) {
		Customer c = customerRepo.findById(customerId).orElse(null);
		model.addAttribute("newCustomer", c);
		return "customerInput";
	}
	
	@PostMapping("/updateCustomer/{customerId}")
	public String updateCustomerInfo(Customer c, Model model) {
		customerRepo.save(c);
		return viewAllCustomers(model);
	}
	
	@GetMapping("/deleteCustomer/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") long customerId, Model model) {
		Customer c = customerRepo.findById(customerId).orElse(null);
		customerRepo.delete(c);
		return viewAllCustomers(model);
	}

}
